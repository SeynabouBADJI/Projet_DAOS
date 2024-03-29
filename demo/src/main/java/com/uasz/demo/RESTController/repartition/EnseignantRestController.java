package com.uasz.demo.RESTController.repartition;

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

import com.uasz.demo.modele.repartition.Enseignant;
import com.uasz.demo.service.repartition.EnseignantService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/repartition")
public class EnseignantRestController {
    @Autowired
    private EnseignantService enseignantService;
   
    @GetMapping(path = "/ens")
    public List<Enseignant> lister_ens(){
        return enseignantService.lister_Ens();
    }
    @GetMapping(path = "/enseignant/{id}")
    public Enseignant rechercher_ens(@PathVariable Long id){
        return enseignantService.rechercher_Ens(id);
    }


    @PostMapping(path="/enseignant")
    public Enseignant ajouter_ens(@RequestBody Enseignant ens){
        return enseignantService.ajouter_Ens(ens);
    }

    @PutMapping(path = "/enseignant/{id}")
    public Enseignant modifier_ens (@RequestBody Enseignant ens , @PathVariable Long id){
        return enseignantService.modifier_Ens(ens, id);

    }

    @DeleteMapping(path = "/enseignant/{id}")
    public void supprimer_ens(@PathVariable Long id){
        enseignantService.supprimer_Ens(id);
    }
    
}
