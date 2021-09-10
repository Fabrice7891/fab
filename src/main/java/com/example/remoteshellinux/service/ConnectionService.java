package com.example.remoteshellinux.service;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public interface ConnectionService {

    Session getSession() throws JSchException;
}
