package com.uasz.demo.repository.maquette;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Groupe;
import com.uasz.demo.modele.maquette.Classe;
import com.uasz.demo.modele.maquette.Enseignement;


@Repository
public interface ClasseRepository extends JpaRepository <Classe ,Long>{
    @Query("select groupe FROM Groupe groupe WHERE groupe.classe = ?1")
    List<Groupe> findByClasse(Classe classe);

    @Query("select enseignement FROM Enseignement enseignement WHERE enseignement.classe = ?1")
    List<Enseignement> findByClasseEnseignement(Classe classe);
    


}