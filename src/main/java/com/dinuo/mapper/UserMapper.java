package com.dinuo.mapper;

import com.dinuo.domain.dto.UserDTO;
import com.dinuo.domain.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author dinuo
 * @Date: 2024/06/19/18:22
 */
@Mapper
public interface UserMapper {
    void save(UserDTO user);

    User selectByUsername(String name);
}
