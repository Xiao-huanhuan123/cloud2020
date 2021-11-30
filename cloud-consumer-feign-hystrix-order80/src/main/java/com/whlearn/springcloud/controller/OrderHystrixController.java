package com.whlearn.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.whlearn.springcloud.service.PaymentHystrixService;

/**
 * @Author XieWenhuan
 * @Date 2021/11/20 15:04
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallBack")
public class OrderHystrixController {

    @Autowired
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentinfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentinfo_OK(id);
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
//    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallBackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    public String paymentinfo_Timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentinfo_Timeout(id);
    }
    public String paymentTimeoutFallBackMethod(@PathVariable("id") Integer id){

        return "服务调用繁忙或者异常 "  + "\t o(╥﹏╥)o";
    }

    public String paymentGlobalFallBack(){
        return "Global异常处理信息，调用超时或者服务异常";
    }


}
