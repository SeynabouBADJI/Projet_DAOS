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

import com.uasz.demo.modele.emploiDuTemps.Seance;
import com.uasz.demo.service.emploiDuTemps.SeanceService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploiDuTemps")
public class SeanceRestController {

    @Autowired
    private SeanceService seanceService ;
    
    @GetMapping(path = "/seance")
    public List<Seance> lister_seance(){
        return seanceService.lister_Seance();

    
    }
    @GetMapping(path = "/seance/{id}")
    public Seance rechercher_seance(@PathVariable Long id){
        return seanceService.rechercher_Seance(id);
    }


    @PostMapping(path="/seance")
    public Seance ajouter_seance(@RequestBody Seance seance){
        return seanceService.ajouter_Seance(seance);
    }

    @PutMapping(path = "/seance/{id}")
    public Seance modifier_seance (@RequestBody Seance seance , @PathVariable Long id){
        return seanceService.modifier_Seance(seance, id);

    }

    @DeleteMapping(path = "/seance/{id}")
    public void supprimer_seance(@PathVariable Long id){
        seanceService.supprimer_Seance(id);
    }
    
}

