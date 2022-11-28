package com.dhernandez.puntodeventa.app.controllers;

import com.dhernandez.puntodeventa.app.entities.Category;
import com.dhernandez.puntodeventa.app.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    CategoryService categoryService;
    @GetMapping("/list")
    ResponseEntity<List<Category>> list(){
        logger.info("Start method to list categories");
        List<Category> categories = categoryService.findAll();
        logger.info("End  method to list categories");
        return  ResponseEntity.ok(categories);

    }

    @GetMapping("/getById/{id}")
    ResponseEntity<Category> getById(@PathVariable("id") Long id){
        logger.info("Start method to get a category");
       Optional<Category> category =  categoryService.findById(id);
        logger.info("end method to get a category");
        return  ResponseEntity.ok(category.get());
    }

    @PostMapping("/save")
    ResponseEntity<Boolean> save(@RequestBody Category category){
        logger.info("Start method to save categories");
        categoryService.save(category);
        logger.info("End  method to save categories");
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Boolean> update(@RequestBody Category category,@PathVariable Long id){
        logger.info("Start method to update categories");
       Optional<Category> categoryDB =  categoryService.findById(id);
       if(!categoryDB.isPresent()){
           throw  new RuntimeException("No existe la categoria con id "+id);
       }
        categoryService.save(category);
        logger.info("End  method to update categories");
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/deleById")
    ResponseEntity<Boolean> deleById(@PathVariable Long id){
        logger.info("Start method to deleById category");
        Optional<Category> categoryDB =  categoryService.findById(id);
        if(!categoryDB.isPresent()){
            throw  new RuntimeException("No existe la categoria con id "+id);
        }
        categoryService.deleteById(id);
        logger.info("End method to deleById category");
        return  ResponseEntity.ok(true);
    }
}
