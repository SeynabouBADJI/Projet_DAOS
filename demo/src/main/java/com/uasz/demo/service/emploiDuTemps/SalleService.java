package com.uasz.demo.service.emploiDuTemps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.emploiDuTemps.Salle;
import com.uasz.demo.repository.emploiDuTemps.SalleRepository;

@Service
@Transactional
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    //partie REST 


    public List<Salle> lister_Salle(){
        return salleRepository.findAll();
    }
    

    public Salle rechercher_Salle(Long id){
        return salleRepository.findById(id).get();
    }

    public Salle ajouter_Salle(Salle salle){
        return salleRepository.save(salle);
    }

    public Salle modifier_Salle(Salle salle, Long id){
        salle.setId(id);
        return salleRepository.save(salle);
    }


    public void supprimer_Salle(Long id){
        salleRepository.deleteById(id);
    }

   
    






}
