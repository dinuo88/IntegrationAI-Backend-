package com.dinuo.service;

import com.dinuo.domain.dto.MessageDTO;
import com.dinuo.domain.vo.ChatResponseVO;
import com.dinuo.domain.vo.MessageVO;

import java.util.List;

/**
 * @Author dinuo
 * @Date: 2024/06/06/21:10
 */
public interface IntegrationService {
    List<MessageVO> queryMessageBySessionId(String id);

    ChatResponseVO chatMessage(MessageDTO messageDTO) throws Exception;
}
