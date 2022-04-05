package Driver;

import Repository.BookingRepository;
import Repository.DriverRepository;
import Repository.UserRepository;
import Service.BookingService;
import Service.DriverService;
import Service.UserService;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        DriverRepository driverRepository = new DriverRepository();
        BookingRepository bookingRepository = new BookingRepository(userRepository, driverRepository);

        UserService userService = new UserService(userRepository);
        DriverService driverService = new DriverService(driverRepository);
        BookingService bookingService = new BookingService(bookingRepository);

        userService.addUser("Abhishek, M, 23");
        userService.updateUserLocation("Abhishek", new Integer[]{0,0});
        userService.addUser("Rahul, M, 29");
        userService.updateUserLocation("Rahul", new Integer[]{10,0});
        userService.addUser("Nandini, F, 22");
        userService.updateUserLocation("Nandini", new Integer[]{15,6});

        driverService.addDriver("Driver1, M, 22", "Swift, KA-01-12345", new Integer[]{10,1});
        driverService.addDriver("Driver2, M, 29", "Swift, KA-01-12345", new Integer[]{11,10});
        driverService.addDriver("Driver3, M, 23", "Swift, KA-01-12345", new Integer[]{5,3});

        bookingService.findRide("Abhishek", new Integer[]{0, 0}, new Integer[]{20, 1});
        bookingService.findRide("Rahul", new Integer[]{10,0}, new Integer[]{15,3});
        bookingService.chooseRide("Rahul", "Driver1");
        bookingService.calculateBill("Rahul");
        driverService.updateDriverStatus("Driver1", false);
        bookingService.findRide("Nandini", new Integer[]{15,6}, new Integer[]{20, 4});

        bookingService.findTotalEarning();
    }
}
