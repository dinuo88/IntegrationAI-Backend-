package com.dinuo.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author dinuo
 * @Date: 2024/06/06/21:30
 */
@Data
@ApiModel(description = "通义法睿 输入 请求 DTO")
public class FaRuiInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前提问的问题")
    private String prompt;

    @ApiModelProperty(value = "会话的历史消息")
    private List<FaRuiHistoryDTO> history;

}
