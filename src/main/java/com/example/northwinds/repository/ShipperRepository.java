package com.example.northwinds.repository;

import com.example.northwinds.model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ShipperRepository  extends CrudRepository<Shipper, Long> {
}
