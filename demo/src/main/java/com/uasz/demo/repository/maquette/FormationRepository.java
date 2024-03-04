package com.uasz.demo.repository.maquette;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Classe;
import com.uasz.demo.modele.maquette.Formation;



@Repository
public interface FormationRepository extends JpaRepository <Formation ,Long>{
    @Query("select classe FROM Classe classe WHERE classe.formation = ?1")
    List<Classe> findByFormation(Formation formation);

  

}