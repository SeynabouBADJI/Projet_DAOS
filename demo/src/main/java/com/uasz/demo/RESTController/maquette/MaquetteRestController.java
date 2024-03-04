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
import com.uasz.demo.modele.maquette.Maquette;
import com.uasz.demo.service.maquette.MaquetteService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class MaquetteRestController {
     @Autowired
    private MaquetteService maquetteService ;
    
    @GetMapping(path = "/maquette")
    public List<Maquette> lister_maquette(){
        return maquetteService.lister_Maquette();

    
    }
    @GetMapping(path = "/maquette/{id}")
    public Maquette rechercher_maquette(@PathVariable Long id){
        return maquetteService.rechercher_Maquette(id);
    }


    @PostMapping(path="/maquette")
    public Maquette ajouter_maquette(@RequestBody Maquette maquette){
        return maquetteService.ajouter_Maquette(maquette);
    }

    @PutMapping(path = "/maquette/{id}")
    public Maquette modifier_maquette (@RequestBody Maquette maquette , @PathVariable Long id){
        return maquetteService.modifier_Maquette(maquette, id);

    }

    @DeleteMapping(path = "/maquette/{id}")
    public void supprimer_maquette(@PathVariable Long id){
        maquetteService.supprimer_Maquette(id);
    }
   
    
}
