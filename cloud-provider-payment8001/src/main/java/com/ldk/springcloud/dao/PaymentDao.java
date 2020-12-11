package com.ldk.springcloud.dao;

import com.ldk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lidakang
 */
@Mapper
public interface PaymentDao {
    /**
     * 写
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 读
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id")Long id);

}
