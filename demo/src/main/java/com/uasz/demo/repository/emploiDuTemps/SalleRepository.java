package com.uasz.demo.repository.emploiDuTemps;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.uasz.demo.modele.emploiDuTemps.Salle;
import com.uasz.demo.modele.emploiDuTemps.Seance;

@Repository

public interface SalleRepository extends JpaRepository <Salle ,Long>{

    @Query("select se FROM Seance se WHERE se.salle = ?1")
    List<Seance> findBySalle(Salle salle);
    
}
