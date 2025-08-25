package com.games.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.back.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
    
}
