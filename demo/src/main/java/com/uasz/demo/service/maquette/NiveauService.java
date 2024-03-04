package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Niveau;
import com.uasz.demo.repository.maquette.NiveauRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class NiveauService {
     @Autowired
    private NiveauRepository niveauRepository;

    //partie REST 




   public List<Niveau> lister_Niveau(){
      return niveauRepository.findAll();
   }
    

   public Niveau rechercher_Niveau(Long id){
      return niveauRepository.findById(id).get();
   }

   public Niveau ajouter_Niveau(Niveau niveau){
      return niveauRepository.save(niveau);
   }

   public Niveau modifier_Niveau(Niveau niveau, Long id){
      niveau.setId(id);
      return niveauRepository.save(niveau);
   }


   public void supprimer_Niveau(Long id){
      niveauRepository.deleteById(id);
   }


    
}
