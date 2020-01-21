package cn.zealon.book.system.security.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * redis实现共享session
 */
@Component
public class RedisSessionDAO extends EnterpriseCacheSessionDAO {

    private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;
    
    // 创建session，保存到数据库
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        logger.info("创建session:{}", session.getId());
        return sessionId;
    }

    // 获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
        // 先从缓存中获取session，如果没有再去数据库中获取
    	logger.info("读取session:{}",sessionId);
        Session session = super.doReadSession(sessionId);
        return session;
    }

    // 更新session的最后一次访问时间
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
    }

    // 删除session
    @Override
    protected void doDelete(Session session) {
        logger.info("删除session:{}",session.getId());
        super.doDelete(session);
    }
    
    //protected Collection<Session> getActiveSessions
}
