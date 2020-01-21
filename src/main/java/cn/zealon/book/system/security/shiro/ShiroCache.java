package cn.zealon.book.system.security.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * shiro缓存管理
 *
 */
@SuppressWarnings({ "unchecked", "unused" })
public class ShiroCache<K, V> implements Cache<K, V> {

    private Charset charset;
    public static final String REDIS_SHIRO_CACHE = "";
    private String cacheKey;
    private RedisTemplate<K, V> redisTemplate;
    /** 分 */
    private long globExpire = 600;
    
    @SuppressWarnings("rawtypes")
    public ShiroCache(String name, RedisTemplate client) {
        this.cacheKey = REDIS_SHIRO_CACHE + name +":";
        this.redisTemplate = client;
    }

    @Override
    public V get(K key) throws CacheException {
        redisTemplate.boundValueOps(getCacheKey(key)).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        V old = get(key);
        redisTemplate.opsForValue().set(getCacheKey(key), value,globExpire, TimeUnit.MINUTES);
        return old;
    }

    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    private K getCacheKey(Object k) {
    	
        return (K) (this.cacheKey + k);
    }
}