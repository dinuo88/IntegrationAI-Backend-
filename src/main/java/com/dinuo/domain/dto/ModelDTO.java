package com.dinuo.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author dinuo
 * @Date: 2024/06/05/9:32
 */
@Data
@ApiModel(description = "大模型详情")
public class ModelDTO {
    @ApiModelProperty(value = "模型id",example = "1")
    private Long id;

    @ApiModelProperty(value = "模型中文名", example = "智普轻言")
    private String chineseName;

    @ApiModelProperty(value = "模型中文名", example = "ChatGlm")
    private String englishName;
}
