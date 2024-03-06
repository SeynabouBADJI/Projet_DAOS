package com.uasz.demo.service.emploiDuTemps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.emploiDuTemps.Batiment;
import com.uasz.demo.modele.emploiDuTemps.Salle;
import com.uasz.demo.repository.emploiDuTemps.BatimentRepository;

@Service
@Transactional
public class BatimentService {
    @Autowired
    private BatimentRepository batimentRepository;

    //partie REST 


    public List<Batiment> lister_Batiment(){
        return batimentRepository.findAll();
    }
    

    public Batiment rechercher_Batiment(Long id){
        return batimentRepository.findById(id).get();
    }

    public Batiment ajouter_Batiment(Batiment batiment){
        return batimentRepository.save(batiment);
    }

    public Batiment modifier_Batiment(Batiment batiment, Long id){
        batiment.setId(id);
        return batimentRepository.save(batiment);
    }


    public void supprimer_Batiment(Long id){
        batimentRepository.deleteById(id);

    }

     public List<Salle> lister_Salle_Batiment(Batiment batiment){
      return batimentRepository.findByBatiment(batiment);
   }
   
    






}
