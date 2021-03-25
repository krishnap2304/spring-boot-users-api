package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    DemoService service;

    @GetMapping("/get-all-users")
    public List<User> getAll(){
        return service.getAllUsers();
    }

    @GetMapping("/get-user/{id}")
    public User getUser(@PathVariable String id){
        System.out.println("user id to fetch is:"+id);
        return service.getUser(id);
    }


    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody  User user){
        return service.createUser(user);
    }

    @PutMapping("/update-user")
    public ResponseEntity<User> updateUser(@RequestBody  User user){
        System.out.println(user);
        return service.updateUser(user);
    }
    @DeleteMapping("/delete-user")
    public ResponseEntity<User> deleteUser(@RequestBody User user){
        return service.deleteUser(user);
    }

}
