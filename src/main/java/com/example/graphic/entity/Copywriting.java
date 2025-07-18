package com.example.graphic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文案生成记录实体
 */
@Data
@TableName("copywritings")
public class Copywriting implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long imageId;

    /** 生成的文案内容 */
    private String content;

    /** 文案风格 */
    private String style;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;
} 