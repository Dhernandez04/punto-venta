package com.dhernandez.puntodeventa.app.services;

import com.dhernandez.puntodeventa.app.entities.Category;
import com.dhernandez.puntodeventa.app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
@Service

public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return ( List<Category>)categoryRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(categoryRepository.findById(id).orElse(null));
    }

    @Transactional
    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }
    @Transactional
    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
