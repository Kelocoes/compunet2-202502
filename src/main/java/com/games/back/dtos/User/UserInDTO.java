package com.games.back.dtos.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInDTO {
    private String username;
    private String email;
    private String password;
    private String bio;
    private Date birthdate;
    private Long roleId;
}
