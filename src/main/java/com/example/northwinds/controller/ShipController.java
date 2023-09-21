package com.example.northwinds.controller;

import com.example.northwinds.model.Ship;
import com.example.northwinds.service.ShipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/ship")
public class ShipController {

    @Autowired
    private ShipService shipService;

    @GetMapping
    public List<Ship> getAll() {return shipService.readAllShips();}

    @GetMapping("/{id}")
    Ship getById(@PathVariable Long id){
        try{
            return shipService.readShipById(id);
        }catch(ShipNotFoundException exception){
            throw new ResponseStatusException(NOT_FOUND,exception.getMessage());
        }
    }

    @PostMapping
    public Ship post(@Valid @RequestBody Ship ship){return shipService.createShip(ship);}

    @PutMapping("/{id}")
    public Ship put(@PathVariable Long id, @Valid @RequestBody Ship ship){
        try{
            return shipService.updateShip(id,ship);
        }catch(ShipNotFoundException exception){
            throw new ResponseStatusException(NOT_FOUND, exception.getMessage());
        }
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){
        try{
            shipService.deleteShipperById(id);
        }catch(ShipNotFoundException exception){
            throw new ResponseStatusException(NOT_FOUND, exception.getMessage());
        }
    }
}
