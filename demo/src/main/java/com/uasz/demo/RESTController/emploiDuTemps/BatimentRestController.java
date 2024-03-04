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

import com.uasz.demo.modele.emploiDuTemps.Batiment;
import com.uasz.demo.service.emploiDuTemps.BatimentService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploiDuTemps")
public class BatimentRestController {

    @Autowired
    private BatimentService batimentService ;
    
    @GetMapping(path = "/batiment")
    public List<Batiment> lister_batiment(){
        return batimentService.lister_Batiment();

    
    }
    @GetMapping(path = "/batiment/{id}")
    public Batiment rechercher_batiment(@PathVariable Long id){
        return batimentService.rechercher_Batiment(id);
    }


    @PostMapping(path="/batiment")
    public Batiment ajouter_batiment(@RequestBody Batiment batiment){
        return batimentService.ajouter_Batiment(batiment);
    }

    @PutMapping(path = "/batiment/{id}")
    public Batiment modifier_batiment (@RequestBody Batiment batiment , @PathVariable Long id){
        return batimentService.modifier_Batiment(batiment, id);

    }

    @DeleteMapping(path = "/batiment/{id}")
    public void supprimer_batiment(@PathVariable Long id){
        batimentService.supprimer_Batiment(id);
    }
    
}

