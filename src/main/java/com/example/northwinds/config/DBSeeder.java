package com.example.northwinds.config;

import com.example.northwinds.model.Ship;
import com.example.northwinds.model.Shipper;
import com.example.northwinds.repository.ShipRepository;
import com.example.northwinds.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile({"dbseeder"})
public class DBSeeder implements CommandLineRunner {

    Shipper shipperOne = new Shipper(null, "Speedy Express","(503) 555-9831");
    Shipper shipperTwo = new Shipper(null, "Speedy Quickly","(503) 555-9832");
    Shipper shipperThree =  new Shipper(null, "Speedy Fast","(503) 555-9833");
    Shipper shipperFour = new Shipper(null, "Speeding Ahead","(503) 555-9834");

    Ship ship = new Ship(null, "Oil Tanker");

    private List<Ship> createShips() {

        Ship shipOne = new Ship(null, "Big Oil Tanker");
        Ship shipTwo = new Ship(null, "Big Cargo Ship");
        Ship shipThree = new Ship(null, "Cruise Ship");
        shipOne.setShipper(shipperOne);
        return List.of(shipOne);

    }

    public List<Ship> DB_SEEDER_SHIPS = createShips();
    public List<Shipper> DB_SEEDER_SHIPPERS = List.of(
            shipperOne,
            shipperTwo,
            shipperThree,
            shipperFour
    );


    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Override
    public void run(String... args) throws Exception{
        shipperRepository.saveAll(DB_SEEDER_SHIPPERS);
        shipRepository.saveAll(DB_SEEDER_SHIPS);
    }
}
