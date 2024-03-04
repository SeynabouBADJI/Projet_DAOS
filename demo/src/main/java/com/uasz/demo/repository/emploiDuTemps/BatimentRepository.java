package com.uasz.demo.repository.emploiDuTemps;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.emploiDuTemps.Batiment;
import com.uasz.demo.modele.emploiDuTemps.Salle;

@Repository
public interface BatimentRepository extends JpaRepository <Batiment ,Long>{
    @Query("select sa FROM Salle sa WHERE sa.batiment = ?1")
    List<Salle> findByBatiment(Batiment batiment);

   

}
