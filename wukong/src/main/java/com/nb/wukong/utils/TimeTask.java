package com.nb.wukong.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时打印时间
 */
@Component
public class TimeTask {

    /**
     * 每60秒钟输出一次时间
     */
    @Scheduled(fixedRate = 600000)
    public void printTime(){
        System.out.println("执行定时任务的时间是："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
