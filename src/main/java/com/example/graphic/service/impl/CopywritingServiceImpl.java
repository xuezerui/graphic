package com.example.graphic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graphic.entity.Copywriting;
import com.example.graphic.mapper.CopywritingMapper;
import com.example.graphic.service.CopywritingService;
import com.example.graphic.service.CopywritingTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 文案生成业务实现
 */
@Service
@RequiredArgsConstructor
public class CopywritingServiceImpl extends ServiceImpl<CopywritingMapper, Copywriting> implements CopywritingService {

    private final CopywritingTemplateService templateService;

    @Override
    public String generateShortSentence(Long imageId, String style) {
        String prompt = templateService.getPromptByStyle(style);
        // TODO 调用 AI 模型生成文案, 这里简单模拟
        String content = "【短句】" + prompt + " #" + UUID.randomUUID();
        persistCopywriting(imageId, style, content);
        return content;
    }

    @Override
    public String generateLongSentence(Long imageId, String style) {
        String prompt = templateService.getPromptByStyle(style);
        // TODO 调用 AI 模型生成文案, 这里简单模拟
        String content = "【长句】" + prompt + " ..." + UUID.randomUUID();
        persistCopywriting(imageId, style, content);
        return content;
    }

    private void persistCopywriting(Long imageId, String style, String content) {
        Copywriting copy = new Copywriting();
        copy.setImageId(imageId);
        copy.setStyle(style);
        copy.setContent(content);
        copy.setCreatedTime(LocalDateTime.now());
        save(copy);
    }
} 