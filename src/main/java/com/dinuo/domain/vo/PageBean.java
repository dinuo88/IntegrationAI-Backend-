package com.dinuo.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author dinuo
 * @Date: 2024/06/05/8:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    @ApiModelProperty(value = "总记录数", example = "5")
    private Long total;

    @ApiModelProperty(value = "数据列表")
    private List rows;

}
