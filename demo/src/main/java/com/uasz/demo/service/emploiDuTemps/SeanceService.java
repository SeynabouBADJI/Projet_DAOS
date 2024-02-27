package com.uasz.demo.service.emploiDuTemps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.emploiDuTemps.Seance;
import com.uasz.demo.repository.emploiDuTemps.SeanceRepository;

@Service
@Transactional
public class SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;

    //partie REST 


    public List<Seance> lister_Seance(){
        return seanceRepository.findAll();
    }
    

    public Seance rechercher_Seance(Long id){
        return seanceRepository.findById(id).get();
    }

    public Seance ajouter_Seance(Seance seance){
        return seanceRepository.save(seance);
    }

    public Seance modifier_Seance(Seance seance, Long id){
        seance.setId(id);
        return seanceRepository.save(seance);
    }


    public void supprimer_Seance(Long id){
        seanceRepository.deleteById(id);
    }

  

}
