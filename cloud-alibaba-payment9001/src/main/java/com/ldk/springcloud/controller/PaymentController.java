package com.ldk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: PaymentController
 * @author:
 * @date: 2020/12/21 11:35
 * @description: controller
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos reggistry,serverPort:"+serverPort+"\t id"+id;
    }
}
