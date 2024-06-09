package com.dinuo.domain.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dinuo
 * @Date: 2024/06/06/20:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    private Long messageId;
    private String sessionId;
    private String role;
    private String content;

}
