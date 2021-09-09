package com.example.remoteshellinux.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConnectParams {

    @NotNull
    public String HOST_NAME;
    @NotNull
    public String USERNAME;
    public String PASSWORD;
    @NotNull
    public int PORT;
}
