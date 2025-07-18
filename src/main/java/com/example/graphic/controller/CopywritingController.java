package com.example.graphic.controller;

import com.example.graphic.service.CopywritingService;
import com.example.graphic.service.UserActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 文案生成接口
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/copywriting")
public class CopywritingController {

    private final CopywritingService copywritingService;
    private final UserActivityLogService logService;

    /**
     * 生成短句文案
     */
    @PostMapping("/images/{imageId}/short")
    public String generateShort(@PathVariable Long imageId,
                                @RequestParam(value = "style", required = false, defaultValue = "default") String style,
                                @RequestParam(value = "userId", required = false) Long userId) {
        String content = copywritingService.generateShortSentence(imageId, style);
        if (userId != null) {
            logService.log(userId, "GENERATE_SHORT", "imageId=" + imageId, content);
        }
        return content;
    }

    /**
     * 生成长句文案
     */
    @PostMapping("/images/{imageId}/long")
    public String generateLong(@PathVariable Long imageId,
                               @RequestParam(value = "style", required = false, defaultValue = "default") String style,
                               @RequestParam(value = "userId", required = false) Long userId) {
        String content = copywritingService.generateLongSentence(imageId, style);
        if (userId != null) {
            logService.log(userId, "GENERATE_LONG", "imageId=" + imageId, content);
        }
        return content;
    }
} 