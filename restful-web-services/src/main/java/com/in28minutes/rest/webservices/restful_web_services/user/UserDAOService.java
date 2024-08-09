package com.in28minutes.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    /*
    * Methods required:
    *     Retrieve all users
    *     Create a user
    *     find a user
    *
    * And these methods should be processed using JPA/Hibernate with Database
    * */

    private static List<User> users = new ArrayList<>();

    private static int usersCounter = 0;

    static{
        users.add(new User(++usersCounter,"Aravind", LocalDate.now().minusYears(28)));
        users.add(new User(++usersCounter,"Kishore", LocalDate.now().minusYears(32)));
        users.add(new User(++usersCounter,"Seetha", LocalDate.now().minusYears(51)));
    }

    //Retrieve all users
    public List<User> findAll(){
        return users;
    }

    //Create a user
    public User save(User user){
        user.setId(++usersCounter);
        users.add(user);
        return user;
    }

    //Find a user
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    //Delete a User
    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

}
