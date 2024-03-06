package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Classe;
import com.uasz.demo.modele.maquette.Module;
import com.uasz.demo.modele.maquette.Semestre;
import com.uasz.demo.repository.maquette.SemestreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class SemestreService {
     @Autowired
    private SemestreRepository semestreRepository;

    //partie REST 




   public List<Semestre> lister_Semestre(){
      return semestreRepository.findAll();
   }
    

   public Semestre rechercher_Semestre(Long id){
      return semestreRepository.findById(id).get();
   }

   public Semestre ajouter_Semestre(Semestre semestre){
      return semestreRepository.save(semestre);
   }

   public Semestre modifier_Semestre(Semestre semestre, Long id){
      semestre.setId(id);
      return semestreRepository.save(semestre);
   }


   public void supprimer_Semestre(Long id){
      semestreRepository.deleteById(id);
   }

   public List<Module> lister_Module_Semestre(Semestre semestre ){
      return semestreRepository.findBySemestre(semestre);
   }

   public List<Classe> lister_Classe_Semestre(Semestre semestre ){
      return semestreRepository.findBySemestreClasse(semestre);
   }




    
}
