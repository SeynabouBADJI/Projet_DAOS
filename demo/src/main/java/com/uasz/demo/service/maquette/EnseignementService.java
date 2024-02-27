package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Enseignement;
import com.uasz.demo.repository.maquette.EnseignementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class EnseignementService {
     @Autowired
    private EnseignementRepository enseignementRepository;

    //partie REST 




   public List<Enseignement> lister_Enseignement(){
      return enseignementRepository.findAll();
   }
    

   public Enseignement rechercher_Enseignement(Long id){
      return enseignementRepository.findById(id).get();
   }

   public Enseignement ajouter_Enseignement(Enseignement enseignement){
      return enseignementRepository.save(enseignement);
   }

   public Enseignement modifier_Enseignement(Enseignement enseignement, Long id){
      enseignement.setId(id);
      return enseignementRepository.save(enseignement);
   }


   public void supprimer_Enseignement(Long id){
      enseignementRepository.deleteById(id);
   }


    
}
