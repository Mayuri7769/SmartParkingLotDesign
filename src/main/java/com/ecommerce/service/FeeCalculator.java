package com.ecommerce.service;

import com.ecommerce.model.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class FeeCalculator {

    public double calculate(VehicleType type, LocalDateTime entry) {

        long hours = Math.max(1, Duration.between(entry, LocalDateTime.now()).toHours());

        switch (type) {
            case MOTORCYCLE: return hours * 10;
            case CAR: return hours * 20;
            case BUS: return hours * 50;
        }
        return 0;
    }
}
