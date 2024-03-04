package com.uasz.demo.repository.maquette;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Classe;
import com.uasz.demo.modele.maquette.Semestre;

@Repository
public interface SemestreRepository extends JpaRepository <Semestre ,Long>{
    @Query("select mod FROM Module mod WHERE mod.semestre = ?1")
    List<Module> findBySemestre(Semestre semestre);
    @Query("select cla FROM Classe cla WHERE cla.semestre = ?1")
    List<Classe> findBySemestreClasse(Semestre semestre);

  

}