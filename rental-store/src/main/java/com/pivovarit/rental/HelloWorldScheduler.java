package com.pivovarit.rental;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
class HelloWorldScheduler {

    @Scheduled(cron = "* * * * * *")
    public static void hello() {
        System.out.println("Hello!");
    }
}
