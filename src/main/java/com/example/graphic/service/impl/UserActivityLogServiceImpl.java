package com.example.graphic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graphic.entity.UserActivityLog;
import com.example.graphic.mapper.UserActivityLogMapper;
import com.example.graphic.service.UserActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户操作日志业务实现
 */
@Service
public class UserActivityLogServiceImpl extends ServiceImpl<UserActivityLogMapper, UserActivityLog> implements UserActivityLogService {

    @Override
    public void log(Long userId, String activityType, String content, String aiResponse) {
        UserActivityLog log = new UserActivityLog();
        log.setUserId(userId);
        log.setActivityType(activityType);
        log.setContent(content);
        log.setAiResponse(aiResponse);
        log.setCreatedTime(LocalDateTime.now());
        save(log);
    }
} 