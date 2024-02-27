package com.uasz.demo.service.emploiDuTemps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.emploiDuTemps.Emploi;
import com.uasz.demo.repository.emploiDuTemps.EmploiRepository;

@Service
@Transactional
public class EmploiService {
    @Autowired
    private EmploiRepository emploiRepository;

    //partie REST 


    public List<Emploi> lister_Emploi(){
        return emploiRepository.findAll();
    }
    

    public Emploi rechercher_Emploi(Long id){
        return emploiRepository.findById(id).get();
    }

    public Emploi ajouter_Emploi(Emploi emploi){
        return emploiRepository.save(emploi);
    }

    public Emploi modifier_Emploi(Emploi emploi, Long id){
        emploi.setId(id);
        return emploiRepository.save(emploi);
    }


    public void supprimer_Emploi(Long id){
        emploiRepository.deleteById(id);
    }

   
    






}
