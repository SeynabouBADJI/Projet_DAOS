package com.uasz.demo.repository.maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.maquette.Ec;
import com.uasz.demo.modele.maquette.Ue;
import com.uasz.demo.modele.maquette.Module;

@Repository
public interface ueREpository extends JpaRepository <Ue ,Long>{
    @Query("select e FROM Ec e WHERE e.ue = ?1")
    List<Ec> findByUe(Ue ue);

    @Query("select m FROM Module m WHERE m.ue = ?1")
    List<Module> findByUeModule(Ue ue);
    


}