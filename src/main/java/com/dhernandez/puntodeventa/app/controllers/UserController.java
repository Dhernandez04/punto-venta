package com.dhernandez.puntodeventa.app.controllers;

import com.dhernandez.puntodeventa.app.entities.Role;
import com.dhernandez.puntodeventa.app.entities.User;
import com.dhernandez.puntodeventa.app.services.RoleService;
import com.dhernandez.puntodeventa.app.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @GetMapping("/list")
    ResponseEntity<List<User>> list(){
        logger.info("Start method to list roles");
        List<User> users = userService.findAll();
        logger.info("End  method to list roles");
        return  ResponseEntity.ok(users);

    }

    @GetMapping("/getById/{id}")
    ResponseEntity<User> getById(@PathVariable("id") Long id){
        logger.info("Start method to get a user");
        Optional<User> user =  userService.findById(id);
        logger.info("end method to get a user");
        return  ResponseEntity.ok(user.get());
    }

    @PostMapping("/save")
    ResponseEntity<Boolean> save(@RequestBody User user){
        logger.info("Start method to save user");
        userService.save(user);
        logger.info("End  method to save user");
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Boolean> update(@RequestBody User user,@PathVariable Long id){
        logger.info("Start method to update categories");
        Optional<User> userDB =  userService.findById(id);
        if(!userDB.isPresent()){
            throw  new RuntimeException("No existe el usuario con id "+id);
        }
        userService.save(user);
        logger.info("End  method to update categories");
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/deleById")
    ResponseEntity<Boolean> deleById(@PathVariable Long id){
        logger.info("Start method to deleById user");
        Optional<User> userDB =  userService.findById(id);
        if(!userDB.isPresent()){
            throw  new RuntimeException("No existe el usuario con id "+id);
        }
        userService.deleteById(id);
        logger.info("End method to deleById user");
        return  ResponseEntity.ok(true);
    }
}
