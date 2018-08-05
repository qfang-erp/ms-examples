package com.qfang.examples.ms.product.api;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@Configuration
public class FeignLogConfiguration {

    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }

}
