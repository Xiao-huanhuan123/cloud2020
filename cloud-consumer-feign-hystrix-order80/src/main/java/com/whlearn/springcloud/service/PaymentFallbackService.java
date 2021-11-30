package com.whlearn.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author XieWenhuan
 * @Date 2021/11/21 16:02
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentinfo_OK(Integer id) {
        return "----service paymentinfo_OK fallback, o(╥﹏╥)o";
    }

    @Override
    public String paymentinfo_Timeout(Integer id) {
        return "----service paymentinfo_Timeout fallback, o(╥﹏╥)o";
    }
}
