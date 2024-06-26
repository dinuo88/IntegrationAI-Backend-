package com.dinuo.controller;

import com.dinuo.domain.dto.UserDTO;
import com.dinuo.domain.vo.Result;
import com.dinuo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author dinuo
 * @Date: 2024/06/05/0:06
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result userRegister(@RequestBody UserDTO user) {
        userService.register(user);
        return Result.success();
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result userLogin(@RequestBody UserDTO user) {
        log.info("用户名：" + user.getName());
        log.info("密码：" + user.getPassword());

        String token = userService.login(user);
        log.info("用户登录成功.....");
        return Result.success(token);
    }

    @GetMapping("/logout")
    @ApiOperation("用户登出")
    public Result userLogout(@RequestHeader("Authorization") String token) {

        return Result.success();
    }

}
