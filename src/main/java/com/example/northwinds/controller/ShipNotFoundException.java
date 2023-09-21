package com.example.northwinds.controller;

public class ShipNotFoundException extends RuntimeException{
    public ShipNotFoundException(String message){
        super(message);
    }
}
