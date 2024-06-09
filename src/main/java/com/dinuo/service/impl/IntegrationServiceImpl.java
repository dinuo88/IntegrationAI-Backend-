package com.dinuo.service.impl;

import com.dinuo.domain.dto.ChatRequestDTO;
import com.dinuo.domain.dto.MessageDTO;
import com.dinuo.domain.dto.ParamsDTO;
import com.dinuo.domain.po.ChatMessage;
import com.dinuo.domain.po.Model;
import com.dinuo.domain.po.Session;
import com.dinuo.domain.vo.ChatResponseVO;
import com.dinuo.domain.vo.MessageVO;
import com.dinuo.mapper.MessageMapper;
import com.dinuo.mapper.ModelMapper;
import com.dinuo.mapper.SessionMapper;
import com.dinuo.service.IAiAppService;
import com.dinuo.service.IntegrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dinuo
 * @Date: 2024/06/06/21:10
 */
@Service
@Slf4j
public class IntegrationServiceImpl implements IntegrationService {
    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private SessionMapper sessionMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IAiAppService iAiAppService;

    @Override
    public List<MessageVO> queryMessageBySessionId(String id) {
        List<ChatMessage> chatMessages = messageMapper.queryMessageBySessionId(id);
        List<MessageVO> messageVos = new ArrayList<>();
        for(ChatMessage chatMessage : chatMessages){
            MessageVO messageVo = new MessageVO(chatMessage);
            messageVos.add(messageVo);
        }
        return messageVos;
    }

    @Override
    @Transactional
    public ChatResponseVO chatMessage(MessageDTO messageDTO) throws Exception {
        // 根据会话id查询当前会话的设置
        Session session = sessionMapper.selectById(messageDTO.getSessionId());

        // 当前的聊天信息
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSessionId(session.getSessionId());
        chatMessage.setRole("user");
        chatMessage.setContent(messageDTO.getContent());

        log.info("content:" + chatMessage.getContent());

        // 新增当前聊天信息
        messageMapper.insert(chatMessage);

        Model model = modelMapper.selectById(messageDTO.getModelId());

        // 喂给大模型的所有信息
        List<ChatMessage> chatMessages = messageMapper.selectBySessionId(messageDTO.getSessionId());
        List<MessageVO> messages = new ArrayList<>();
        for(ChatMessage chatMessage1 : chatMessages){
            MessageVO messageVo = new MessageVO(chatMessage1);
            messages.add(messageVo);
        }

        // 设置请求参数api
        ChatRequestDTO chatRequestDTO = new ChatRequestDTO();
        chatRequestDTO.setMessages(messages);
        chatRequestDTO.setSystem(session.getSystemParam());
        chatRequestDTO.setParams(new ParamsDTO());
        ChatResponseVO chatResponseVO = iAiAppService.chatMessage(model.getModelNameEn(), chatRequestDTO);

        ChatMessage chatMessage1 = new ChatMessage();
        chatMessage1.setSessionId(session.getSessionId());
        chatMessage1.setRole("assistant");
        chatMessage1.setContent(chatResponseVO.getResult());
        messageMapper.insert(chatMessage1);

        return chatResponseVO;

    }
}
