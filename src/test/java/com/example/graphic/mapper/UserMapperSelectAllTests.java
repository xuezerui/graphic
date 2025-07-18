package com.example.graphic.mapper;

import com.example.graphic.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperSelectAllTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectAllUsers() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
} 