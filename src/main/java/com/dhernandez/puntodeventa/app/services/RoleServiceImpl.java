package com.dhernandez.puntodeventa.app.services;

import com.dhernandez.puntodeventa.app.entities.Role;
import com.dhernandez.puntodeventa.app.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Role> findAll() {
        return(List<Role>) roleRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Role> findById(Long id) {
        return Optional.ofNullable(roleRepository.findById(id).orElse(null));
    }
    @Transactional
    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
    @Transactional
    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
