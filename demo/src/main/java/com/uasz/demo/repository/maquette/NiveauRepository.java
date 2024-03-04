package com.uasz.demo.repository.maquette;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Formation;

import com.uasz.demo.modele.maquette.Niveau;

@Repository
public interface NiveauRepository extends JpaRepository <Niveau ,Long>{
    @Query("select formation FROM Formation formation WHERE formation.niveau = ?1")
    List<Formation> findByNiveau(Niveau niveau);

  

}