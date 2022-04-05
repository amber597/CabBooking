package Repository;

import Model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    private List<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    //To find driver from username
    public Driver findDriver(String driverName) {
        for(Driver driver: drivers) {
            if(driverName.compareTo(driver.getName())==0) {
                return driver;
            }
        }
        return null;
    }

    //To add driver
    public void addDriver(String driverDetails, String carDetails, ArrayList<Integer> carLocation) {

        String[] driverDetailsList = driverDetails.split(",");
        String name = driverDetailsList[0];
        char gender = driverDetailsList[1].charAt(1);
        int age = Integer.parseInt(driverDetailsList[2].substring(1));

        String[] carDetailsList = carDetails.split(",");

        String carName = carDetailsList[0];
        String carNumber = carDetailsList[1];

        drivers.add(new Driver(name, gender, age, carName, carNumber, carLocation));
    }
    //To update driver Location
    public void updateDriverLocation(String driverName, ArrayList<Integer> location) {

        Driver driver = findDriver(driverName);
        if(driver!=null) {
            driver.setCurrentLocation(location);
        }

    }

    //To update driver Status
    public void changeDriverStatus(String driverName, boolean status) {
        Driver driver = findDriver(driverName);
        if(driver!=null) {
            driver.setAvailable(status);
        }
    }
}
