package com.uasz.demo.repository.repartition;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.emploiDuTemps.Seance;
import com.uasz.demo.modele.repartition.Repartition;

@Repository

public interface RepartitionRepository extends JpaRepository<Repartition ,Long>{


    @Query("select se FROM Seance se WHERE se.repartition = ?1")
    List<Seance> findByRepartition(Repartition repartition);
    
}