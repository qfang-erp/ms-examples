package com.qfang.examples.ms.product.core;

import brave.internal.Platform;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import zipkin2.Span;
import zipkin2.reporter.Reporter;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = "com.qfang.examples.ms.product")
@EnableTransactionManagement
public class ProductServiceApplication {

//    @Bean
//    Reporter<Span> logSpanReporter() {
//        return Platform.get().reporter();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
