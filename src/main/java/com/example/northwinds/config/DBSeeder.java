package com.example.northwinds.config;

import com.example.northwinds.model.Shipper;
import com.example.northwinds.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile({"dbseeder"})
public class DBSeeder implements CommandLineRunner {

    public static final List<Shipper> DB_SEEDER_SHIPPERS = List.of(
            new Shipper(null, "Speedy Express","(503) 555-9831"),
            new Shipper(null, "Speedy Quickly","(503) 555-9832"),
            new Shipper(null, "Speedy Fast","(503) 555-9833"),
            new Shipper(null, "Speeding Ahead","(503) 555-9834")
    );

    @Autowired
    private ShipperRepository shipperRepository;

    @Override
    public void run(String... args) throws Exception{
        shipperRepository.saveAll(DB_SEEDER_SHIPPERS);
    }
}
