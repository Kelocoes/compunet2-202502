package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    
    // Boilerplate code
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 50)
    private String username;
    private String email;
    @Column(name="password_hash")
    private String passwordHash;
    private String bio;
    @Column(name="created_at", nullable = false, updatable = false)
    private Timestamp createdAt;
    
    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    @ToString.Exclude
    private Role role;
}
