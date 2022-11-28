package com.dhernandez.puntodeventa.app.repositories;

import com.dhernandez.puntodeventa.app.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends CrudRepository<Role,Long> {
}
