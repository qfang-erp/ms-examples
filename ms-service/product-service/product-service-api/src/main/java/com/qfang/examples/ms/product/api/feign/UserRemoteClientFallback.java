package com.qfang.examples.ms.product.api.feign;

import com.qfang.examples.ms.product.api.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@Slf4j
public class UserRemoteClientFallback {

    public User findByUsername(String username, Throwable e) {
        log.error("ProductRemoteClientFallback#findByUsername", e);
        return new User(-1L, "fallback");
    }

    public List<User> list(Map<String, Object> queryMap, Throwable e) {
        log.error("ProductRemoteClientFallback#list", e);
        return new ArrayList<>();
    }
}
