package com.pivovarit.rental;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
class HelloWorldScheduler {

    @Scheduled(cron = "* * * * * 0")
    public static void hello() {
        System.out.println("Scheduled hello!");
    }
}
