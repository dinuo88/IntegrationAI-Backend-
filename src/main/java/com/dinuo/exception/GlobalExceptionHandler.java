package com.dinuo.exception;

import com.dinuo.domain.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author dinuo
 * @Date: 2024/06/19/19:51
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result ex(Exception e){
        e.printStackTrace();

        return Result.error(e.getMessage());
    }
}
