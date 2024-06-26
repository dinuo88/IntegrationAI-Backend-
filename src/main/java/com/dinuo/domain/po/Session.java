package com.dinuo.domain.po;

import com.dinuo.domain.dto.SessionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author dinuo
 * @Date: 2024/06/06/20:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    @Id
    private String sessionId;
    private Long userId;
//    private Long modelId;
    private String sessionName;
    private String systemParam;

    public Session(SessionDTO sessionDTO,Long userId,String sessionId){
        this.sessionName = "New Chat";
        this.systemParam = sessionDTO.getSystem();
        this.sessionId = sessionId;
        this.userId = userId;
    }

}
