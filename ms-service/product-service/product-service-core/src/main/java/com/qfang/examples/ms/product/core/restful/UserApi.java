package com.qfang.examples.ms.product.core.restful;

import com.qfang.examples.ms.product.api.model.User;
import com.qfang.examples.ms.product.core.service.UserService;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/user/findByUsername", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User findByUsername(@RequestParam("username") String username) {
        Validate.notEmpty(username);
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/api/user/list", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<User> list(@RequestParam Map<String, Object> queryMap) {
        return userService.listUser();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(@RequestBody User user) {
        userService.saveUser(user);
    }


}
