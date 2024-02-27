package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.maquette.Ec;
import com.uasz.demo.modele.maquette.Ue;
import com.uasz.demo.repository.maquette.ECRepository;

@Service
@Transactional

public class EcService {

    @Autowired
    private ECRepository ecRepository;
    public void ajouterEC(Ec ec){
        ecRepository.save(ec);
    }

    public List<Ec> listerToutEc(){
        return ecRepository.findAll();
     }
     public Ec rechercherEc(Long id){
        return ecRepository.getById(id);
     }
     public void modifierEC (Ec ec){
         Ec ecModifier=ecRepository.getById(ec.getId());
         ecModifier.setCode(ec.getCode());         
         ecModifier.setLibelle(ec.getLibelle());
         ecModifier.setCm(ec.getCm());
         ecModifier.setTd(ec.getTd());
         ecModifier.setTp(ec.getTp());
         ecModifier.setTpe(ec.getTpe());
         ecModifier.setCoefficient(ec.getCoefficient());
         ecModifier.setDescription(ec.getDescription());
         ecModifier.setUe(ec.getUe()); 
         ecRepository.save(ecModifier);

     }
     public void supprimerEc(Ec ec){
        ecRepository.delete(ec);

     }
    

     //partie REST 




   public List<Ec> lister_Ec(){
      return ecRepository.findAll();
   }
    

   public Ec rechercher_Ec(Long id){
      return ecRepository.findById(id).get();
   }

   public Ec ajouter_Ec(Ec ec){
      return ecRepository.save(ec);
   }

   public Ec modifier_Ec(Ec ec, Long id){
      ec.setId(id);
      return ecRepository.save(ec);
   }


   public void supprimer_Ec(Long id){
    ecRepository.deleteById(id);
   }


}
