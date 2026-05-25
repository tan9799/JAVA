package com.hdu.historianai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DashScopeConfig {
    @Value("${dashscope.api-key}")
    private String apiKey;

    @Value("${dashscope.text-model}")
    private String textModel;

    @Value("${dashscope.image-model}")
    private String imageModel;

    public String getApiKey() {
        return apiKey;
    }

    public String getTextModel() {
        return textModel;
    }

    public String getImageModel() {
        return imageModel;
    }
}