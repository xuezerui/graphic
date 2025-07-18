package com.example.graphic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 标签实体
 */
@Data
@TableName("tags")
public class Tag implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 标签名称 */
    private String name;
} 