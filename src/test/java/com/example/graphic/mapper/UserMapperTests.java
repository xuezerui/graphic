package com.example.graphic.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graphic.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsertAndSelect() {
        User user = new User();
        String unique = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        user.setUsername("user_" + unique);
        user.setPassword("pwd123");
        user.setEmail(unique + "@example.com");
        user.setStatus(1);
        user.setCreatedTime(LocalDateTime.now());

        int rows = userMapper.insert(user);
        assertEquals(1, rows);
        assertNotNull(user.getId());

        User dbUser = userMapper.selectById(user.getId());
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
} 