package org.daniel.controllers;

import org.daniel.models.User;
import org.daniel.repository.UserRepositoryImpl;
import org.daniel.repository.UserRespository;

import java.util.List;

public class UserController {

    UserRespository userRespository = new UserRepositoryImpl();

    public List<User> findAll()
    {
        return userRespository.findAll();
    }

    public User findById(Long id) {
        return userRespository.findById(id);
    }

    public void addUser (User user)
    {
        userRespository.addUser(user);
    }

    public boolean deleteUser(Long id) {
         return userRespository.deleteUser(id);
    }


}
