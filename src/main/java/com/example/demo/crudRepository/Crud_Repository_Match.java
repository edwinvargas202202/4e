package com.example.demo.crudRepository;

import com.example.demo.model.Match;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Crud_Repository_Match extends JpaRepository<Match,String> {
}
