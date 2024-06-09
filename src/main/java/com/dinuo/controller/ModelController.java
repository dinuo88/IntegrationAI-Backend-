package com.dinuo.controller;

import com.dinuo.domain.vo.PageBean;
import com.dinuo.domain.vo.Result;
import com.dinuo.service.ModelService1;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author dinuo
 * @Date: 2024/06/05/8:05
 */
@RestController
@RequestMapping("/models")
@Slf4j
@CrossOrigin(origins = "*")
public class ModelController {

    @Autowired
    private ModelService1 modelService;


    // TODO 查阅大模型
    @ApiOperation("查阅大模型")
    @GetMapping
    public Result queryModels(){

        log.info("开始查阅大模型");
        modelService.query();
        PageBean pageBean = modelService.query();
        return Result.success(pageBean);
    }


}
