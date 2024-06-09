package com.dinuo.convert;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;

import com.dinuo.domain.dto.*;
import com.dinuo.domain.vo.MessageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author dinuo
 * @Date: 2024/06/06/21:32
 */
@Mapper
public interface ChatRequestConvert {

    ChatRequestConvert INSTANCE = Mappers.getMapper(ChatRequestConvert.class);

    /**
     * 通用请求转换为文心一言请求
     *
     * @param dto 通用请求
     * @return 文心一言请求
     */
    default JSONObject convertErnieBot(ChatRequestDTO dto) {
        ErnieBotDTO ernieBotDTO = new ErnieBotDTO();
        ernieBotDTO.setMessages(dto.getMessages());
        ernieBotDTO.setSystem(dto.getSystem());

        JSONObject jsonObject = new JSONObject();
        BeanUtil.copyProperties(ernieBotDTO, jsonObject);
        BeanUtil.copyProperties(dto.getParams(), jsonObject);
        return jsonObject;
    }

    /**
     * 通用请求转换为通义千问请求
     *
     * @param dto 通用请求
     * @return 通义千问请求
     */
    default QianWenDTO convertQianwen(ChatRequestDTO dto) {
        QianWenDTO qianWenDTO = new QianWenDTO();
        qianWenDTO.setModel("qwen-turbo");
        QianWenInputDTO input = new QianWenInputDTO();
        String system = dto.getSystem();
        if (StrUtil.isNotBlank(system)) {
            MessageVO MessageVO = new MessageVO("system", system);
            dto.getMessages().add(0, MessageVO);
        }
        input.setMessages(dto.getMessages());

        JSONObject parametersJsonObject = new JSONObject();
        BeanUtil.copyProperties(dto.getParams(), parametersJsonObject);

        qianWenDTO.setInput(input);
        qianWenDTO.setParameters(parametersJsonObject);

        return qianWenDTO;
    }

    /**
     * 通用请求转换为智谱清言请求
     *
     * @param dto 通用请求
     * @return 智谱清言请求
     */
    default JSONObject convertChatGlm(ChatRequestDTO dto) {
        ChatGlmDTO chatGlmDTO = new ChatGlmDTO();

        String system = dto.getSystem();
        if (StrUtil.isNotBlank(system)) {
            MessageVO MessageVO = new MessageVO("system", system);
            dto.getMessages().add(0, MessageVO);
        }

        chatGlmDTO.setMessages(dto.getMessages());
        chatGlmDTO.setModel("glm-4");
        JSONObject jsonObject = new JSONObject();
        BeanUtil.copyProperties(chatGlmDTO, jsonObject);
        BeanUtil.copyProperties(dto.getParams(), jsonObject);
        return jsonObject;
    }


    /**
     * 通用请求转换为通义千问请求
     *
     * @param dto 通用请求
     * @return 通义千问请求
     */
    default FaRuiDTO convertFaRui(ChatRequestDTO dto) {
        FaRuiDTO faRuiDTO = new FaRuiDTO();

        List<MessageVO> messages = dto.getMessages();
        String prompt = messages.get(messages.size() - 1).getContent();

        FaRuiInputDTO input = new FaRuiInputDTO();
        if (messages.size() == 1) {
            messages = new ArrayList<>();
        }
        if (CollUtil.isNotEmpty(messages)) {
            messages.remove(messages.size() - 1);
            List<FaRuiHistoryDTO> history = convertFaRuiHistory(messages);
            input.setHistory(history);
        }
        input.setPrompt(prompt);
        faRuiDTO.setParameters(dto.getParams());
        faRuiDTO.setInput(input);

        return faRuiDTO;
    }

    /**
     * 通用消息转换为通义法睿历史消息
     *
     * @param messages 通用消息
     * @return 通义法睿历史消息
     */
    default List<FaRuiHistoryDTO> convertFaRuiHistory(List<MessageVO> messages) {
        List<FaRuiHistoryDTO> history = new ArrayList<>();
        int size = messages.size();
        for (int i = 0; i < size; i += 2) {
            FaRuiHistoryDTO messagePair = new FaRuiHistoryDTO();
            messagePair.setUser(messages.get(i).getContent());
            if (i + 1 < size) {
                messagePair.setBot(messages.get(i + 1).getContent());
            }
            history.add(messagePair);
        }
        return history;
    }

}
