package com.uasz.demo.modele.utilisateur;

import java.util.Collection;

import com.uasz.demo.modele.maquette.Ue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idUser ;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "utilisateur")
    private Collection<Ue> util ;



    
}