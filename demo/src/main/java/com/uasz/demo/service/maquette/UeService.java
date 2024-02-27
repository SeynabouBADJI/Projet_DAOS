package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.maquette.Ec;
import com.uasz.demo.modele.maquette.Module;
import com.uasz.demo.modele.maquette.Ue;
import com.uasz.demo.repository.maquette.ueREpository;

@Service
@Transactional
public class UeService {
    @Autowired
    private ueREpository ueRepository;
    public void ajouterUe(Ue ue){
        ueRepository.save(ue);
    }

    public List<Ue> listerToutUe(){
        return ueRepository.findAll();
     }
     public Ue rechercherUe(Long id){
        return ueRepository.getById(id);
     }
     public void modifierUe (Ue ue){
         Ue ueModifier=rechercherUe(ue.getId());         
         ueModifier.setLibelle(ue.getLibelle());
         ueModifier.setCode(ue.getCode());
         ueModifier.setDescription(ue.getDescription());
         ueModifier.setEcs(ue.getEcs());
         ueModifier.setUtilisateur(ue.getUtilisateur());
         ueModifier.setCredit(ue.getCredit());
         ueModifier.setCoefficient(ue.getCoefficient());
         ueModifier.setDateCreation(ue.getDateCreation());
         ueRepository.save(ueModifier);

     }
     public void supprimerUe(Ue ue){
        ueRepository.delete(ue);

     }
     public List<Ec> afficherleEc(Ue ue){
        return ueRepository.findByUe(ue);
     }

     public List<Module> afficherlaModule(Ue ue){
      return ueRepository.findByUeModule(ue);
   }






//partie REST 




   public List<Ue> lister_Ue(){
      return ueRepository.findAll();
   }
    

   public Ue rechercher_Ue(Long id){
      return ueRepository.findById(id).get();
   }

   public Ue ajouter_Ue(Ue ue){
      return ueRepository.save(ue);
   }

   public Ue modifier_Ue(Ue ue, Long id){
      ue.setId(id);
      return ueRepository.save(ue);
   }


   public void supprimer_Ue(Long id){
      ueRepository.deleteById(id);
   }

   public List<Ec> lister_EC_UE(Ue ue ){
      return ueRepository.findByUe(ue);
   }

   






}