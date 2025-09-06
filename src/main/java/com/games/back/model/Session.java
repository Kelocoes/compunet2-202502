package com.games.back.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Session {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    @Column(name="date_time")
    private Timestamp dateTime;
    private String status;
    private String notes;


    @ManyToOne
    @JoinColumn(name="game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name="host_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "session")
    @ToString.Exclude
    @JsonIgnore
    private List<Participant> participants;
}
