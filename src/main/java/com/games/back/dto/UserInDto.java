package com.games.back.dto;

import java.sql.Date;


import lombok.Data;

@Data
public class UserInDto {
    private String username;
    private String email;
    private String password;
    private String bio;
    private Date birthdate;
    private Long roleId;
}
