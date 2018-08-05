package com.qfang.examples.ms.product.api.feign;

import com.qfang.examples.ms.product.api.FeignLogConfiguration;
import com.qfang.examples.ms.product.api.ProductServiceApi;
import com.qfang.examples.ms.product.api.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@FeignClient(name = ProductServiceApi.SERVER_NAME, configuration = FeignLogConfiguration.class, fallback = UserRemoteClientFallback.class)
public interface UserRemoteClient {

    @RequestMapping(value = "/api/user/findByUsername", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    User findByUsername(@RequestParam("username") String username);

    @RequestMapping(value = "/api/user/list", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<User> list(@RequestParam Map<String, Object> queryMap);

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    void insert(@RequestBody User user);

}
