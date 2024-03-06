package com.uasz.demo.modele.maquette;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String libelle;
    private String description;
    private String datecreation;
    @OneToMany(mappedBy = "semestre")
      @JsonIgnore
    private List<Module> module;
    @OneToMany(mappedBy = "semestre")
    @JsonIgnore
    private List<Classe> classe;
    
       

    
}