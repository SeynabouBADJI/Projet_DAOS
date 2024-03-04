package com.uasz.demo.modele.emploiDuTemps;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String libelle;
    private String code;
    private int capacite;
    private String description;
    private String datecreation;

    @ManyToOne 
    private Batiment batiment;
    @OneToMany(mappedBy = "salle")
    private List<Seance> seance;
       

    
}
