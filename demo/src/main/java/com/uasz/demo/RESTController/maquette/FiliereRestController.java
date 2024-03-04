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
import com.uasz.demo.modele.maquette.Filiere;
import com.uasz.demo.service.maquette.FiliereService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class FiliereRestController {
     @Autowired
    private FiliereService filiereService ;
    
    @GetMapping(path = "/filiere")
    public List<Filiere> lister_filiere(){
        return filiereService.lister_Filiere();

    
    }
    @GetMapping(path = "/filiere/{id}")
    public Filiere rechercher_filiere(@PathVariable Long id){
        return filiereService.rechercher_Filiere(id);
    }


    @PostMapping(path="/filiere")
    public Filiere ajouter_filiere(@RequestBody Filiere filiere){
        return filiereService.ajouter_Filiere(filiere);
    }

    @PutMapping(path = "/filiere/{id}")
    public Filiere modifier_filiere (@RequestBody Filiere filiere , @PathVariable Long id){
        return filiereService.modifier_Filiere(filiere, id);

    }

    @DeleteMapping(path = "/filiere/{id}")
    public void supprimer_filiere(@PathVariable Long id){
        filiereService.supprimer_Filiere(id);
    }
   
    
}
