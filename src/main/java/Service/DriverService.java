package Service;

import Repository.DriverRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void addDriver(String driverDetails, String vehicleDetails, Integer[] location) {
        this.driverRepository.addDriver(driverDetails, vehicleDetails, new ArrayList<>(Arrays.asList(location)));
    }

    public void updateDriverLocation(String driverName, ArrayList<Integer> location) {
        this.driverRepository.updateDriverLocation(driverName, location);
    }

    public void updateDriverStatus(String driverName, boolean status) {
        this.driverRepository.changeDriverStatus(driverName, status);
    }
}
