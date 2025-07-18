package com.example.graphic.controller;

import com.example.graphic.entity.User;
import com.example.graphic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户接口示例
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<User> users() {
        return userService.list();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody User user) {
        return userService.save(user);
    }
} 