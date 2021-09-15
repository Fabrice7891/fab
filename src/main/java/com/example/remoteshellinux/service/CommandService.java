package com.example.remoteshellinux.service;

import com.jcraft.jsch.JSchException;

import java.io.IOException;

public interface CommandService {
    String executeCommand(String command) throws JSchException, IOException;
}
