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
import com.uasz.demo.modele.maquette.Groupe;
import com.uasz.demo.service.maquette.GroupeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class GroupeRestController {
     @Autowired
    private GroupeService groupeService ;
    
    @GetMapping(path = "/groupe")
    public List<Groupe> lister_groupe(){
        return groupeService.lister_Groupe();

    
    }
    @GetMapping(path = "/groupe/{id}")
    public Groupe rechercher_groupe(@PathVariable Long id){
        return groupeService.rechercher_Groupe(id);
    }


    @PostMapping(path="/groupe")
    public Groupe ajouter_groupe(@RequestBody Groupe groupe){
        return groupeService.ajouter_Groupe(groupe);
    }

    @PutMapping(path = "/groupe/{id}")
    public Groupe modifier_groupe (@RequestBody Groupe groupe , @PathVariable Long id){
        return groupeService.modifier_Groupe(groupe, id);

    }

    @DeleteMapping(path = "/groupe/{id}")
    public void supprimer_groupe(@PathVariable Long id){
        groupeService.supprimer_Groupe(id);
    }
   
    
}
