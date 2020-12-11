package com.ldk.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @class: PaymentService
 * @author:
 * @date: 2020/12/5 13:49
 * @description: service
 */
@Service
public class PaymentService {
    /**
     * @return java.lang.String
     * @author
     * @description正常访问
     */

    public String paymentInfo_ok(Integer id) {
        return "线程池 :" + Thread.currentThread().getName() + "paymentInfo_OK,id" + id;
    }

    /**
     * @return java.lang.String
     * @author
     * @description超时访问
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 :" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id" + id + "耗时3s";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池 :" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler,id" + id + "挂掉了";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentInfoCircuit", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率
            // 加起来就是在10s内的10次请求中如果失败超过6次进入服务熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "调用成功：" + serialNumber;
    }

    public String paymentInfoCircuit(Integer id) {
        return "id不能为负数：" + id;
    }
}
