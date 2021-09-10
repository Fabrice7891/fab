package com.example.remoteshellinux.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.session.ssh")
public class ConnectionProperties {

    private String hostname;
    private String username;
    private String password;
    private int port;
}
