package com.example.demo.controller;

import com.example.demo.crudRepository.Crud_Repository_User;
import com.example.demo.model.Match;
import com.example.demo.model.User;
import com.example.demo.services.Service_Match;
import com.example.demo.services.Service_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/match")
@CrossOrigin("*")
public class Controller_Match {
    @Autowired
    Service_Match myService_Match;
    Crud_Repository_User unCrud_repository_user;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save_match(@RequestBody List<Match> partidos){
        myService_Match.check_partidos(partidos);
    }


}
