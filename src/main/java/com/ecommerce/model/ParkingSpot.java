package com.ecommerce.model;

public class ParkingSpot {
    private int id;
    private SpotType type;
    private boolean isAvailable;

    public ParkingSpot(int id, SpotType type) {
        this.id = id;
        this.type = type;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void occupy() {
        isAvailable = false;
    }

    public void free() {
        isAvailable = true;
    }

    public SpotType getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}