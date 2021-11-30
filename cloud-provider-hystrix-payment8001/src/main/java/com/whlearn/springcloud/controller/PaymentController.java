package com.whlearn.springcloud.controller;

import com.whlearn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author XieWenhuan
 * @Date 2021/11/20 11:33
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentinfo_OK(@PathVariable("id") Integer id){
        String result =  paymentService.paymentinfo_OK(id);
        log.info("********result: " + result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentinfo_Timeout(@PathVariable("id") Integer id){
        String result =  paymentService.paymentinfo_Timeout(id);
        log.info("********result: " + result);
        return result;
    }

    //服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("******result: " + result);
        return result;
    }
}
