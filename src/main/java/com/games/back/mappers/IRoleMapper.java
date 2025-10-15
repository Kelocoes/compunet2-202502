package com.games.back.mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.games.back.dto.RoleOutDto;
import com.games.back.dto.UserInDto;
import com.games.back.dto.UserOutDto;
import com.games.back.model.Role;
import com.games.back.model.User;

@Mapper(componentModel = "spring")
public interface IRoleMapper {
    
    RoleOutDto rolerEntityToDto(Role roler);
}
