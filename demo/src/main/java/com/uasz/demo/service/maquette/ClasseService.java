package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Classe;
import com.uasz.demo.repository.maquette.ClasseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ClasseService {
     @Autowired
    private ClasseRepository classeRepository;

    //partie REST 




   public List<Classe> lister_Classe(){
      return classeRepository.findAll();
   }
    

   public Classe rechercher_Classe(Long id){
      return classeRepository.findById(id).get();
   }

   public Classe ajouter_Classe(Classe classe){
      return classeRepository.save(classe);
   }

   public Classe modifier_Classe(Classe classe, Long id){
      classe.setId(id);
      return classeRepository.save(classe);
   }


   public void supprimer_Classe(Long id){
      classeRepository.deleteById(id);
   }


    
}
