package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Classe;
import com.uasz.demo.modele.maquette.Formation;
import com.uasz.demo.repository.maquette.FormationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class FormationService {
     @Autowired
    private FormationRepository formationRepository;

    //partie REST 




   public List<Formation> lister_Formation(){
      return formationRepository.findAll();
   }
    

   public Formation rechercher_Formation(Long id){
      return formationRepository.findById(id).get();
   }

   public Formation ajouter_Formation(Formation formation){
      return formationRepository.save(formation);
   }

   public Formation modifier_Formation(Formation formation, Long id){
      formation.setId(id);
      return formationRepository.save(formation);
   }


   public void supprimer_Formation(Long id){
      formationRepository.deleteById(id);
   }
   
   
   public List<Classe> lister_Classe_Formation(Formation formation ){
         return formationRepository.findByFormation(formation);
      }

   

    
}
