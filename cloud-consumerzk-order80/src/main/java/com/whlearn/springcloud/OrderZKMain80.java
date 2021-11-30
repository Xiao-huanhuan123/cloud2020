package com.whlearn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author XieWenhuan
 * @Date 2021/11/14 11:30
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向consul或者zookeeper作为注册中心时注册服务
public class OrderZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class,args);
    }

}
