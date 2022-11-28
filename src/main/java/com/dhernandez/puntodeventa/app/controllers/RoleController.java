package com.dhernandez.puntodeventa.app.controllers;

import com.dhernandez.puntodeventa.app.entities.Role;
import com.dhernandez.puntodeventa.app.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    RoleService roleService;
    @GetMapping("/list")
    ResponseEntity<List<Role>> list(){
        logger.info("Start method to list roles");
        List<Role> roles = roleService.findAll();
        logger.info("End  method to list roles");
        return  ResponseEntity.ok(roles);

    }

    @GetMapping("/getById/{id}")
    ResponseEntity<Role> getById(@PathVariable("id") Long id){
        logger.info("Start method to get a role");
        Optional<Role> role =  roleService.findById(id);
        logger.info("end method to get a role");
        return  ResponseEntity.ok(role.get());
    }

    @PostMapping("/save")
    ResponseEntity<Boolean> save(@RequestBody Role role){
        logger.info("Start method to save role");
        roleService.save(role);
        logger.info("End  method to save role");
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Boolean> update(@RequestBody Role role,@PathVariable Long id){
        logger.info("Start method to update categories");
        Optional<Role> roleDB =  roleService.findById(id);
        if(!roleDB.isPresent()){
            throw  new RuntimeException("No existe el rol con id "+id);
        }
        roleService.save(role);
        logger.info("End  method to update categories");
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/deleById")
    ResponseEntity<Boolean> deleById(@PathVariable Long id){
        logger.info("Start method to deleById category");
        Optional<Role> roleDB =  roleService.findById(id);
        if(!roleDB.isPresent()){
            throw  new RuntimeException("No existe el rol con id "+id);
        }
        roleService.deleteById(id);
        logger.info("End method to deleById category");
        return  ResponseEntity.ok(true);
    }
}
