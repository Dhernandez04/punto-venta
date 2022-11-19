package com.dhernandez.puntodeventa.app.services;

import com.dhernandez.puntodeventa.app.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    void save(Category category);
    void deleteById(Long id);
}
