package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.demo.modele.maquette.Enseignement;
import com.uasz.demo.modele.maquette.Module;
import com.uasz.demo.repository.maquette.ModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ModuleService {
     @Autowired
    private ModuleRepository moduleRepository;

    //partie REST 




   public List<Module> lister_Module(){
      return moduleRepository.findAll();
   }
    

   public Module rechercher_Module(Long id){
      return moduleRepository.findById(id).get();
   }

   public Module ajouter_Module(Module module){
      return moduleRepository.save(module);
   }

   public Module modifier_Module(Module module, Long id){
      module.setId(id);
      return moduleRepository.save(module);
   }


   public void supprimer_Module(Long id){
      moduleRepository.deleteById(id);
   }


   public List<Enseignement> lister_Enseignement_Module(Module module ){
      return moduleRepository.findByModule(module);
   }


    
}
