package com.uasz.demo.repository.maquette;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.uasz.demo.modele.maquette.Niveau;
import com.uasz.demo.modele.maquette.Cycle;



@Repository
public interface CycleRepository extends JpaRepository <Cycle ,Long>{
    @Query("select niv FROM Niveau niv WHERE niv.cycle = ?1")
    List<Niveau> findByCycleNiveau(Cycle cycle);

  

}