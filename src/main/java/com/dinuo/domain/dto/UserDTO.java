package com.dinuo.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author dinuo
 * @Date: 2024/06/05/9:51
 */
@Data
@AllArgsConstructor
@ApiModel(description = "用户信息")
public class UserDTO {

    @ApiModelProperty(value = "用户名", example = "dinuo")
    private String name;

    @ApiModelProperty(value = "密码", example = "123456")
    private String password;

}
