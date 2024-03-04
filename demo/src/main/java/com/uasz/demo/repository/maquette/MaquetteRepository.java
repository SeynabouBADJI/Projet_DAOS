package com.uasz.demo.repository.maquette;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Module;
import com.uasz.demo.modele.maquette.Maquette;

@Repository
public interface MaquetteRepository extends JpaRepository <Maquette ,Long>{
    @Query("select mod FROM Module mod WHERE mod.maquette = ?1")
    List<Module> findByMaquette(Maquette maquette);

  

}