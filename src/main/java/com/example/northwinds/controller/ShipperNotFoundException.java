package com.example.northwinds.controller;

public class ShipperNotFoundException extends RuntimeException{
    public ShipperNotFoundException(String message) {
        super(message);
    }
}
