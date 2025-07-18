package com.example.graphic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户操作日志实体
 */
@Data
@TableName("user_activity_logs")
public class UserActivityLog implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 操作类型 */
    private String activityType;

    /** 用户输入内容 */
    private String content;

    /** AI返回内容 */
    private String aiResponse;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;
} 