package com.uasz.demo.modele.maquette;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uasz.demo.modele.repartition.Repartition;

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
@Data @AllArgsConstructor @NoArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String libelle;
    private String objectifs;
    private String description;
    private String datecreation;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Groupe groupe;
    @ManyToOne
    private Module module;
     @OneToMany(mappedBy = "enseignement")
       @JsonIgnore
    private List<Repartition> repartition;


    
}