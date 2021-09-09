package com.example.remoteshellinux.service;

import com.example.remoteshellinux.Entities.ConnectParams;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public interface ConnectionService {

    public Session connection(ConnectParams connectParams) throws JSchException;
}
