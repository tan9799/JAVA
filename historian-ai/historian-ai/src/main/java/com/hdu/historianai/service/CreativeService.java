package com.hdu.historianai.service;

import com.hdu.historianai.dto.GenerateResponse;
import com.hdu.historianai.util.StyleRandomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreativeService {

    @Autowired
    private DashScopeTextService textService;

    @Autowired
    private WanxImageService imageService;

    // 确保方法签名是 public GenerateResponse generateBlindBox(String userPrompt)
    public GenerateResponse generateBlindBox(String userPrompt) {
        // 1. 随机抽取风格
        String style = StyleRandomizer.getRandomStyle();

        // 2. 生成专业英文绘图提示词
        String imagePrompt = textService.buildImagePrompt(userPrompt, style);

        // 3. 调用通义万相生成图片（真正图片）
        String imageUrl = imageService.generateImage(imagePrompt);

        // 4. 生成配图文案
        String caption = textService.generateCaption(userPrompt, style);

        // 5. 模拟集卡进度
        int collectedCount = (int)(Math.random() * 4);

        return new GenerateResponse(style, caption, imageUrl, collectedCount);
    }
}