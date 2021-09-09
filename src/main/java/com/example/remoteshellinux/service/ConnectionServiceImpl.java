package com.example.remoteshellinux.service;

import com.example.remoteshellinux.Entities.ConnectParams;
import com.example.remoteshellinux.config.ConnectionParams;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ConnectionServiceImpl implements  ConnectionService{
    @Override
    public Session connection(ConnectParams connectParams) throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(connectParams.getUSERNAME(), connectParams.getHOST_NAME(), connectParams.getPORT());
        session.setPassword(connectParams.getPASSWORD());
        Properties config= new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        return session;
    }
}
