package com.example.graphic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 文案模板实体
 */
@Data
@TableName("copywriting_templates")
public class CopywritingTemplate implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 文案风格 */
    private String style;

    /** AI 提示词模板 */
    private String prompt;
} 