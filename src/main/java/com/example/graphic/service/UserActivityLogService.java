package com.example.graphic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.graphic.entity.UserActivityLog;

/**
 * 用户操作日志业务接口
 */
public interface UserActivityLogService extends IService<UserActivityLog> {

    /**
     * 记录用户操作日志
     *
     * @param userId        用户 ID
     * @param activityType  操作类型
     * @param content       用户输入内容
     * @param aiResponse    AI 返回内容
     */
    void log(Long userId, String activityType, String content, String aiResponse);
} 