package com.games.back.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    /*
     * FetchType:
     * EAGER: Load related entities immediately
     * LAZY: Load related entities on demand (default for @OneToMany)
     * CascadeType:
     * ALL: All operations (persist, merge, remove, refresh, detach)
     * PERSIST: Cascade persist operation
     * MERGE: Cascade merge operation
     * REMOVE: Cascade remove operation
     */
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<User> users;

    // Many-to-Many relationship with Permission
    // @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // @JoinTable(
    //     name = "role_permission", // Name of the join table
    //     joinColumns = @JoinColumn(name = "role_id"), // Foreign key for Role
    //     inverseJoinColumns = @JoinColumn(name = "permission_id") // Foreign key for Permission
    // )
    // private List<Permission> permissions;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<RolePermission> rolePermissions;
}
