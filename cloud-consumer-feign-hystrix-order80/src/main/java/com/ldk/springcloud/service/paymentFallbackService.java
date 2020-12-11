package com.ldk.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @class: paymentFallbackService
 * @author:
 * @date: 2020/12/8 10:27
 * @description:
 */
@Component
public class paymentFallbackService implements PymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----------paymentFallbackService fall back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------paymentFallbackService fall back";
    }
}
