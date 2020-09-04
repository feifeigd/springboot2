package com.d7kj.test;

import com.d7kj.controller.UserController;
import com.d7kj.entity.User;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.d7kj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
// 需要模拟测试的 Controller
//@WebMvcTest(UserController.class)
@SpringBootTest(classes = UserController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class UserControllerTest {
    @Autowired
    MockMvc mvc;

    // 注入一个服务
    @MockBean
    UserService userService;

    @Test
    public void testMvc() throws Exception{
        // 至少要有一个 @Test
        int userId = 10;
        int expectedCredit = 100;
        // 模拟 userService
        given(userService.getCredit(anyInt())).willReturn(100);
        // http 调用
        mvc.perform(MockMvcRequestBuilders.get("/user/{id}", userId))
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedCredit)));
    }

    public void updateUser() throws Exception {
        int userId = 1;
        String name = "hili";
        int expectedCredit = 100;
        given(userService.updateUser(any(User.class))).willReturn(true);
        String path = "$.success";  // json路径
        mvc.perform(MockMvcRequestBuilders.get("/user/{id}/{name}", userId, name))
                .andExpect(MockMvcResultMatchers.jsonPath(path).value(true));
    }
}
