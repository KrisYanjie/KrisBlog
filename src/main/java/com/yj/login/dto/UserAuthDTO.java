package com.yj.login.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthDTO implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Boolean flag;
    private Integer code;
    private String message;
}
