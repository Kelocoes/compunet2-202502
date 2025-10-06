package com.games.back.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.games.back.dtos.User.UserInDTO;
import com.games.back.dtos.User.UserOutDTO;
import com.games.back.model.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring", uses = {IRoleMapper.class})
public interface IUserMapper {
    
    @Mappings({
        @Mapping(source = "password", target = "passwordHash"),
        @Mapping(target = "createdAt", expression = "java(getCurrentTimestamp())"),
        @Mapping(source = "roleId", target = "role.id"),
        @Mapping(target = "comments", ignore = true),
        @Mapping(target = "games", ignore = true),
        @Mapping(target = "hostedSessions", ignore = true),
        @Mapping(target = "participations", ignore = true),
        @Mapping(target = "id", ignore = true)
    })
    User userInDtoToUser(UserInDTO userInDTO);
    
    @Mappings({
        @Mapping(source = "role", target = "role")
    })
    UserOutDTO userToUserOutDto(User user);

    default Timestamp getCurrentTimestamp() {
        return Timestamp.valueOf(LocalDateTime.now());
    }
}
