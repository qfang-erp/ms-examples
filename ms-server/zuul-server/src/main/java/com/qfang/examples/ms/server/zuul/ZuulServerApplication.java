package com.qfang.examples.ms.server.zuul;

import brave.internal.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.SpanAdjuster;
import org.springframework.context.annotation.Bean;
import zipkin2.Span;
import zipkin2.reporter.Reporter;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulServerApplication {

    private static final Logger log = LoggerFactory.getLogger(ZuulServerApplication.class);

    @Bean
    SpanAdjuster logSpanAdjuster() {
        return span -> {
            log.info(span.toString());
            return span;
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

}
