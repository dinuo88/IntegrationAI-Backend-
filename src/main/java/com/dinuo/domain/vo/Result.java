package com.dinuo.domain.vo;

import com.sun.jdi.VoidValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author dinuo
 * @Date: 2024/06/05/8:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "返回数据")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "编码，200表示成功，其他数字表示失败", example = "200")
    private Integer code;
    @ApiModelProperty(value = "success表示成功，否则为错误信息",example = "success")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 200;
        result.msg = "success";
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 200;
        result.msg = "success";
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
