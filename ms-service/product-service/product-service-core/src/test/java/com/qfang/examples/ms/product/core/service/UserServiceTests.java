package com.qfang.examples.ms.product.core.service;

import com.qfang.examples.ms.product.api.model.User;
import com.qfang.examples.ms.product.core.ProductServiceBaseTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
public class UserServiceTests extends ProductServiceBaseTests {

    @Autowired
    private UserService userService;

    @Test
    public void findByNameTest() {
        User user = userService.findByUsername("zhangsan");
        Assert.assertNotNull(user);
        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo("张三");
    }

    @Test
    public void listUser() {
        List<User> users = userService.listUser();
        assertThat(users.size()).isEqualTo(2);
        assertThat(users.stream().map(User::getUsername).collect(Collectors.toList()))
                .containsOnly("zhangsan", "lisi");
    }

}
