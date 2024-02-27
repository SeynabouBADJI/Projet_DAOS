package com.uasz.demo.service.repartition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.repartition.Per;
import com.uasz.demo.repository.repartition.PerRepository;

@Service
@Transactional

public class PerService {
    @Autowired
    private PerRepository perRepository;

      //partie REST 




   public List<Per> lister_Per(){
      return perRepository.findAll();
   }
    

   public Per rechercher_Per(Long id){
      return perRepository.findById(id).get();
   }

   public Per ajouter_Per(Per per){
      return perRepository.save(per);
   }

   public Per modifier_Per(Per per, Long id){
      per.setId(id);
      return perRepository.save(per);
   }


   public void supprimer_Per (Long id){
    perRepository.deleteById(id);
   }


    
}
