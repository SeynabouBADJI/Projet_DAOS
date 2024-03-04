package com.uasz.demo.modele.emploiDuTemps;
import com.uasz.demo.modele.repartition.Repartition;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
 @NoArgsConstructor 
 @AllArgsConstructor
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String jour;
    private int duree;
    private int debut;
    private int fin;
    private int numero;
    private String datecreation;

    @ManyToOne 
    private Salle salle;
    @ManyToOne 
    private Repartition repartition;
    @ManyToOne 
    private Emploi emploi ;
    @OneToOne(mappedBy = "seance")
    private Deroulement deroulement;
       

    
}

