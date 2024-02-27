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

import com.uasz.demo.modele.repartition.Vacataire;
import com.uasz.demo.service.repartition.VacService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/repartition")

public class VacRestController {
    

    @Autowired
    private VacService vacService;

    @GetMapping(path = "/vac")
    public List<Vacataire> lister_vacataire(){
        return vacService.lister_Vacataire();

    
    }
    @GetMapping(path = "/vac/{id}")
    public Vacataire rechercher_vacataire(@PathVariable Long id){
        return vacService.rechercher_Vacataire(id);
    }


    @PostMapping(path="/vac")
    public Vacataire ajouter_vacataire(@RequestBody Vacataire vac){
        return vacService.ajouter_Vacataire(vac);
    }

    @PutMapping(path = "/vac/{id}")
    public Vacataire modifier_Vacataire (@RequestBody Vacataire vac , @PathVariable Long id){
        return vacService.modifier_Vacataire(vac, id);

    }

    @DeleteMapping(path = "/vac/{id}")
    public void supprimer_vacataire(@PathVariable Long id){
        vacService.supprimer_Vacataire(id);
    }



}
