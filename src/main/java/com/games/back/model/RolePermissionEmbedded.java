// package com.games.back.model;

// import jakarta.persistence.EmbeddedId;
// import jakarta.persistence.Entity;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @NoArgsConstructor
// @Data
// @Table(name = "role_permission")
// public class RolePermissionEmbedded {
    
//     @EmbeddedId
//     private RolePermissionPK rolePermissionPK;

//     @ManyToOne
//     @JoinColumn(name = "role_id", nullable = false)
//     private Role role;

//     @ManyToOne
//     @JoinColumn(name = "permission_id", nullable = false)
//     private Permission permission;
// }
