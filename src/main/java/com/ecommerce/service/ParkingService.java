package com.ecommerce.service;

import com.ecommerce.model.*;
import com.ecommerce.strategy.*;

import java.util.concurrent.locks.ReentrantLock;

public class ParkingService {

    private ParkingLot lot;
    private ParkingStrategy strategy = new NearestSpotStrategy();
    private FeeCalculator feeCalculator = new FeeCalculator();

    private ReentrantLock lock = new ReentrantLock();

    public ParkingService(ParkingLot lot) {
        this.lot = lot;
    }

    public Ticket checkIn(Vehicle vehicle) {

        lock.lock();
        try {
            ParkingSpot spot = strategy.findSpot(vehicle, lot.getSpots());

            if (spot == null) {
                System.out.println("No spot available!");
                return null;
            }

            spot.occupy();
            Ticket ticket = new Ticket(vehicle, spot);

            System.out.println("Vehicle Parked: " + vehicle.getNumber() +
                    " at Spot: " + spot.getId());

            return ticket;

        } finally {
            lock.unlock();
        }
    }

    public void checkOut(Ticket ticket) {

        lock.lock();
        try {
            double fee = feeCalculator.calculate(
                    ticket.getVehicle().getType(),
                    ticket.getEntryTime()
            );

            ticket.getSpot().free();

            System.out.println("Vehicle Exit: " + ticket.getVehicle().getNumber());
            System.out.println("Parking Fee: ₹" + fee);

        } finally {
            lock.unlock();
        }
    }
}
