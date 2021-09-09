package com.example.remoteshellinux.web;

import com.example.remoteshellinux.Entities.Command;
import com.example.remoteshellinux.service.CommandService;
import com.jcraft.jsch.JSchException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommandController {

   // @Autowired
    private CommandService commandService;

    @GetMapping
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Command getResultByCommand(@RequestParam("commandName") String commandName) throws JSchException, IOException {
        return  new Command(commandName, commandService.getresltByCommand(commandName));
    }

}
