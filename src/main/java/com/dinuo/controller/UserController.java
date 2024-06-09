package com.dinuo.controller;

import com.dinuo.domain.dto.UserDTO;
import com.dinuo.domain.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author dinuo
 * @Date: 2024/06/05/0:06
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    // TODO 用户注册
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result userRegister(@RequestBody UserDTO user) {

        return Result.success();
    }

    // TODO 用户登录
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result userLogin(@RequestBody UserDTO user) {


        String token = null;

        return Result.success(token);
    }

    // TODO 用户登出
    @GetMapping("/logout")
    @ApiOperation("用户登出")
    public Result userLogout(@RequestHeader("Authorization") String token) {

        return Result.success();
    }

}
