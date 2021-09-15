package com.example.remoteshellinux.web;

import com.example.remoteshellinux.service.CommandService;
import com.jcraft.jsch.JSchException;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class CommandController {

    private CommandService commandService;

    @MessageMapping("/execute")
    @SendTo("/command/output")
    public String getResultByCommand(String command) throws JSchException, IOException {
        return commandService.executeCommand(command);
    }

}
