package com.learning.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    //to store all user details in the Database

    //UserDAOService -> static list
    private static List<Users> users = new ArrayList<>();

    static {
        users.add(new Users(1, "George", LocalDate.now().minusYears(25)));
        users.add(new Users(2, "Olivier", LocalDate.now().minusYears(30)));
        users.add(new Users(3, "Francois", LocalDate.now().minusYears(35)));
    }

    //implement method to be able to retrieve all users
    public List<Users> findAllUsers() {
        return users;
    }
    //to be able to save the details of a specific user


    //to be able to retrieve details of a specific user
    public Users findSpecificUser(int id) {
        Predicate<? super Users> predicate = users1 -> users1.getId().equals(id);
        return  users.stream().filter(predicate).findFirst().get();
    }
}
