package com.dinuo.domain.vo;

import com.dinuo.domain.po.ChatMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author dinuo
 * @Date: 2024/06/06/21:17
 */
@Data
@AllArgsConstructor
@ApiModel(description = "聊天记录")
public class MessageVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色", notes = "说明: user-用户, assistant-助手", example = "user")
    private String role;

    @ApiModelProperty(value = "消息内容", notes = "说明: 消息内容", example = "你好")
    private String content;

//    private Integer idx;
//
//    private boolean loading;
//
//    private Integer suitable;

    public MessageVO(ChatMessage message){
        this.role = message.getRole();
        this.content = message.getContent();
//        this.idx = 0;
//        this.loading = false;
//        this.suitable = 0;
    }

}
