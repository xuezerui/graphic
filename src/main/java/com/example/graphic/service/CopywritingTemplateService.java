package com.example.graphic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.graphic.entity.CopywritingTemplate;

/**
 * 文案模板业务接口
 */
public interface CopywritingTemplateService extends IService<CopywritingTemplate> {

    /**
     * 根据文案风格获取 AI 提示词模板
     *
     * @param style 文案风格
     * @return 提示词模板
     */
    String getPromptByStyle(String style);
} 