package Repository;

import Model.Driver;
import Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private UserRepository userRepository;
    private DriverRepository driverRepository;

    //To store the destination a user wants to go
    private Map<String, ArrayList<Integer>> userDestination;
    //To store the driver the user has chosen
    private Map<String, String> userDriver;

    public BookingRepository(UserRepository userRepository, DriverRepository driverRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
        this.userDestination = new HashMap<>();
        this.userDriver = new HashMap<>();
    }

    //To find the liust of available drivers
    public ArrayList<Driver> findRide(String userName, ArrayList<Integer> source, ArrayList<Integer> destination) {
        ArrayList<Driver> availableDrivers = new ArrayList<>();
        userDestination.put(userName, destination); //stores the destination user wants to go
        for(Driver driver: driverRepository.getDrivers()) {
            double distanceSquare = Math.pow(driver.getCurrentLocation().get(0) - source.get(0), 2)
                    + Math.pow(driver.getCurrentLocation().get(1) - source.get(1), 2); // Calcuates the sqaure of distance between driver and User
            if(distanceSquare <= 25 && driver.isAvailable()) {      // checks if driver is less than 5 units from user and if he is available
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }

    public void chooseRide(String userName, String driverName) {
        //Store the driver thge user has chosen
        userDriver.put(userName, driverName);

        driverRepository.changeDriverStatus(driverName, false); //Since user has chosen this driver then he's not available

        System.out.println("ride Started");
    }

    //To calculate the charge between source and destination
    public int calculateCharge(ArrayList<Integer> source, ArrayList<Integer> destination) {
        double distance = Math.pow(Math.pow(destination.get(0)- source.get(0), 2) + Math.pow(destination.get(1)- source.get(1),2), 0.5);

         return (int)Math.ceil(distance);
    }

    //To calculate Bill
    public int calculateBill(String userName) {
        String driverName = userDriver.get(userName);
        User user = userRepository.findUser(userName);
        int bill = calculateCharge(user.getCurrentLocation(), userDestination.get(userName));
        driverRepository.updateDriverLocation(driverName, userDestination.get(userName)); //Change the driverlocation to destination
        userRepository.updateUserLocation(userName, userDestination.get(userName)); //change the userlocation to destination
        driverRepository.changeDriverStatus(driverName, true); //Since the ride has ended change the driver status to available

        Driver driver = driverRepository.findDriver(driverName);
        if(driver!=null) {
            driver.setEarning(driver.getEarning()+bill);
        }


        return bill;
    }
    //To calculate the total earnings by all drivers
    public void findTotalEarning() {
        int i=1;
        for(Driver driver: driverRepository.getDrivers()) {
            System.out.println(i + ".   " + driver.getName() + " earn $" + driver.getEarning());
            i++;
        }
    }

}
