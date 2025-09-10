package com.games.back.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.games.back.model.Role;
import com.games.back.repository.IRoleRepository;
import com.games.back.services.IRoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public List<Role> findByRolesWithAtLeast1Username() {
        return roleRepository.findByRolesWithAtLeast1Username();
    }
}
