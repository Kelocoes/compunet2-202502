package com.games.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.games.back.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{

    @Query("SELECT r FROM Role r WHERE SIZE(r.users) >= 1")
    List<Role> findByRolesWithAtLeast1Username();
}
