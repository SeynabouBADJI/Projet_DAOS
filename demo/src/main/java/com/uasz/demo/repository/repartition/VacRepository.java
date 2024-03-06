package com.uasz.demo.repository.repartition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.demo.modele.repartition.Vac;
@Repository

public interface VacRepository extends JpaRepository<Vac , Long> {
    
}
