import com.ecommerce.model.*;
import com.ecommerce.service.*;


public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(2, 10);
        ParkingService service = new ParkingService(parkingLot);

        Vehicle car = new Vehicle("MH12AB1234", VehicleType.CAR);
        Vehicle bike = new Vehicle("MH14XY5678", VehicleType.MOTORCYCLE);

        Ticket t1 = service.checkIn(car);
        Ticket t2 = service.checkIn(bike);

        sleep(3000);

        service.checkOut(t1);
        service.checkOut(t2);
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (Exception e) {}
    }
}