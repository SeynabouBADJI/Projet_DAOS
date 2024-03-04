package com.uasz.demo.modele.maquette;

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
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String libelle;
    private int effectif;
    private int nbreGroupe;
    private String description;
    private String datecreation;

    @ManyToOne
    private Formation formation;
    @ManyToOne
    private Semestre semestre;
    @OneToMany(mappedBy = "classe")
    private List<Groupe> groupe;
    @OneToMany(mappedBy = "classe")
    private List<Enseignement> enseignement;
       

    
}