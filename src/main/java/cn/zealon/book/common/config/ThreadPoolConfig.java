package cn.zealon.book.common.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.*;

/**
 * 线程池配置
 * @author: zealon
 * @since: 2019/11/29
 */
@Configuration
public class ThreadPoolConfig {

    @Bean(value = "messageQueueThreadPool")
    public ExecutorService buildMessageQueueThreadPool(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("message-queue-thread-%d").build();
        // 实例化线程池
        ExecutorService pool = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5000),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        return pool;
    }
}
