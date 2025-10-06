package com.games.back.mappers;

import org.mapstruct.Mapper;

import com.games.back.dtos.Role.RoleDTO;
import com.games.back.model.Role;

@Mapper(componentModel = "spring")
public interface IRoleMapper {
    
    RoleDTO toRoleDTO(Role role);
}
