package com.uasz.demo.RESTController.maquette;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uasz.demo.modele.maquette.Enseignement;
import com.uasz.demo.service.maquette.EnseignementService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class EnseignementRestController {
     @Autowired
    private EnseignementService enseignementService ;
    
    @GetMapping(path = "/enseignement")
    public List<Enseignement> lister_enseignement(){
        return enseignementService.lister_Enseignement();

    
    }
    @GetMapping(path = "/enseignement/{id}")
    public Enseignement rechercher_enseignement(@PathVariable Long id){
        return enseignementService.rechercher_Enseignement(id);
    }


    @PostMapping(path="/enseignement")
    public Enseignement ajouter_enseignement(@RequestBody Enseignement enseignement){
        return enseignementService.ajouter_Enseignement(enseignement);
    }

    @PutMapping(path = "/enseignement/{id}")
    public Enseignement modifier_enseignement (@RequestBody Enseignement enseignement , @PathVariable Long id){
        return enseignementService.modifier_Enseignement(enseignement, id);

    }

    @DeleteMapping(path = "/enseignement/{id}")
    public void supprimer_enseignement(@PathVariable Long id){
        enseignementService.supprimer_Enseignement(id);
    }
   
    
}
