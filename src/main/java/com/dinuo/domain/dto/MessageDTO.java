package com.dinuo.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author dinuo
 * @Date: 2024/06/05/9:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "聊天记录")
public class MessageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会话id", example = "1")
    private String sessionId;

    @ApiModelProperty(value = "模型id", example = "1")
    private Long modelId;

    @ApiModelProperty(value = "消息内容", notes = "说明: 消息内容", example = "你好")
    private String content;

}
