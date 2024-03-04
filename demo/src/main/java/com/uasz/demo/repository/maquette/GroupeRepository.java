package com.uasz.demo.repository.maquette;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Enseignement;
import com.uasz.demo.modele.maquette.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository <Groupe ,Long>{
    @Query("select enseignement FROM Enseignement enseignement WHERE enseignement.groupe = ?1")
    List<Enseignement> findByGroupeEnseignement(Groupe groupe);

  

}