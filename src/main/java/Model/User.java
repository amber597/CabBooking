package Model;

import java.util.ArrayList;

public class User {
    private String name;
    private char gender;
    private int age;
    private ArrayList<Integer> currentLocation;

    public User(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
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

    public ArrayList<Integer> getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(ArrayList<Integer> currentLocation) {
        this.currentLocation = currentLocation;
    }
}
