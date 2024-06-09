package com.dinuo.mapper;

import com.dinuo.domain.po.ChatMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author dinuo
 * @Date: 2024/06/06/21:11
 */
@Mapper
public interface MessageMapper {
    List<ChatMessage> queryMessageBySessionId(String id);

    void insert(ChatMessage chatMessage);

    List<ChatMessage> selectBySessionId(String id);
}
