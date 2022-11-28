package com.dhernandez.puntodeventa.app.repositories;

import com.dhernandez.puntodeventa.app.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
