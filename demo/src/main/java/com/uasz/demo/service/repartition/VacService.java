package com.uasz.demo.service.repartition;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.repartition.Vacataire;
import com.uasz.demo.repository.repartition.VacRepository;



@Service
@Transactional
public class VacService {

    @Autowired
    private VacRepository vacRepository;


        //partie REST 




   public List<Vacataire> lister_Vacataire(){
      return vacRepository.findAll();
   }
    

   public Vacataire rechercher_Vacataire(Long id){
      return vacRepository.findById(id).get();
   }

   public Vacataire ajouter_Vacataire(Vacataire vac){
      return vacRepository.save(vac);
   }

   public Vacataire modifier_Vacataire(Vacataire vac, Long id){
      vac.setId(id);
      return vacRepository.save(vac);
   }


   public void supprimer_Vacataire (Long id){
    vacRepository.deleteById(id);
   }




    
}
