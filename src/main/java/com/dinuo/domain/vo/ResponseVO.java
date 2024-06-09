package com.dinuo.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author dinuo
 * @Date: 2024/06/05/10:03
 */
@Data
@AllArgsConstructor
@ApiModel(description = "模型回复内容")
public class ResponseVO {

    @ApiModelProperty(value = "模型回复内容", example = "我是智普轻言")
    private String response;
}
