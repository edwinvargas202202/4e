package com.example.demo.controller;

import com.example.demo.crudRepository.Crud_Repository_User;
import com.example.demo.model.User;
import com.example.demo.services.Service_User;
import com.example.demo.crudRepository.Crud_Repository_User;
import com.example.demo.model.User;
import com.example.demo.services.Service_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class Controller_User {
    @Autowired
    Service_User myService_User;
    Crud_Repository_User unCrud_repository_user;
    @GetMapping("/{id}")
    public Optional<User> get_User(@PathVariable("id") String cc){
        return myService_User.checkUser_get(cc);
    }
    @GetMapping("/all_users")
    public List<User> get_Score_User(){
        return myService_User.get_all();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save_User(@RequestBody User unUser){
        return unCrud_repository_user.save(unUser);
    }


}
