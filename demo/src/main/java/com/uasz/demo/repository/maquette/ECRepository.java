package com.uasz.demo.repository.maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Ec;
@Repository
public interface ECRepository extends JpaRepository <Ec , Long>{

    @Query("select m FROM Module m WHERE m.ec = ?1")
    List<Module> findByEcModule(Ec ec);
    

    
}
