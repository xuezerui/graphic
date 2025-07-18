package com.example.graphic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.graphic.entity.Tag;
import com.example.graphic.entity.Image;

import java.util.List;

/**
 * 标签相关业务接口
 */
public interface TagService extends IService<Tag> {

    /**
     * 为指定图片生成并保存标签（自动识别 / AI 模型）
     *
     * @param image 图片实体
     * @return 生成的标签列表
     */
    List<Tag> generateTagsForImage(Image image);

    /**
     * 根据标签名称查询对应图片 ID 集合
     *
     * @param tagName 标签名称
     * @return 图片 ID 列表
     */
    List<Long> findImageIdsByTagName(String tagName);
} 