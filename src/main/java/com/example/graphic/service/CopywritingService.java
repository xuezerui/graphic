package com.example.graphic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.graphic.entity.Copywriting;

/**
 * 文案生成业务接口
 */
public interface CopywritingService extends IService<Copywriting> {

    /**
     * 生成短句社交文案
     *
     * @param imageId 关联图片 ID
     * @param style   文案风格，如促销型、温暖型、专业型
     * @return 文案内容
     */
    String generateShortSentence(Long imageId, String style);

    /**
     * 生成长句营销话术
     *
     * @param imageId 关联图片 ID
     * @param style   文案风格
     * @return 文案内容
     */
    String generateLongSentence(Long imageId, String style);
} 