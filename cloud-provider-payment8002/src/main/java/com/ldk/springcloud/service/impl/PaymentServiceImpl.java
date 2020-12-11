package com.ldk.springcloud.service.impl;

import com.ldk.springcloud.dao.PaymentDao;
import com.ldk.springcloud.entities.Payment;
import com.ldk.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lidakang
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);

    }
}
