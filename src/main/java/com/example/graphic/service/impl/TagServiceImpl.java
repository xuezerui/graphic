package com.example.graphic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graphic.entity.Image;
import com.example.graphic.entity.Tag;
import com.example.graphic.mapper.TagMapper;
import com.example.graphic.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 标签业务实现
 */
@Service
@Slf4j
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Override
    public List<Tag> generateTagsForImage(Image image) {
        // TODO 调用 AI 服务进行图片识别，生成标签数据，这里先用占位逻辑
        if (image == null) {
            return Collections.emptyList();
        }
        // 示例：为所有图片生成一个 "default" 标签
        Tag tag = new Tag();
        tag.setName("default");
        save(tag);
        return Collections.singletonList(tag);
    }

    @Override
    public List<Long> findImageIdsByTagName(String tagName) {
        if (!StringUtils.hasText(tagName)) {
            return Collections.emptyList();
        }
        LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Tag::getName, tagName);
        List<Tag> tags = list(wrapper);
        // 由于 Tag 实体目前没有 imageId 字段，这里仅作为占位返回空列表
        // 可根据实际业务增加 tag - image 关联表
        return tags.stream().map(Tag::getId).collect(Collectors.toList());
    }
} 