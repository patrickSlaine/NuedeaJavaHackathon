package com.example.northwinds.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity(name="shipper")
@Table(name="shippers")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shipper_id", nullable = false)
    private Long id;
    @Column(name="company_name",nullable = false)
    @NotBlank(message="'name' is mandatory")
    private String name;

    private String phone;

    @OneToMany(mappedBy = "shipper", cascade = {CascadeType.ALL},orphanRemoval = true)
    private List<Ship> ships = new ArrayList<>();

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public Shipper(Long id, String name, String phone,List ships) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ships = ships;
    }

    public Shipper(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Shipper(){

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
