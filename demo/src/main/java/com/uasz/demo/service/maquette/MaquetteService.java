package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Maquette;
import com.uasz.demo.repository.maquette.MaquetteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class MaquetteService {
     @Autowired
    private MaquetteRepository maquetteRepository;

    //partie REST 




   public List<Maquette> lister_Maquette(){
      return maquetteRepository.findAll();
   }
    

   public Maquette rechercher_Maquette(Long id){
      return maquetteRepository.findById(id).get();
   }

   public Maquette ajouter_Maquette(Maquette maquette){
      return maquetteRepository.save(maquette);
   }

   public Maquette modifier_Maquette(Maquette maquette, Long id){
      maquette.setId(id);
      return maquetteRepository.save(maquette);
   }


   public void supprimer_Maquette(Long id){
      maquetteRepository.deleteById(id);
   }


    
}
