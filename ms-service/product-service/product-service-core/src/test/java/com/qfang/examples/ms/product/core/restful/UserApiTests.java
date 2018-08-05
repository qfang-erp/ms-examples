package com.qfang.examples.ms.product.core.restful;

import com.qfang.examples.ms.product.core.ProductServiceBaseTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-08-05
 * @since: 1.0
 */
public class UserApiTests extends ProductServiceBaseTests {

    @Autowired
    private UserApi userApi;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userApi).build();
    }

    @Test
    public void findByUsernameTest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/api/user/findByUsername").param("username", "lisi"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse();
        System.out.println(response.getContentAsString());
    }

    @Test
    public void listTest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/api/user/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse();
        System.out.println(response.getContentAsString());
    }


}
