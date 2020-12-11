package com.ldk.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @class: PymentHystrixService
 * @author:
 * @date: 2020/12/7 15:26
 * @description:
 */
@Component
@FeignClient(value ="CLOUD-PROVIDER-HYSTRIX-PAYMENT" ,fallback = paymentFallbackService.class)
public interface PymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id);
}
