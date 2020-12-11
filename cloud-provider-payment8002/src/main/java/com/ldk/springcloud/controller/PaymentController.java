package com.ldk.springcloud.controller;

import com.ldk.springcloud.entities.CommonResult;
import com.ldk.springcloud.entities.Payment;
import com.ldk.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lidakang
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,serverPort:"+serverPort, result);
        } else {

            return new CommonResult(444, "插入失败", null);
        }
}
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***插入结果" + payment);
        if (payment !=null) {

            return new CommonResult(200, "成功--------serverPort:"+serverPort, payment);
        } else {

            return new CommonResult(444, "没有记录，id："+id, null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
