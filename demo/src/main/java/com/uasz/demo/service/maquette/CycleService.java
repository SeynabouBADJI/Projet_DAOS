package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Cycle;
import com.uasz.demo.repository.maquette.CycleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class CycleService {
     @Autowired
    private CycleRepository cycleRepository;

    //partie REST 




   public List<Cycle> lister_Cycle(){
      return cycleRepository.findAll();
   }
    

   public Cycle rechercher_Cycle(Long id){
      return cycleRepository.findById(id).get();
   }

   public Cycle ajouter_Cycle(Cycle cycle){
      return cycleRepository.save(cycle);
   }

   public Cycle modifier_Cycle(Cycle cycle, Long id){
      cycle.setId(id);
      return cycleRepository.save(cycle);
   }


   public void supprimer_Cycle(Long id){
      cycleRepository.deleteById(id);
   }


    
}
