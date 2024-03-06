package com.uasz.demo.modele.repartition;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("Per")
public class Per extends Enseignant{
    private String matricule;

    
}