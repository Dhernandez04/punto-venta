package com.dhernandez.puntodeventa.app.services;

import com.dhernandez.puntodeventa.app.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> findAll();
    Optional<Role> findById(Long id);
    void save(Role role);
    void deleteById(Long id);
}
