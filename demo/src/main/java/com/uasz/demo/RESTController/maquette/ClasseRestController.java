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
import com.uasz.demo.modele.maquette.Classe;
import com.uasz.demo.service.maquette.ClasseService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class ClasseRestController {
     @Autowired
    private ClasseService classeService ;
    
    @GetMapping(path = "/classe")
    public List<Classe> lister_classe(){
        return classeService.lister_Classe();

    
    }
    @GetMapping(path = "/classe/{id}")
    public Classe rechercher_classe(@PathVariable Long id){
        return classeService.rechercher_Classe(id);
    }


    @PostMapping(path="/classe")
    public Classe ajouter_classe(@RequestBody Classe classe){
        return classeService.ajouter_Classe(classe);
    }

    @PutMapping(path = "/classe/{id}")
    public Classe modifier_classe (@RequestBody Classe classe , @PathVariable Long id){
        return classeService.modifier_Classe(classe, id);

    }

    @DeleteMapping(path = "/classe/{id}")
    public void supprimer_classe(@PathVariable Long id){
        classeService.supprimer_Classe(id);
    }
   
    
}
