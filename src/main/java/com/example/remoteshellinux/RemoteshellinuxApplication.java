package com.example.remoteshellinux;

import com.example.remoteshellinux.config.ConnectionParams;
import com.jcraft.jsch.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
public class RemoteshellinuxApplication {

	public static void main(String[] args) throws JSchException, IOException {
		SpringApplication.run(RemoteshellinuxApplication.class, args);

		JSch jsch = new JSch();
		Session session = jsch.getSession(ConnectionParams.USERNAME, ConnectionParams.HOST_NAME, ConnectionParams.PORT);
		session.setPassword(ConnectionParams.PASSWORD);
		Properties config= new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();

		Channel channel= session.openChannel("exec");
		InputStream in=channel.getInputStream();

		((ChannelExec) channel).setCommand("ls");
		((ChannelExec) channel).setErrStream(System.err);
        channel.connect();
		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(in));
		String line =bufferedReader.readLine();
		List<String> strings= new ArrayList<>();
		while (line!=null){
			strings.add(line);
			System.out.println(line);
		}
		channel.disconnect();
		session.disconnect();
	}

}
