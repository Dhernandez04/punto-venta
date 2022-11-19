package com.dhernandez.puntodeventa.app.repositories;

import com.dhernandez.puntodeventa.app.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
