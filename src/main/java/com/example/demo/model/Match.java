package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "match")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="unMatch")
    @JsonIgnoreProperties("unMatch")
    private List<Team> list_teams;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy="myMatch")
    @JsonIgnoreProperties("myMatch")
    private Score score;
    //LinkedHashMap<User,Integer> Ordenado
    ///relaciones entre tablas

}
