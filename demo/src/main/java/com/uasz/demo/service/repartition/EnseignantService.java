package com.uasz.demo.service.repartition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.repartition.Enseignant;
import com.uasz.demo.repository.repartition.EnseignantRepository;

@Service
@Transactional

public class EnseignantService {
     @Autowired
    private EnseignantRepository enseignantRepository ;

    //partie REST 




   public List<Enseignant> lister_Ens(){
      return enseignantRepository.findAll();
   }
    

   public Enseignant rechercher_Ens(Long id){
      return enseignantRepository.findById(id).get();
   }

   public Enseignant ajouter_Ens(Enseignant ens){
      return enseignantRepository.save(ens);
   }

   public Enseignant modifier_Ens(Enseignant ens, Long id){
      ens.setId(id);
      return enseignantRepository.save(ens);
   }


   public void supprimer_Ens (Long id){
    enseignantRepository.deleteById(id);
   }



    
}
