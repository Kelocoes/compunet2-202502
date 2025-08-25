package com.games.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.back.model.RolePermission;

@Repository
public interface IRolePermissionRepository extends JpaRepository<RolePermission, Long>{
    
}
