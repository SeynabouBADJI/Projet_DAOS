package com.uasz.demo.service.repartition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.repartition.Repartition;
import com.uasz.demo.repository.repartition.RepartitionRepository;

@Service
@Transactional

public class RepartitionService {
     @Autowired
    private RepartitionRepository repartitionRepository ;

    //partie REST 




   public List<Repartition> lister_Repartition(){
      return repartitionRepository.findAll();
   }
    

   public Repartition rechercher_Repartition(Long id){
      return repartitionRepository.findById(id).get();
   }

   public Repartition ajouter_Repartition(Repartition repartition){
      return repartitionRepository.save(repartition);
   }

   public Repartition modifier_Repartition(Repartition repartition, Long id){
      repartition.setId(id);
      return repartitionRepository.save(repartition);
   }


   public void supprimer_Repartition(Long id){
    repartitionRepository.deleteById(id);
   }



    
}
