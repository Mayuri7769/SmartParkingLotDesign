package com.ecommerce.strategy;

import com.ecommerce.model.*;

import java.util.List;

public class NearestSpotStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> spots) {

        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && matches(vehicle, spot)) {
                return spot;
            }
        }
        return null;
    }

    private boolean matches(Vehicle v, ParkingSpot s) {
        switch (v.getType()) {
            case MOTORCYCLE: return true;
            case CAR: return s.getType() != SpotType.SMALL;
            case BUS: return s.getType() == SpotType.LARGE;
        }
        return false;
    }
}
