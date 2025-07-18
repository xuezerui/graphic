package com.example.graphic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户账户实体
 */
@Data
@TableName("users")
public class User implements Serializable {

    /** 用户ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户名 */
    private String username;

    /** 加密密码 */
    private String password;

    /** 邮箱 */
    private String email;

    /** 状态（1-正常 0-禁用） */
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;
} 