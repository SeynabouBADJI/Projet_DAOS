package com.uasz.demo.service.repartition;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.repartition.Vac;
import com.uasz.demo.repository.repartition.VacRepository;



@Service
@Transactional
public class VacService {

    @Autowired
    private VacRepository vacRepository;


        //partie REST 




   public List<Vac> lister_Vacataire(){
      return vacRepository.findAll();
   }
    

   public Vac rechercher_Vacataire(Long id){
      return vacRepository.findById(id).get();
   }

   public Vac ajouter_Vacataire(Vac vac){
      return vacRepository.save(vac);
   }

   public Vac modifier_Vacataire(Vac vac, Long id){
      vac.setId(id);
      return vacRepository.save(vac);
   }


   public void supprimer_Vacataire (Long id){
    vacRepository.deleteById(id);
   }




    
}
