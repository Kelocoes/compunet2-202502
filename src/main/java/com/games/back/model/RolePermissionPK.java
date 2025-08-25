// package com.games.back.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Embeddable;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @NoArgsConstructor
// @Data
// @Embeddable
// public class RolePermissionPK {
    
//     /*
//     * Why should you use insertable = false, updatable = false?
//     * This is done to prevent JPA from trying to insert or update the foreign key columns
//     * directly through the embedded ID. Instead, these columns are managed through the
//     * @ManyToOne relationships in the RolePermissionEmbedded entity.
//     */
//     @Column(name = "role_id", insertable = false, updatable = false)
//     private Long roleId;
//     @Column(name = "permission_id", insertable = false, updatable = false)
//     private Long permissionId;
// }
