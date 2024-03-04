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
import com.uasz.demo.modele.maquette.Formation;
import com.uasz.demo.service.maquette.FormationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class FormationRestController {
     @Autowired
    private FormationService formationService ;
    
    @GetMapping(path = "/formation")
    public List<Formation> lister_formation(){
        return formationService.lister_Formation();

    
    }
    @GetMapping(path = "/formation/{id}")
    public Formation rechercher_formation(@PathVariable Long id){
        return formationService.rechercher_Formation(id);
    }


    @PostMapping(path="/formation")
    public Formation ajouter_formation(@RequestBody Formation formation){
        return formationService.ajouter_Formation(formation);
    }

    @PutMapping(path = "/formation/{id}")
    public Formation modifier_formation (@RequestBody Formation formation , @PathVariable Long id){
        return formationService.modifier_Formation(formation, id);

    }

    @DeleteMapping(path = "/formation/{id}")
    public void supprimer_formation(@PathVariable Long id){
        formationService.supprimer_Formation(id);
    }
   
    
}
