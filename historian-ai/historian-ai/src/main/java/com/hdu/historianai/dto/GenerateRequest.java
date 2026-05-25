package com.hdu.historianai.dto;

import lombok.Data;

@Data
public class GenerateRequest {
    private String prompt;   // 用户输入，如“图书馆5楼靠窗，夕阳”
}