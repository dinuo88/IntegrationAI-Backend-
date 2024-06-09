package com.dinuo.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author dinuo
 * @Date: 2024/06/06/21:43
 */
@Data
public class ChatResponseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "结果", notes = "结果")
    private String result;

}
