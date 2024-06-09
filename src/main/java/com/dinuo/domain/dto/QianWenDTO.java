package com.dinuo.domain.dto;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author dinuo
 * @Date: 2024/06/06/21:31
 */
@Data
public class QianWenDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "模型名", notes = "模型名", example = "qwen-turbo")
    private String model;

    @ApiModelProperty(value = "输入", notes = "输入")
    private QianWenInputDTO input;

    @ApiModelProperty(value = "参数", notes = "参数")
    private JSONObject parameters;

}
