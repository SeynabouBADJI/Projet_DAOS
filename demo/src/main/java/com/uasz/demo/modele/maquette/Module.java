package com.uasz.demo.modele.maquette;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String libelle;
    private String cours;
    private Long duree;
    private String objectifs;
    private String description;
    private String datecreation;
    
    @ManyToOne
    private Ue ue;
    @ManyToOne
    private Ec ec;
    
}
