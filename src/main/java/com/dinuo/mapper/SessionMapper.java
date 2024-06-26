package com.dinuo.mapper;


import com.dinuo.domain.dto.UpdateSessionNameDTO;
import com.dinuo.domain.po.Session;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author dinuo
 * @Date: 2024/06/06/20:32
 */
@Mapper
public interface SessionMapper {
    void saveSession(Session session);

    void deleteSession(String sessionId);

    Page<Session> pageQuery(Long id);

    Session selectById(String id);

    void updateName(UpdateSessionNameDTO updateSessionNameDTO);
}
