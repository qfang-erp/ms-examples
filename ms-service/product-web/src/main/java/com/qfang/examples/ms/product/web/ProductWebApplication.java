package com.qfang.examples.ms.product.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@EnableFeignClients("com.qfang.examples.ms")
@EnableCircuitBreaker  // 开启服务降级断路器
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class ProductWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductWebApplication.class, args);
    }

}
