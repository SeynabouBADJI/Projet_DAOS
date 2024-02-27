package com.uasz.demo.modele.emploiDuTemps;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Emploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int duree;
    private int debut;
    private int fin;
    private String darecreation;

    @OneToMany(mappedBy = "emploi")
    private List<Seance> seance;
       

    
}
