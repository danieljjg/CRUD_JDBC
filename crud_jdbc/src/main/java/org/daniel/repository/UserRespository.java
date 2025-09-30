package org.daniel.repository;

import org.daniel.models.User;

import java.util.List;

public interface UserRespository {

    List<User> findAll();
    User findById(Long id);
    void addUser(User user);
    boolean deleteUser(Long id);
    boolean modifyUser(Long id);

}
