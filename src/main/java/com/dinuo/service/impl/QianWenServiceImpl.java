package com.dinuo.service.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.dinuo.convert.ChatRequestConvert;
import com.dinuo.domain.dto.ChatRequestDTO;
import com.dinuo.domain.dto.QianWenDTO;
import com.dinuo.domain.vo.ChatResponseVO;
import com.dinuo.service.ModelService;
import com.dinuo.service.ModelService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 通义千问 大模型服务
 *
 * @author wsl
 * @link https://help.aliyun.com/zh/dashscope/developer-reference/api-details?spm=a2c4g.11186623.0.0.6922140bTYj6qJ#602895ef3dtl1
 * @date 2024/2/19
 */
@Slf4j
@Service("QianWenService")
public class QianWenServiceImpl implements ModelService {

    private String apiKey = "sk-b2fa736d019349c08eee364373917abf";
//    https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation
    private static final String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

    @Override
    public ChatResponseVO chatMessage(ChatRequestDTO dto) {
        QianWenDTO qianwen = ChatRequestConvert.INSTANCE.convertQianwen(dto);
        String json = JSON.toJSONString(qianwen);
        log.info("通义千问请求参数 qianwen request:{}", json);

        String result = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(json)
                .execute().body();

        log.info("通义千问返回结果 qianwen response:{}", result);
        ChatResponseVO vo = new ChatResponseVO();
        JSONObject jsonObject = JSON.parseObject(result);
        Optional<String> textOptional = Optional.ofNullable(jsonObject.getJSONObject("output"))
                .map(output -> output.getString("text"));

        if (!textOptional.isPresent()) {
            throw new RuntimeException(JSONObject.toJSONString(jsonObject));
        }

        vo.setResult(textOptional.get());
        return vo;

    }

}
