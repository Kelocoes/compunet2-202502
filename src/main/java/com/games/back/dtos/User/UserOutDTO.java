package com.games.back.dtos.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.sql.Timestamp;

import com.games.back.dtos.Role.RoleDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOutDTO {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private Timestamp createdAt;
    private Date birthdate;
    private RoleDTO role;
}
