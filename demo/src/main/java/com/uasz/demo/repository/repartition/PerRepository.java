package com.uasz.demo.repository.repartition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.repartition.Per;


@Repository
public interface PerRepository extends JpaRepository<Per, Long>{
    
}
