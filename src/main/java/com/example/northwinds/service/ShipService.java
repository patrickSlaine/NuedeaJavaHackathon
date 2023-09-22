package com.example.northwinds.service;

import com.example.northwinds.controller.ShipNotFoundException;
import com.example.northwinds.model.Ship;
import com.example.northwinds.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipService {

    @Autowired
    private ShipRepository shipRepository;

    public List<Ship> readAllShips(){return (ArrayList)shipRepository.findAll();}

    public Ship readShipById(Long id){
        return shipRepository.findById(id).orElseThrow(()-> new ShipNotFoundException("Not Found"));
    }

    public Ship createShip(Ship ship){return shipRepository.save(ship);}

    public Ship updateShip(Long id, Ship ship){
        this.readShipById(id);
        ship.setId(id);
        return shipRepository.save(ship);
    }

    public void deleteShipperById(Long id){
        this.readShipById(id);
        shipRepository.deleteById(id);
    }
}
