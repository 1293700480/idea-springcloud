package com.ldk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @class: ConsumerDashboard9001Main
 * @author:
 * @date: 2020/12/8 13:45
 * @description:
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerDashboard9001Main {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerDashboard9001Main.class,args);
    }
}
