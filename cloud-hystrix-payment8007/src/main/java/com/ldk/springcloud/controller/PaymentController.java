package com.ldk.springcloud.controller;

import com.ldk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @class: PaymentController
 * @author:
 * @date: 2020/12/7 14:23
 * @description: controller
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("$(server.port)")
    private String serverPort;
@GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
    String result = paymentService.paymentInfo_ok(id);
    log.info(result);
    return result;
}
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info(result);
        return result;
    }
    // 服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("************"+result);
        return result;
    }
}
