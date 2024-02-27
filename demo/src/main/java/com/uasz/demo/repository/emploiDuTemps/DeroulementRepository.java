package com.uasz.demo.repository.emploiDuTemps;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.emploiDuTemps.Deroulement;


@Repository
public interface DeroulementRepository extends JpaRepository <Deroulement ,Long>{
    

   

}
