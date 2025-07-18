package com.example.graphic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graphic.entity.CopywritingTemplate;
import com.example.graphic.mapper.CopywritingTemplateMapper;
import com.example.graphic.service.CopywritingTemplateService;
import org.springframework.stereotype.Service;

/**
 * 文案模板业务实现
 */
@Service
public class CopywritingTemplateServiceImpl extends ServiceImpl<CopywritingTemplateMapper, CopywritingTemplate> implements CopywritingTemplateService {

    @Override
    public String getPromptByStyle(String style) {
        LambdaQueryWrapper<CopywritingTemplate> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CopywritingTemplate::getStyle, style);
        CopywritingTemplate template = getOne(wrapper);
        return template != null ? template.getPrompt() : "";
    }
} 