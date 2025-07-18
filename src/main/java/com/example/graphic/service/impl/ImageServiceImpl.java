package com.example.graphic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graphic.entity.Image;
import com.example.graphic.mapper.ImageMapper;
import com.example.graphic.service.ImageService;
import com.example.graphic.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 图片相关业务实现
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

    /**
     * 图片本地存储路径，可通过 application.yaml 配置 storage.image-path，否则默认 uploads 目录
     */
    @Value("${storage.image-path:uploads}")
    private String imageStoragePath;

    private final TagService tagService;

    @Override
    public List<Image> uploadImages(MultipartFile[] files, Long userId) {
        if (files == null || files.length == 0) {
            return Collections.emptyList();
        }

        Path uploadDir = Paths.get(imageStoragePath);
        try {
            Files.createDirectories(uploadDir);
        } catch (IOException e) {
            throw new RuntimeException("无法创建上传目录", e);
        }

        LocalDateTime now = LocalDateTime.now();
        List<Image> savedList = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file == null || file.isEmpty()) {
                continue;
            }
            String originalFilename = Objects.requireNonNull(file.getOriginalFilename());
            String ext = originalFilename.contains(".") ? originalFilename.substring(originalFilename.lastIndexOf('.')) : "";
            String filename = UUID.randomUUID() + ext;
            Path dest = uploadDir.resolve(filename);

            try (InputStream in = file.getInputStream()) {
                Files.copy(in, dest, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                log.error("保存文件失败：{}", originalFilename, e);
                continue;
            }

            Image image = new Image();
            image.setUserId(userId);
            image.setFilePath(dest.toString());
            image.setUploadTime(now);
            save(image);

            // 调用标签生成服务（异步 / 同步皆可，这里同步演示）
            try {
                tagService.generateTagsForImage(image);
            } catch (Exception ex) {
                log.warn("生成标签失败，imageId={}", image.getId(), ex);
            }

            savedList.add(image);
        }
        return savedList;
    }

    @Override
    public List<Image> search(String keyword, String tag) {
        LambdaQueryWrapper<Image> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(keyword)) {
            wrapper.like(Image::getFilePath, keyword);
        }
        // 通过标签筛选
        if (StringUtils.hasText(tag)) {
            List<Long> imageIds = tagService.findImageIdsByTagName(tag);
            if (imageIds.isEmpty()) {
                return Collections.emptyList();
            }
            wrapper.in(Image::getId, imageIds);
        }
        return list(wrapper);
    }

    @Override
    public List<Image> listSorted(String sortBy) {
        LambdaQueryWrapper<Image> wrapper = new LambdaQueryWrapper<>();
        switch (sortBy == null ? "" : sortBy) {
            case "time":
                wrapper.orderByDesc(Image::getUploadTime);
                break;
            // frequency 排序待补充，这里仅示例
            default:
                wrapper.orderByDesc(Image::getId);
        }
        return list(wrapper);
    }
} 