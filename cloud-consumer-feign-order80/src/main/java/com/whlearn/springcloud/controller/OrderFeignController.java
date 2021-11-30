package com.whlearn.springcloud.controller;

import com.whlearn.springcloud.entities.CommonResult;
import com.whlearn.springcloud.entities.Payment;
import com.whlearn.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author XieWenhuan
 * @Date 2021/11/18 21:47
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymenFeignTimeout(){
        //openfeign-ribbon:客户端一般默认等待1s
        return paymentFeignService.paymenFeignTimeout();
    }
}
