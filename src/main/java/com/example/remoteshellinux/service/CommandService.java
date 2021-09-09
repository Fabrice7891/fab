package com.example.remoteshellinux.service;

import com.jcraft.jsch.JSchException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface CommandService {
    public List<String> getresltByCommand(String commandName) throws JSchException, IOException;
}
