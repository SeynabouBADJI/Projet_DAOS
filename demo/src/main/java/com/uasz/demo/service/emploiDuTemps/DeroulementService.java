package com.uasz.demo.service.emploiDuTemps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.emploiDuTemps.Deroulement;
import com.uasz.demo.repository.emploiDuTemps.DeroulementRepository;

@Service
@Transactional
public class DeroulementService {
    @Autowired
    private DeroulementRepository deroulementRepository;

    //partie REST 


    public List<Deroulement> lister_Deroulement(){
        return deroulementRepository.findAll();
    }
    

    public Deroulement rechercher_Deroulement(Long id){
        return deroulementRepository.findById(id).get();
    }

    public Deroulement ajouter_Deroulement(Deroulement deroulement){
        return deroulementRepository.save(deroulement);
    }

    public Deroulement modifier_Deroulement(Deroulement deroulement, Long id){
        deroulement.setId(id);
        return deroulementRepository.save(deroulement);
    }


    public void supprimer_Deroulement(Long id){
        deroulementRepository.deleteById(id);
    }

   
    






}
