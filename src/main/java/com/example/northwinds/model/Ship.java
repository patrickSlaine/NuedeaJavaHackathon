package com.example.northwinds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

@Entity
@Table
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ship_id", nullable=false)
    private Long id;

    @Column
    @NotBlank(message="'name' is mandatory")
    private String name;

    @ManyToOne()
    @JoinColumn(name="shippers_id")
    @JsonIgnore
    private Shipper shipper;

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
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

    public Ship(Long id, String name, Shipper shipper) {
        this.id = id;
        this.name = name;
        this.shipper = shipper;
    }

    public Ship(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ship(){

    }

}
