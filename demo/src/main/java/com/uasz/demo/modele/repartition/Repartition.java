package com.uasz.demo.modele.repartition;
import com.uasz.demo.modele.maquette.Enseignement;

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
public class Repartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private String datecreation;
    
    @ManyToOne
    private Enseignant enseignant;
    @ManyToOne
    private Enseignement enseignement;
    
}
