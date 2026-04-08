package com.ecommerce.strategy;

import com.ecommerce.model.*;

public interface ParkingStrategy {
    ParkingSpot findSpot(Vehicle vehicle, java.util.List<ParkingSpot> spots);
}
