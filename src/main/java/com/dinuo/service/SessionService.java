package com.dinuo.service;

import com.dinuo.domain.dto.SessionDTO;
import com.dinuo.domain.dto.UpdateSessionNameDTO;
import com.dinuo.domain.vo.PageBean;

/**
 * @Author dinuo
 * @Date: 2024/06/06/20:31
 */
public interface SessionService {
    String saveSession(SessionDTO sessionDTO);

    void deleteSession(String sessionId);

    PageBean querySession();

    void updateName(UpdateSessionNameDTO updateSessionNameDTO);

}
