package com.dinuo.service.impl;

import com.dinuo.domain.dto.UserDTO;
import com.dinuo.domain.po.User;
import com.dinuo.mapper.UserMapper;
import com.dinuo.service.UserService;
import com.dinuo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dinuo
 * @Date: 2024/06/19/18:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void register(UserDTO user) {
        userMapper.save(user);
    }

    @Override
    public String login(UserDTO user) {
        User dbUser = userMapper.selectByUsername(user.getName());
        if(dbUser == null){
            throw new RuntimeException("用户不存在");
        }

        String password = dbUser.getPassword();
        String username = dbUser.getUsername();
        if(!dbUser.getUsername().equals(user.getName()) || !dbUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("用户名或密码错误");
        }

        Map<String,Object> claims = new HashMap<>();
        claims.put("username", username);
        return JwtUtils.generateJwt(claims);
    }
}
