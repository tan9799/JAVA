package com.hdu.historianai.service;

import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesis;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisParam;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisResult;
import com.alibaba.dashscope.common.TaskStatus;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.hdu.historianai.config.DashScopeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WanxImageService {

    @Autowired
    private DashScopeConfig config;

    public String generateImage(String prompt) {
        try {
            // 1. 构建图像生成参数
            ImageSynthesisParam param = ImageSynthesisParam.builder()
                    .apiKey(config.getApiKey())
                    .model(config.getImageModel())
                    .prompt(prompt)
                    .n(1)
                    .size("1024*1024")
                    .build();

            // 2. 调用 API 同步生成图片
            ImageSynthesis imageSynthesis = new ImageSynthesis();
            ImageSynthesisResult result = imageSynthesis.call(param);

            // 3. 检查任务状态并获取结果
            if (result.getOutput() != null && TaskStatus.SUCCEEDED.equals(result.getOutput().getTaskStatus())) {
                // ⭐ 关键修正点：results 是 List<Map<String, String>>，通过 get("url") 获取图片链接
                List<Map<String, String>> results = result.getOutput().getResults();
                if (results != null && !results.isEmpty()) {
                    return results.get(0).get("url");
                } else {
                    return "https://via.placeholder.com/1024?text=No+Image+Generated";
                }
            } else {
                return "https://via.placeholder.com/1024?text=Image+Generation+Failed";
            }
        } catch (ApiException | NoApiKeyException e) {
            e.printStackTrace();
            return "https://via.placeholder.com/1024?text=API+Error:+" + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "https://via.placeholder.com/1024?text=Unexpected+Error";
        }
    }
}