package cn.zealon.book.core.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author: zealon
 */
@Component
@EnableScheduling
public class ScheduleTask {

    /**
     * 文件审核任务（24小时自动通过）

    @Scheduled(cron = "0 0/1 * * * ?")
    private void deleteFileTask() {
        // 先发消息
    }*/
}
