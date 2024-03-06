package com.uasz.demo.repository.maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Enseignement;
import com.uasz.demo.modele.maquette.Module;

@Repository

public interface ModuleRepository extends JpaRepository <Module , Long> {
    
     @Query("select ens FROM Enseignement ens WHERE ens.module= ?1")
    List<Enseignement> findByModule(Module module);

}
