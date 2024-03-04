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

import com.uasz.demo.modele.emploiDuTemps.Emploi;
import com.uasz.demo.service.emploiDuTemps.EmploiService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploiDuTemps")
public class EmploiRestController {

    @Autowired
    private EmploiService emploiService ;
    
    @GetMapping(path = "/emploi")
    public List<Emploi> lister_emploi(){
        return emploiService.lister_Emploi();

    
    }
    @GetMapping(path = "/emploi/{id}")
    public Emploi rechercher_emploi(@PathVariable Long id){
        return emploiService.rechercher_Emploi(id);
    }


    @PostMapping(path="/emploi")
    public Emploi ajouter_emploi(@RequestBody Emploi emploi){
        return emploiService.ajouter_Emploi(emploi);
    }

    @PutMapping(path = "/emploi/{id}")
    public Emploi modifier_emploi (@RequestBody Emploi emploi , @PathVariable Long id){
        return emploiService.modifier_Emploi(emploi, id);

    }

    @DeleteMapping(path = "/emploi/{id}")
    public void supprimer_emploi(@PathVariable Long id){
        emploiService.supprimer_Emploi(id);
    }
    
}

