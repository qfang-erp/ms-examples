package com.qfang.examples.ms.product.web.controller;

import com.qfang.examples.ms.product.api.feign.UserRemoteClient;
import com.qfang.examples.ms.product.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRemoteClient userRemoteClient;

    @ResponseBody
    @RequestMapping("/findByUsername")
    public User findByUsername(String username) {
        return userRemoteClient.findByUsername(username);
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<User> list() {
        Map<String, Object> queryMap = new HashMap<>();
        return userRemoteClient.list(queryMap);
    }

    @RequestMapping("/insert")
    public void insert() {
        User user = new User(100L, "test");
        user.setName("测试");
        userRemoteClient.insert(user);
    }

}
