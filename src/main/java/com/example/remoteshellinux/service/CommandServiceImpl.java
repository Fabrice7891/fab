package com.example.remoteshellinux.service;

import com.example.remoteshellinux.Entities.ConnectParams;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommandServiceImpl implements  CommandService{

    private ConnectionService connectionService;
    @Override
    public List<String> getresltByCommand(String commandName) throws JSchException, IOException {
        ConnectParams connectParams= new ConnectParams();
        Session session= connectionService.connection(connectParams);
        Channel channel= session.openChannel("exec");
        InputStream in=channel.getInputStream();
        ((ChannelExec) channel).setCommand(commandName);
        ((ChannelExec) channel).setErrStream(System.err);
        channel.connect();
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(in));
        String line =bufferedReader.readLine();
        List<String> result= new ArrayList<>();
        while (line!=null){
            result.add(line);
            System.out.println(line);
        }
        channel.disconnect();
        session.disconnect();
        return result;
    }
}
