package com.uasz.demo.RESTController.emploiDuTemps;

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

import com.uasz.demo.modele.emploiDuTemps.Deroulement;
import com.uasz.demo.service.emploiDuTemps.DeroulementService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploiDuTemps")
public class DeroulementRestController {

    @Autowired
    private DeroulementService deroulementService ;
    
    @GetMapping(path = "/deroulement")
    public List<Deroulement> lister_deroulement(){
        return deroulementService.lister_Deroulement();

    
    }
    @GetMapping(path = "/deroulement/{id}")
    public Deroulement rechercher_deroulement(@PathVariable Long id){
        return deroulementService.rechercher_Deroulement(id);
    }


    @PostMapping(path="/deroulement")
    public Deroulement ajouter_deroulement(@RequestBody Deroulement deroulement){
        return deroulementService.ajouter_Deroulement(deroulement);
    }

    @PutMapping(path = "/deroulement/{id}")
    public Deroulement modifier_deroulement (@RequestBody Deroulement deroulement , @PathVariable Long id){
        return deroulementService.modifier_Deroulement(deroulement, id);

    }

    @DeleteMapping(path = "/deroulement/{id}")
    public void supprimer_deroulement(@PathVariable Long id){
        deroulementService.supprimer_Deroulement(id);
    }
    
}

