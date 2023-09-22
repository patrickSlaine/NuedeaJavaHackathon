package com.example.northwinds.repository;

import com.example.northwinds.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ShipRepository  extends CrudRepository<Ship, Long> {
}
