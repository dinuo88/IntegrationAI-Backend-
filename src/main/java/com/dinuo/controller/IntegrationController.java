package com.dinuo.controller;


import com.dinuo.domain.dto.MessageDTO;
import com.dinuo.domain.vo.MessageVO;
import com.dinuo.domain.vo.Result;
import com.dinuo.service.IntegrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author dinuo
 * @Date: 2024/06/05/0:04
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class IntegrationController {

    @Autowired
    private IntegrationService integrationService;


    @ApiOperation("根据会话id查询历史聊天记录")
    @GetMapping("/message")
    public Result queryMessage(@RequestParam @ApiParam(value = "会话id", example = "8HJ75olF") String sessionId){

        List<MessageVO> messages = integrationService.queryMessageBySessionId(sessionId);
        return Result.success(messages);
    }

    @PostMapping("/message")
    @ApiOperation("与模型聊天")
    public Result chatMessage(@RequestBody MessageDTO messageDTO) throws Exception {
        log.info("开始与模型聊天：" + messageDTO.getContent());
        return Result.success(integrationService.chatMessage(messageDTO));
    }

}
