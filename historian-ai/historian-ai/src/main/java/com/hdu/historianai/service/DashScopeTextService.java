package com.hdu.historianai.service;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.hdu.historianai.config.DashScopeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class DashScopeTextService {

    @Autowired
    private DashScopeConfig config;

    /**
     * 生成文创配图文案
     */
    public String generateCaption(String userPrompt, String style) {
        String systemPrompt = String.format(
                "你是一位校园文创设计师，擅长为杭电（杭州电子科技大学）学生创作温暖、有趣、带文艺气息的纪念文案。" +
                        "用户描述了一个校园场景，你需要生成一句配图文案，风格与'%s'相匹配。可融入校园梗或杭电元素。" +
                        "不超过40个字，直接输出文案，不要加引号或解释。", style);
        return callTextModel(systemPrompt, userPrompt);
    }

    /**
     * 生成专业的英文图像生成提示词（供通义万相使用）
     */
    public String buildImagePrompt(String userPrompt, String style) {
        String systemPrompt = String.format(
                "你是一位AI绘画专家，擅长将用户的简短描述，转化为用于生成'%s'风格图像的专业、详细英文提示词。" +
                        "提示词应包含主体、细节、光线、色彩、艺术风格等要素。直接输出英文提示词，不要有任何解释。", style);
        String userMessage = String.format("把以下描述转化成高质量的英文绘画提示词：%s", userPrompt);
        return callTextModel(systemPrompt, userMessage);
    }

    private String callTextModel(String systemContent, String userContent) {
        try {
            Generation gen = new Generation();
            Message systemMsg = Message.builder()
                    .role(Role.SYSTEM.getValue())
                    .content(systemContent)
                    .build();
            Message userMsg = Message.builder()
                    .role(Role.USER.getValue())
                    .content(userContent)
                    .build();

            GenerationParam param = GenerationParam.builder()
                    .model(config.getTextModel())
                    .messages(Arrays.asList(systemMsg, userMsg))
                    .apiKey(config.getApiKey())
                    .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                    .build();

            GenerationResult result = gen.call(param);
            return result.getOutput().getChoices().get(0).getMessage().getContent();
        } catch (ApiException | NoApiKeyException e) {
            e.printStackTrace();
            return "✨ 杭电记忆，这一刻永恒。"; // 降级文案
        } catch (Exception e) {
            e.printStackTrace();
            return "🎓 时光不语，却回答了所有。";
        }
    }
}