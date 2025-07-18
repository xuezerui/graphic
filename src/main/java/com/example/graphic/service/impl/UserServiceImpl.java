package com.example.graphic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graphic.entity.User;
import com.example.graphic.mapper.UserMapper;
import com.example.graphic.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    // 目前无额外业务逻辑，后续按需扩展
} 