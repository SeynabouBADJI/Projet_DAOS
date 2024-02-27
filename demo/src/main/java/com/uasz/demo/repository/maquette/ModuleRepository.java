package com.uasz.demo.repository.maquette;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Module;

@Repository

public interface ModuleRepository extends JpaRepository <Module , Long> {
    
}
