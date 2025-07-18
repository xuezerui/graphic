package com.example.graphic.controller;

import com.example.graphic.entity.Image;
import com.example.graphic.service.ImageService;
import com.example.graphic.service.UserActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 图片相关接口
 */
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private final UserActivityLogService logService;

    /**
     * 批量上传图片
     *
     * @param files  图片文件
     * @param userId 上传用户 ID
     * @return 保存后的图片列表
     */
    @PostMapping("/upload")
    public List<Image> upload(@RequestParam("files") MultipartFile[] files,
                              @RequestParam("userId") Long userId) {
        List<Image> list = imageService.uploadImages(files, userId);
        logService.log(userId, "UPLOAD_IMAGES", "上传图片数量=" + files.length, "success:" + list.size());
        return list;
    }

    /**
     * 图片搜索 / 排序
     *
     * 当 keyword 或 tag 为空时，按 sortBy 排序返回全部图片
     */
    @GetMapping("/list")
    public List<Image> list(@RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "tag", required = false) String tag,
                            @RequestParam(value = "sortBy", required = false, defaultValue = "time") String sortBy) {
        if ((keyword != null && !keyword.isBlank()) || (tag != null && !tag.isBlank())) {
            return imageService.search(keyword, tag);
        }
        return imageService.listSorted(sortBy);
    }
} 