package com.ecommerce.service;

import com.ecommerce.model.*;

import java.util.*;

public class ParkingLot {

    private List<ParkingSpot> spots = new ArrayList<>();

    public ParkingLot(int floors, int spotsPerFloor) {
        int id = 1;
        for (int i = 0; i < floors * spotsPerFloor; i++) {

            SpotType type;
            if (i % 3 == 0) type = SpotType.SMALL;
            else if (i % 3 == 1) type = SpotType.MEDIUM;
            else type = SpotType.LARGE;

            spots.add(new ParkingSpot(id++, type));
        }
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
