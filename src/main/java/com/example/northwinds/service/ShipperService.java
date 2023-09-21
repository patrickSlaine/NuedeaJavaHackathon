package com.example.northwinds.service;

import com.example.northwinds.controller.ShipperNotFoundException;
import com.example.northwinds.model.Shipper;
import com.example.northwinds.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository shipperRepository;

    public List<Shipper> readAllShippers(){
        return shipperRepository.findAll();
    }

    public Shipper readShipperById(Long id){
        return shipperRepository.findById(id).orElseThrow(()-> new ShipperNotFoundException("No Shipper with Id: "+ id + " found."));
    }

    public Shipper createShipper(Shipper shipper){
        return shipperRepository.save(shipper);
    }

    public Shipper updateShipper(Long id, Shipper shipper){
        this.readShipperById(id);
        shipper.setId(id);
        return shipperRepository.save(shipper);
    }

    public void deleteShipperById(Long id){
        this.readShipperById(id);
        shipperRepository.deleteById(id);
    }

    public List<Shipper> findSpecialShippersByPhoneNumberPattern(String phoneNumberPattern) {
        List<Shipper> allShippers = shipperRepository.findAll();

        List<Shipper> specialShippers = allShippers.stream()
                .filter(shipper -> shipper.getPhone().contains(phoneNumberPattern))
                .collect(Collectors.toList());

        return specialShippers;
    }

}

