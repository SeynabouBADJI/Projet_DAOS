package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.uasz.demo.modele.maquette.Enseignement;
import com.uasz.demo.modele.maquette.Groupe;
import com.uasz.demo.repository.maquette.GroupeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class GroupeService {
     @Autowired
    private GroupeRepository groupeRepository;

    //partie REST 




   public List<Groupe> lister_Groupe(){
      return groupeRepository.findAll();
   }
    

   public Groupe rechercher_Groupe(Long id){
      return groupeRepository.findById(id).get();
   }

   public Groupe ajouter_Groupe(Groupe groupe){
      return groupeRepository.save(groupe);
   }

   public Groupe modifier_Groupe(Groupe groupe, Long id){
      groupe.setId(id);
      return groupeRepository.save(groupe);
   }


   public void supprimer_Groupe(Long id){
      groupeRepository.deleteById(id);
   }


   public List<Enseignement> lister_Enseignement_Groupe(Groupe groupe){
      return groupeRepository.findByGroupeEnseignement(groupe);
   }

    
}
