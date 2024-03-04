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

import com.uasz.demo.modele.emploiDuTemps.Salle;
import com.uasz.demo.service.emploiDuTemps.SalleService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploiDuTemps")
public class SalleRestController {

    @Autowired
    private SalleService salleService ;
    
    @GetMapping(path = "/salle")
    public List<Salle> lister_salle(){
        return salleService.lister_Salle();

    
    }
    @GetMapping(path = "/salle/{id}")
    public Salle rechercher_salle(@PathVariable Long id){
        return salleService.rechercher_Salle(id);
    }


    @PostMapping(path="/salle")
    public Salle ajouter_salle(@RequestBody Salle salle){
        return salleService.ajouter_Salle(salle);
    }

    @PutMapping(path = "/salle/{id}")
    public Salle modifier_salle (@RequestBody Salle salle , @PathVariable Long id){
        return salleService.modifier_Salle(salle, id);

    }

    @DeleteMapping(path = "/salle/{id}")
    public void supprimer_salle(@PathVariable Long id){
        salleService.supprimer_Salle(id);
    }
    
}

