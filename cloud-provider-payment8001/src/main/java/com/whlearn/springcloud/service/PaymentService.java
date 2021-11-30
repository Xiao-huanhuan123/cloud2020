package com.whlearn.springcloud.service;

import com.whlearn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author XieWenhuan
 * @Date 2021/11/6 15:53
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
