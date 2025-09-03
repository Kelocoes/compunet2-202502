// package com.example.demo.model;

// import jakarta.persistence.EmbeddedId;
// import jakarta.persistence.Entity;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Table(name = "role_permission")
// public class RolePermissionEmbedded {

//     @EmbeddedId
//     private RolePermissionPK rolePemissionId;

//     @ManyToOne
//     @JoinColumn(name="role_id", nullable = false)
//     private Role role;
//     @ManyToOne
//     @JoinColumn(name = "permission_id", nullable = false)
//     private Permission permission;

//     private String relationType;
// }
