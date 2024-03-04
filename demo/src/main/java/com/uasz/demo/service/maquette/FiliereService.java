package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Filiere;
import com.uasz.demo.repository.maquette.FiliereRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class FiliereService {
     @Autowired
    private FiliereRepository filiereRepository;

    //partie REST 




   public List<Filiere> lister_Filiere(){
      return filiereRepository.findAll();
   }
    

   public Filiere rechercher_Filiere(Long id){
      return filiereRepository.findById(id).get();
   }

   public Filiere ajouter_Filiere(Filiere filiere){
      return filiereRepository.save(filiere);
   }

   public Filiere modifier_Filiere(Filiere filiere, Long id){
      filiere.setId(id);
      return filiereRepository.save(filiere);
   }


   public void supprimer_Filiere(Long id){
      filiereRepository.deleteById(id);
   }


    
}
