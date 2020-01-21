package cn.zealon.book.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * redis 配置
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(CacheProperties.class)
public class RedisConfig extends CachingConfigurerSupport {

	@Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}

	/**
	 * Redis模板 默认序列化方式
	 * @param factory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

		RedisTemplate<String, Object> template = new RedisTemplate<>();
		//key序列化
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		template.setConnectionFactory(factory);

		//key序列化方式
		template.setKeySerializer(redisSerializer);

		template.afterPropertiesSet();
		return template;
	}

	/**
	 * Redis模板 Jackson2 序列化方式
	 * @param factory
	 * @return
	 */
	@Bean(name = "redisTemplateJackson")
	public RedisTemplate<String, Object> redisTemplateJackson(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		//key序列化
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		template.setConnectionFactory(factory);

		//key序列化方式
		template.setKeySerializer(redisSerializer);
		//value序列化
		template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));

		template.afterPropertiesSet();
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		return new RedisCacheManager(
			RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
			// 默认策略，未配置的 key 会使用这个
			this.getRedisCacheConfigurationWithTtl(30),
			// 指定 key 策略
			this.getRedisCacheConfigurationMap()
		);
	}

	/**
	 * 指定不同key的缓存策略
	 * @return
	 */
	private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
		Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
		// 菜单json树缓存
		redisCacheConfigurationMap.put("string:menu-tree", this.getRedisCacheConfigurationWithTtl(600));
		// 数据字典缓存
		redisCacheConfigurationMap.put("string:data-dictionary", this.getRedisCacheConfigurationWithTtl(600));

		return redisCacheConfigurationMap;
	}

	/**
	 * 默认key的缓存策略
	 * @param minutes
	 * @return
	 */
	private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer minutes) {
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

		// 配置对象映射
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		// Redis 缓存设置
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();

		redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
				RedisSerializationContext
						.SerializationPair
						.fromSerializer(jackson2JsonRedisSerializer)
		).entryTtl(Duration.ofMinutes(minutes));

		// 自定义前缀 (:一个冒号)
		redisCacheConfiguration = redisCacheConfiguration.computePrefixWith(myKeyPrefix());

		return redisCacheConfiguration;
	}

	/**
	 * key 生成
	 * @return
	 */
	@Bean
	public KeyGenerator simpleKeyGenerator() {
		return (o, method, objects) -> {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(o.getClass().getSimpleName());
			stringBuilder.append(".");
			stringBuilder.append(method.getName());
			stringBuilder.append("[");
			for (Object obj : objects) {
				stringBuilder.append(obj.toString());
			}
			stringBuilder.append("]");
			String build = stringBuilder.toString();
			return build;
		};
	}

	/**
	 * 缓存前缀（追加一个冒号 : ）
	 * @return
	 */
	private CacheKeyPrefix myKeyPrefix(){
		return name -> name + ":";
	}
}
