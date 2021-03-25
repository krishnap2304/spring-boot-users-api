package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    List<User> users = new ArrayList<>();


    public List<User> getAllUsers(){
        return users;
    }

    public User getUser(String id){
        List<User> users = getAllUsers();
        for(User user_to_fetch : users) {
            if (user_to_fetch.getId().equals(id)) {
                return user_to_fetch;
            }
        }
        return null;
    }

    public ResponseEntity<User> createUser(User user){
        if (!checkIfUserExists(user)) {
            users.add(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
    }

    private boolean checkIfUserExists(User user) {
        for (User user_to_update : users)
            if (user.getId() == user_to_update.getId()) {
                return true;
            }
        return false;
    }
    public ResponseEntity<User> updateUser(User user){
        for(User user_to_update : users)
            if (user.getId() == user_to_update.getId()){
                 if (user.getName() != user_to_update.getName()){
                     user_to_update.setName(user.getName());
                 }
                if (user.getDesignation() != user_to_update.getDesignation()){
                    user_to_update.setDesignation(user.getDesignation());
                }
            }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
    }

    public ResponseEntity deleteUser(User user){
        for(User user_to_update : users)
            if (user.getId() == user_to_update.getId()){
                users.remove(user);
            }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);

    }
}
