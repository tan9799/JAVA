package com.hdu.historianai.controller;

import com.hdu.historianai.dto.GenerateRequest;
import com.hdu.historianai.dto.GenerateResponse;
import com.hdu.historianai.service.CreativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/creative")
@CrossOrigin(origins = "*")
public class CreativeController {

    @Autowired
    private CreativeService creativeService;

    @PostMapping("/generate")
    public GenerateResponse generate(@RequestBody GenerateRequest request) {
        return creativeService.generateBlindBox(request.getPrompt());
    }

    @GetMapping("/health")
    public String health() {
        return "杭电印迹 · AI文创盲盒生成器 正在运行";
    }
}