package com.ecommerce.model;

import java.time.LocalDateTime;

public class Ticket {
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}