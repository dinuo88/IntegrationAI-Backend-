package com.dinuo.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * @Author dinuo
 * @Date: 2024/06/05/8:22
 */
@Data
@ApiModel(description = "会话详情")
@Getter
public class SessionDTO {

//    @ApiModelProperty(value = "模型id",example = "1")
//    private Long modelId;
//
//    @ApiModelProperty(value = "会话名称", example = "123123123")
//    private String name;

    @ApiModelProperty(value = "模型人设", example = "主要用于人设设定，例如：你是xxx公司制作的AI助手，说明：长度限制，" +
                        "message中的content总长度和system字段总内容不能超过24000个字符，且不能超过6144 tokens")
    private String system;

}
