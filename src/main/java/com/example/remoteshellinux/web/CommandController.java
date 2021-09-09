package com.example.remoteshellinux.web;

import com.example.remoteshellinux.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandController {

   // @Autowired
    private CommandService commandService;
}
