package com.example.demo.services;

import com.example.demo.model.Match;
import com.example.demo.model.Score;
import com.example.demo.model.Team;
import com.example.demo.model.User;
import com.example.demo.repository.Match_Repository;
import com.example.demo.repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin("*")
public class Service_Match {
    @Autowired
    Match_Repository myMatch_Repository;

    public void check_partidos(List<Match> partidos) {

        Iterator<Match> it = partidos.iterator();

        while (it.hasNext()) {
            Match match_input = it.next();
            boolean comp = false;
            for (Team local : myMatch_Repository.get_Match_XLocal()) {

                for (Team visitante : myMatch_Repository.get_Match_XVisitante()) {
                    if (local.getName() == match_input.getList_teams().get(0).getName() && visitante.getName() == match_input.getList_teams().get(1).getName()) {
                        comp = true;
                        Optional<Match> get_match = myMatch_Repository.get_Match(match_input.getId());
                        get_match.get().setScore(match_input.getScore());
                        myMatch_Repository.update(get_match.get());
                        break;
                    }
                }
                if (comp = true) {
                    break;
                }
                if (comp == false) {
                    myMatch_Repository.save_one_match(match_input);
                }
            }

        }
    }
}
