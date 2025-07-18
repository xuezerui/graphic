package com.example.graphic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.graphic.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 图片相关业务接口
 */
public interface ImageService extends IService<Image> {

    /**
     * 批量上传图片
     *
     * @param files  图片文件数组
     * @param userId 上传用户 ID
     * @return 保存后的 {@link Image} 列表
     */
    List<Image> uploadImages(MultipartFile[] files, Long userId);

    /**
     * 根据关键字或标签搜索图片
     *
     * @param keyword 关键字（可匹配文件名 / 文案内容等）
     * @param tag     标签名称，可为空
     * @return 匹配到的图片列表
     */
    List<Image> search(String keyword, String tag);

    /**
     * 获取排序后的图片列表
     *
     * @param sortBy 排序字段，可选值：time、tag、frequency
     * @return 排序后的图片列表
     */
    List<Image> listSorted(String sortBy);
} 