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
import com.uasz.demo.modele.maquette.Niveau;
import com.uasz.demo.service.maquette.NiveauService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class NiveauRestController {
     @Autowired
    private NiveauService niveauService ;
    
    @GetMapping(path = "/niveau")
    public List<Niveau> lister_niveau(){
        return niveauService.lister_Niveau();

    
    }
    @GetMapping(path = "/niveau/{id}")
    public Niveau rechercher_niveau(@PathVariable Long id){
        return niveauService.rechercher_Niveau(id);
    }


    @PostMapping(path="/niveau")
    public Niveau ajouter_niveau(@RequestBody Niveau niveau){
        return niveauService.ajouter_Niveau(niveau);
    }

    @PutMapping(path = "/niveau/{id}")
    public Niveau modifier_niveau (@RequestBody Niveau niveau , @PathVariable Long id){
        return niveauService.modifier_Niveau(niveau, id);

    }

    @DeleteMapping(path = "/niveau/{id}")
    public void supprimer_niveau(@PathVariable Long id){
        niveauService.supprimer_Niveau(id);
    }

    
   
    
}
