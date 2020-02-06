package com.hezhe.springsecurity;

import com.hezhe.springsecurity.mapper.UserMapper;
import com.hezhe.springsecurity.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringsecurityApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User hezhe = userMapper.getUserByUsername("hezhe");
        System.out.println(hezhe);
    }
}
