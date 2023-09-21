package com.example.northwinds.controller;

import com.example.northwinds.model.Shipper;
import com.example.northwinds.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}