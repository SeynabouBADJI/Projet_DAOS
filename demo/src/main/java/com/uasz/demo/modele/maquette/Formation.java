package com.uasz.demo.modele.maquette;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String libelle;
    private String description;
    private String datecreation;
    @ManyToOne
    private Niveau niveau;
    @ManyToOne
    private Filiere filiere;
    @OneToMany(mappedBy = "formation")
      @JsonIgnore
    private List<Classe> classe;
    @OneToOne(mappedBy = "formation")
    private Maquette maquette;

       

    
}