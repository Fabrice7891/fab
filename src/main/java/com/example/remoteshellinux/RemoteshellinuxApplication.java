package com.example.remoteshellinux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RemoteshellinuxApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RemoteshellinuxApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RemoteshellinuxApplication.class);
	}

}
