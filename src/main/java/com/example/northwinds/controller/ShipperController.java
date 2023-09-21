package com.example.northwinds.controller;

import com.example.northwinds.model.Shipper;
import com.example.northwinds.service.ShipperService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {

    @Autowired
    private ShipperService shipperService;

    @GetMapping
    public List<Shipper> getAll(){
        return shipperService.readAllShippers();
    }
    @GetMapping("/{id}")
    Shipper getById(@PathVariable Long id){
        try{
            return shipperService.readShipperById(id);
        }catch(ShipperNotFoundException exception){
            throw new ResponseStatusException(NOT_FOUND,exception.getMessage());
        }
    }

    @PostMapping
    public Shipper post(@Valid @RequestBody Shipper shipper){
        return shipperService.createShipper(shipper);
    }

    @PutMapping("/{id}")
    public Shipper put(@PathVariable Long id,@Valid @RequestBody Shipper shipper ){
        try{
            return shipperService.updateShipper(id,shipper);
        }catch(ShipperNotFoundException exception){
            throw new ResponseStatusException(NOT_FOUND,exception.getMessage());
        }
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){
        try{
           shipperService.deleteShipperById(id);
        }catch(ShipperNotFoundException exception){
            throw new ResponseStatusException(NOT_FOUND, exception.getMessage());
        }
    }

}