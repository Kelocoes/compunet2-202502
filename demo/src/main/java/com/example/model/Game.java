package com.example.model;

public class Game {

    private Long id;
    private String name;
    private String description;
    private Long createdById;

    public Game(Long id, String name, String description, Long createdById) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdById = createdById;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdById=" + createdById +
                '}';
    }
}
