package com.hdu.historianai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenerateResponse {
    private String style;          // 随机风格
    private String caption;        // 文案
    private String imageUrl;       // 通义万相生成的图片URL
    private int collectedCount;    // 已收集风格数量（模拟）
}