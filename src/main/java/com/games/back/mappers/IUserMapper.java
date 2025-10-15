package com.games.back.mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.games.back.dto.UserInDto;
import com.games.back.dto.UserOutDto;
import com.games.back.model.User;

@Mapper(componentModel = "spring", uses = { IRoleMapper.class})
public interface IUserMapper {
    
    @Mappings({
        @Mapping(source = "role", target = "role")
    })
    UserOutDto userEntityToDto(User user);
    @Mappings({
        @Mapping(target="id", ignore = true),
        @Mapping(target="comments", ignore = true),
        @Mapping(target="hostedSessions", ignore = true),
        @Mapping(target="participations", ignore = true),
        @Mapping(target="games", ignore = true),
        @Mapping(source = "password", target="passwordHash"),
        @Mapping(target="createdAt", expression = "java(setCreatedAt())"),
        @Mapping(source = "roleId", target = "role.id"),
    })
    User userDtoToEntity(UserInDto user);

    default Timestamp setCreatedAt() {
        return Timestamp.valueOf(LocalDateTime.now());
    }
}
