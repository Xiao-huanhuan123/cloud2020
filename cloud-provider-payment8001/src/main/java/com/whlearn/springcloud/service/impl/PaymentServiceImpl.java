package com.whlearn.springcloud.service.impl;

import com.whlearn.springcloud.dao.PaymentDao;
import com.whlearn.springcloud.entities.Payment;
import com.whlearn.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author XieWenhuan
 * @Date 2021/11/6 15:54
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired(required = false)
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
