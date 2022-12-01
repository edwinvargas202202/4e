package com.example.demo.repository;

import com.example.demo.crudRepository.Crud_Repository_User;
import com.example.demo.model.User;
import com.example.demo.crudRepository.Crud_Repository_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class User_Repository {
    @Autowired
    Crud_Repository_User unCrud_repository_user;

    public boolean exist_user(Integer id){
        return unCrud_repository_user.existsById(""+id);
    }
    public User create_User(User usuario) {
        return unCrud_repository_user.save(usuario);
    }
    public List<User> getAllUsers() {
        return unCrud_repository_user.findAll();
        ///organizar por el puntaje o punto
    }
    public Optional<User> getUserById(Integer id){
        return unCrud_repository_user.findById(""+id);
    }

}
