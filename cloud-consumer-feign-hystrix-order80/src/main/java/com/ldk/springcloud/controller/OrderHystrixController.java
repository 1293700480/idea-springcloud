package com.ldk.springcloud.controller;

import com.ldk.springcloud.service.PymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @class: PaymentHystrixController
 * @author:
 * @date: 2020/12/7 15:29
 * @description:
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {
    @Resource
    private PymentHystrixService pymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String paymentInfoOk = pymentHystrixService.paymentInfo_ok(id);
        return paymentInfoOk;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String paymentInfoTimeOut = pymentHystrixService.paymentInfo_TimeOut(id);
        return paymentInfoTimeOut;
    }

    public String paymentTimeOutFallback(@PathVariable("id") Integer id) {
        return "订单挂掉了";
    }

    //全局fallback
    public String paymentGlobalFallback() {
        return "全局订单挂掉了";
    }
}
