package com.uasz.demo.repository.emploiDuTemps;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.uasz.demo.modele.emploiDuTemps.Emploi;
import com.uasz.demo.modele.emploiDuTemps.Seance;

@Repository
public interface EmploiRepository extends JpaRepository <Emploi ,Long>{



    @Query("select se FROM Seance se WHERE se.emploi = ?1")
    List<Seance> findByEmploi(Emploi emploi);


}
