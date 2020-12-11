package com.ldk.springcloud.service;

import com.ldk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author lidakang
 */
public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id")Long id);
}
