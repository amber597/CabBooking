package Service;

import Repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String userDetails) {
        userRepository.addUser(userDetails);
    }

    public void updateUser(String userName, String updatedDetails) {
        userRepository.updateUser(userName, updatedDetails);
    }

    public void updateUserLocation(String userName, Integer[] location) {
        userRepository.updateUserLocation(userName, new ArrayList<>(Arrays.asList(location)));
    }
}
