package com.games.back.services;

import java.util.List;

import com.games.back.model.Role;

public interface IRoleService {
    List<Role> findByRolesWithAtLeast1Username();
}
