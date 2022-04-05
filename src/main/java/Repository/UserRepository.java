package Repository;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    //To find a User from username
    User findUser(String userName) {
        for(User user: users) {
            if(userName.compareTo(user.getName())==0) {
                return user;
            }
        }
        return null;
    }
    //To add a new user
    public void addUser(String userDetails) {
        String[] userDetailsList = userDetails.split(",");
        String name = userDetailsList[0];
        char gender = userDetailsList[1].charAt(1);
        int age = Integer.parseInt(userDetailsList[2].substring(1));

        users.add(new User(name, gender, age));
    }

    //To update userdetails
    public void updateUser(String userName, String updatedDetails) {
        User user = findUser(userName);
        if(user!=null) {
            String[] userDetailsList = updatedDetails.split(",");
            String name = userDetailsList[0];
            char gender = userDetailsList[1].charAt(1);
            int age = Integer.parseInt(userDetailsList[2].substring(1));
            user.setName(name);
            user.setGender(gender);
            user.setAge(age);
        }
    }

    //To update user location
    public void updateUserLocation(String userName, ArrayList<Integer> location) {

        User user = findUser(userName);
        if(user!=null) {
            user.setCurrentLocation(location);
        }
    }
}
