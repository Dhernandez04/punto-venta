package com.dhernandez.puntodeventa.app.services;

import com.dhernandez.puntodeventa.app.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void deleteById(Long id);
}
