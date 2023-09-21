package com.example.northwinds.repository;

import com.example.northwinds.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository  extends JpaRepository<Ship, Long> {
}
