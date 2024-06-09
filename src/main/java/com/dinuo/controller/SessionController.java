package com.dinuo.controller;

import com.dinuo.domain.dto.SessionDTO;
import com.dinuo.domain.vo.PageBean;
import com.dinuo.domain.vo.Result;
import com.dinuo.service.SessionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dinuo
 * @Date: 2024/06/05/0:05
 */
@RestController
@RequestMapping("sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @ApiOperation("新增会话")
    @PostMapping
    public Result saveSession(SessionDTO sessionDTO){

        return Result.success(sessionService.saveSession(sessionDTO));
    }

    @ApiOperation("根据id删除会话")
    @DeleteMapping("/delete")
    public Result deleteSession(@RequestParam @ApiParam(value = "删除的会话id", example = "1") String sessionId){

        sessionService.deleteSession(sessionId);
        return Result.success();
    }

    @ApiOperation("查询会话")
    @GetMapping("query")
    public Result querySession(){

        PageBean pageBean = sessionService.querySession();
        return Result.success(pageBean);
    }
}
