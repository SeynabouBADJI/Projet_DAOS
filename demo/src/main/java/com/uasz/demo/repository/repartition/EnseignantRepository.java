package com.uasz.demo.repository.repartition;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.uasz.demo.modele.repartition.Enseignant;
import com.uasz.demo.modele.repartition.Repartition;

@Repository

public interface EnseignantRepository extends JpaRepository<Enseignant ,Long>{
     @Query("select re FROM Repartition re WHERE re.enseignant = ?1")
    List<Repartition> findByEnseignant(Enseignant enseignant);

    
}