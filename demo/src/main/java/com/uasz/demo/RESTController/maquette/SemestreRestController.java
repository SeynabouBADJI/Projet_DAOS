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
import com.uasz.demo.modele.maquette.Semestre;
import com.uasz.demo.service.maquette.SemestreService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class SemestreRestController {
     @Autowired
    private SemestreService semestreService ;
    
    @GetMapping(path = "/semestre")
    public List<Semestre> lister_semestre(){
        return semestreService.lister_Semestre();

    
    }
    @GetMapping(path = "/semestre/{id}")
    public Semestre rechercher_semestre(@PathVariable Long id){
        return semestreService.rechercher_Semestre(id);
    }


    @PostMapping(path="/semestre")
    public Semestre ajouter_semestre(@RequestBody Semestre semestre){
        return semestreService.ajouter_Semestre(semestre);
    }

    @PutMapping(path = "/semestre/{id}")
    public Semestre modifier_semestre (@RequestBody Semestre semestre , @PathVariable Long id){
        return semestreService.modifier_Semestre(semestre, id);

    }

    @DeleteMapping(path = "/semestre/{id}")
    public void supprimer_semestre(@PathVariable Long id){
        semestreService.supprimer_Semestre(id);
    }
   
    
}
