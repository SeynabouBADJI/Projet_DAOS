package com.uasz.demo.service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.demo.modele.maquette.Module;
import com.uasz.demo.repository.maquette.ModuleRepository;


@Transactional
@Service

public class ModuleService {

@Autowired
private ModuleRepository moduleRepository;

public void ajouterModule(Module module){
    moduleRepository.save(module);
}

public List<Module> listerToutModules(){
    return moduleRepository.findAll();
}
public Module rechercherModule(Long id){
    return moduleRepository.getById(id);
}
public void modifierModule (Module module){
     Module moduleModifier=moduleRepository.getById(module.getId());        
     moduleModifier.setLibelle(module.getLibelle());
     moduleModifier.setCours(module.getCours());
     moduleModifier.setDuree(module.getDuree());
     moduleModifier.setObjectifs(module.getObjectifs());
     moduleModifier.setDescription(module.getDescription());
     moduleModifier.setUe(module.getUe()); 
     moduleRepository.save(moduleModifier);

}
public void supprimerModule(Module module){
    moduleRepository.delete(module);

}

}
