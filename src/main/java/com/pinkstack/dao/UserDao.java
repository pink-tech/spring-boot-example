package com.pinkstack.dao;

import com.pinkstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("userDao")
public class UserDao {

    @Autowired
    private User powerPuffUser;

    //This will have a null entry for powerPuffUser. Using it anywhere, will end up in NullPointerException.
    private List<User> users = getUsersList();

    public List<User> getAllUsers() {
        return getUsersList();
        //If instead we "return users;", we will get an empty row in the output.
        //This is because the variable users is created before the creation of the bean.
    }

    public List<String> getAllUserNames() {
        List<String> names = new ArrayList<String>();
//        for (User user : users) {    <- This will end up in a NullPointerException
        for (User user : getUsersList()) {
            names.add(user.getName());
        }
        return names;
    }

    public User getUserByName(String name) {
        for (User user : getUsersList()) {
            //since this is String comparison, don't use == here
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(int id) {
        for (User user : getUsersList()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean validateEmailIdAndPassword(String emailId, String password) {
        for (User user : getUsersList()) {
            if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getUsersList() {
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("johndoe123@gmail.com");
        user1.setName("John Doe");
        user1.setPassword("pass123");
        User user2 = new User();
        user2.setId(2);
        user2.setEmail("amitsingh@gmail.com");
        user2.setName("Amit Singh");
        user2.setPassword("password");
        User user3 = new User();
        user3.setId(3);
        user3.setEmail("bipulkumar@gmail.com");
        user3.setName("Bipul Kumar");
        user3.setPassword("pswd");
        User user4 = new User();
        user4.setId(4);
        user4.setEmail("prakashranjan@gmail.com");
        user4.setName("Prakash Ranjan");
        user4.setPassword("pass");
        return Arrays.asList(user1, user2, user3, user4, powerPuffUser);
    }

}
