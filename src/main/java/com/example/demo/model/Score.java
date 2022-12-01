package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "score")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Score;
    private Integer num_Gols_Team_1;
    private Integer num_Gols_Team_2;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Match myMatch;


}
