package com.example.remoteshellinux.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandServiceImpl implements  CommandService{

    private ConnectionService connectionService;
    @Override
    public List<String> getresltByCommand(String commandName) {
       // if(connectionService.connection())
        return null;
    }
}
