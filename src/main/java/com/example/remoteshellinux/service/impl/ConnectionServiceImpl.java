package com.example.remoteshellinux.service.impl;

import com.example.remoteshellinux.config.ConnectionProperties;
import com.example.remoteshellinux.service.ConnectionService;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@AllArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {

    private final ConnectionProperties connectionProperties;

    @Override
    public Session getSession() throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(connectionProperties.getUsername(), connectionProperties.getHostname(), connectionProperties.getPort());
        session.setPassword(connectionProperties.getPassword());
        Properties config= new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        return session;
    }
}
