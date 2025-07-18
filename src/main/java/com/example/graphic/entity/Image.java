package com.example.graphic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 图片基础信息实体
 */
@Data
@TableName("images")
public class Image implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 上传用户ID */
    private Long userId;

    /** 文件存储路径 */
    private String filePath;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime uploadTime;
} 