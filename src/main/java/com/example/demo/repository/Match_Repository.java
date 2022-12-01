package com.example.demo.repository;

import com.example.demo.crudRepository.Crud_Repository_Match;
import com.example.demo.model.Match;
import com.example.demo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class Match_Repository {

    @Autowired
    Crud_Repository_Match unCrud_repository_Match;

    public List<Match> save_match(List<Match> partidos){
        return unCrud_repository_Match.saveAll(partidos);
    }
    public Optional<Match> get_Match(Integer id){
        return unCrud_repository_Match.findById(""+id);
    }

    public Match save_one_match(Match partido){
        return unCrud_repository_Match.save(partido);
    }
    public ArrayList<Match> get_Match_X_Team(String first_equipo){
        ArrayList<Match> mylista= new ArrayList<>();
        for (Match  unMatch: unCrud_repository_Match.findAll()){
            if(unMatch.getList_teams().get(0).getName()==first_equipo){
                mylista.add(unMatch);
            }
        }

        return mylista;
    }
    public Match update(Match unMatch){
        return unCrud_repository_Match.save(unMatch);
    }

    public List<Team> get_Match_XLocal(){

        List<Team> lista_local=new ArrayList<>();
        for (Match unMatch: unCrud_repository_Match.findAll()){
            lista_local.add(unMatch.getList_teams().get(0));
        };
        return lista_local;
    }

    public List<Team> get_Match_XVisitante(){
        List<Team> lista_local=new ArrayList<>();
        for (Match unMatch: unCrud_repository_Match.findAll()){
            lista_local.add(unMatch.getList_teams().get(1));
        };
        return lista_local;
    }






}
