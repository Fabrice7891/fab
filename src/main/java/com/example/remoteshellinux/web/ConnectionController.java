package com.example.remoteshellinux.web;

import com.example.remoteshellinux.Entities.ConnectParams;
import com.example.remoteshellinux.service.ConnectionService;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ConnectionController {

    private  final ConnectionService connectionService;

    @PostMapping
    public ResponseEntity<Session> Connection(@Valid @RequestBody ConnectParams connectParams) throws JSchException {
        return new ResponseEntity<>(connectionService.connection(connectParams), HttpStatus.OK);
    }

}
