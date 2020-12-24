package com.ldk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @class: NacosProviderDemoApp
 * @author:
 * @date: 2020/12/22 15:27
 * @description: main
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderDemoApp.class,args);
    }
}
