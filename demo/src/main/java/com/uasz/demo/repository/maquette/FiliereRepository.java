package com.uasz.demo.repository.maquette;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.uasz.demo.modele.maquette.Formation;
import com.uasz.demo.modele.maquette.Filiere;



@Repository
public interface FiliereRepository extends JpaRepository <Filiere ,Long>{
    @Query("select for FROM Formation for WHERE for.filiere = ?1")
    List<Formation> findByFiliere(Filiere filiere);

  

}