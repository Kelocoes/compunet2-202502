package com.games.back.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    /*
     * GenerationTypes:
     * AUTO: JPA provider will choose the strategy (default)
     * IDENTITY: Database auto-increment field
     * SEQUENCE: Uses a database sequence object
     * TABLE: Uses a table to simulate a sequence
     * NONE: No generation strategy
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", unique = true, nullable = false, length = 50)
    private String username;
    @Column(name="email", unique = true, nullable = false, length = 100)
    private String email;
    @Column(name="password_hash", nullable = false, length = 255)
    private String password_hash;
    @Column(name="bio", length = 500)
    private String bio;
    @Column(name="created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Game> games;
}
