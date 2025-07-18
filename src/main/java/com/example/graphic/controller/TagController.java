package com.example.graphic.controller;

import com.example.graphic.entity.Tag;
import com.example.graphic.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 标签接口
 */
@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    /**
     * 获取全部标签
     */
    @GetMapping("/list")
    public List<Tag> list() {
        return tagService.list();
    }

    /**
     * 新增标签
     * 请求体示例：{"name":"新品"}
     */
    @PostMapping("/create")
    public boolean create(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    /**
     * 根据 ID 删除标签
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return tagService.removeById(id);
    }
} 