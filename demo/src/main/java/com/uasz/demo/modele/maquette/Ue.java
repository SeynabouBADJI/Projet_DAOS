package com.uasz.demo.modele.maquette;

import java.util.List;

import com.uasz.demo.modele.utilisateur.Utilisateur;

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
public class Ue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String libelle;
    private String code;
    private String description;
    private int coefficient;
    private int credit;
    private String dateCreation;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "ue")
    private List<Ec> ecs;

    @OneToMany(mappedBy = "ue")
    private List<Module> module;
       
}