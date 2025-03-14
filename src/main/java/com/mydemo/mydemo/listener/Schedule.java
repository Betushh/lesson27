package com.mydemo.mydemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Timer;

@Slf4j
@Configuration
@EnableScheduling
@EnableAsync
public class Schedule {

//    @Scheduled(fixedDelay = 5000)
//    public void scheduleFixedDelayTask(){
//        log.info("Fixed delay - "+ System.currentTimeMillis()/1000);
//    }

//    @Async
//    @Scheduled(fixedRate = 5000, initialDelay = 10000)
//    public void scheduleFixedRateTask(){
//        log.info("Fixed rate - "+ System.currentTimeMillis()/1000);
//    }
//
//    @Scheduled(cron = "0 45 13 * * ?", zone = "Asia/Baku")
//    public void scheduleCron(){
//        log.info("Fixed cron - "+ System.currentTimeMillis()/1000);
//    }
}
