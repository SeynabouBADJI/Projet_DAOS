package com.uasz.demo.repository.maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Enseignement;
import com.uasz.demo.modele.repartition.Repartition;

@Repository
public interface EnseignementRepository extends JpaRepository<Enseignement,Long>{
     @Query("select re FROM Repartition re WHERE re.enseignement = ?1")
    List<Repartition> findByEnseignement(Enseignement enseignement);
    
}
