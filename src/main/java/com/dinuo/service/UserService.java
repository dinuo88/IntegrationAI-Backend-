package com.dinuo.service;

import com.dinuo.domain.dto.UserDTO;

/**
 * @Author dinuo
 * @Date: 2024/06/19/18:21
 */
public interface UserService {
    void register(UserDTO user);

    String login(UserDTO user);
}
