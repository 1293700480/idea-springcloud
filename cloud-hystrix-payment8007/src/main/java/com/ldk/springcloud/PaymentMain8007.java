package com.ldk.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @class: PaymentMain8007
 * @author:
 * @date: 2020/12/5 9:49
 * @description: main
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8007.class,args);
    }

    /**
     * @author
     * @description 为了服务器监控而配置，与服务器本身无关
     * ServletRegistrationBean因为springboot默认路径不是/hystrix.stream
     * 只需配置上下面servlet
     * @param
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     */

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
