package Model;

import java.util.ArrayList;

public class Driver {
    private String name;
    private char gender;
    private int age;
    private String carName;
    private String carNumber;
    private boolean isAvailable;
    private int earning;
    private ArrayList<Integer> currentLocation;

    public Driver(String name, char gender, int age, String carName, String carNumber, ArrayList<Integer> currentLocation) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.carName = carName;
        this.carNumber = carNumber;
        this.isAvailable = true;
        this.earning = 0;
        this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }

    public ArrayList<Integer> getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(ArrayList<Integer> currentLocation) {
        this.currentLocation = currentLocation;
    }
}
