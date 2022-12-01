package com.example.demo.services;

import com.example.demo.repository.User_Repository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@Service
@CrossOrigin("*")
public class Service_User {
    @Autowired
    User_Repository myUser_Repository;

    public List<User> get_all() {
        return myUser_Repository.getAllUsers();
    }
    public User checkUser_add(User usuario) {
        if(myUser_Repository.exist_user(usuario.getCc_id())==false){
            return myUser_Repository.create_User(usuario);
        }
        Optional<User> mylista=myUser_Repository.getUserById(usuario.getCc_id());
        return mylista.get();
    }
    public Optional<User> checkUser_get(String cc) {
        for(User unUser:myUser_Repository.getAllUsers()){
            if(unUser.getCc_id()+""==cc){
                return myUser_Repository.getUserById(Integer.parseInt(cc));
            }
        }
        return null;
    }
}
