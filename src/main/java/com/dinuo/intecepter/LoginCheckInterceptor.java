package com.dinuo.intecepter;

import com.dinuo.mapper.UserMapper;
import com.dinuo.utils.JwtUtils;
import com.dinuo.utils.UserContext;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author dinuo
 * @Date: 2024/06/19/19:49
 */
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler){

        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            System.out.println("OPTIONS请求，放行");
            return true;
        }

        log.info("LoginCheckInterceptor.preHandle...");

        String token = request.getHeader("Authorization");
        log.info("请求头中的token令牌：" + token);

        if(!StringUtils.hasLength(token)){
            log.info("Token不存在");

            throw new RuntimeException("请先登录");

        }

        String username;
        try{
            Claims claims = JwtUtils.parseJWT(token);
            username = claims.get("username").toString();
        }catch (Exception e){
            log.info("token解析失败");
            throw new RuntimeException("请先登录");
        }

        Long userId = userMapper.selectByUsername(username).getUserId();
        UserContext.set("userId",userId);

        return true;
    }
}
