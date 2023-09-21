package com.example.northwinds.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ship_id", nullable=false)
    private Long id;

    @Column
    @NotBlank(message="'name' is mandatory")
    private String name;

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

    public Ship(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Ship(){

    }

}
