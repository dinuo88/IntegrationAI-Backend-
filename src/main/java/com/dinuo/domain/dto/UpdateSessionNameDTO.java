package com.dinuo.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * @Author dinuo
 * @Date: 2024/06/26/20:56
 */
@Data
@ApiModel(description = "更新会话名称")
@Getter
public class UpdateSessionNameDTO {

    @ApiModelProperty(value = "会话id",example = "1")
    private String sessionId;

    @ApiModelProperty(value = "会话新名称", example = "123123123")
    private String name;
}
