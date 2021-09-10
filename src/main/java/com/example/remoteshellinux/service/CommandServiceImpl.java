package com.example.remoteshellinux.service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
@AllArgsConstructor
public class CommandServiceImpl implements  CommandService{

    private final ConnectionService connectionService;

    @Override
    public String executeCommand(String command) throws JSchException, IOException {
        Session session= connectionService.getSession();
        session.connect();

        Channel channel= session.openChannel("exec");
        InputStream in=channel.getInputStream();

        ((ChannelExec) channel).setCommand(command);
        ((ChannelExec) channel).setErrStream(System.err);
        channel.connect();

        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(in));
        String line =bufferedReader.readLine();
        StringBuilder result = new StringBuilder();
        while (line!=null){
            result.append(line).append("/n");
            System.out.println(line);
        }

        channel.disconnect();
        session.disconnect();

        return result.toString();
    }
}
