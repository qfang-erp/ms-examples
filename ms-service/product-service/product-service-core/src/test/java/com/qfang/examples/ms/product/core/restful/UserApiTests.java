package com.qfang.examples.ms.product.core.restful;

import com.qfang.examples.ms.product.api.model.User;
import com.qfang.examples.ms.product.core.ProductServiceApplication;
import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProductServiceApplication.class)  // spring boot 启动类
public class UserApiTests {

    @Autowired
    private UserApi userApi;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userApi).build();
    }

    @Test
    public void findByUsernameTest() throws Exception {
        mockMvc.perform(get("/api/user/findByUsername").param("username", "lisi"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUsername("wangwu");
        user.setName("王五");
        user.setAge(11);
        user.setBalance(new BigDecimal("55.55"));

        JSONObject userJsonObject = JSONObject.fromObject(user);
        String usrJson = userJsonObject.toString();

        mockMvc.perform(
                post("/api/user/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usrJson)
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void listTest() throws Exception {
        mockMvc.perform(
                get("/api/user/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("username", "zhangsan")
                        .param("currentPage", "1")
                        .param("pageSize", "10")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
