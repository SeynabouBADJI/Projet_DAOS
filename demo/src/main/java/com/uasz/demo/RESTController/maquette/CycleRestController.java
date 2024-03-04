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
import com.uasz.demo.modele.maquette.Cycle;
import com.uasz.demo.service.maquette.CycleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class CycleRestController {
     @Autowired
    private CycleService cycleService ;
    
    @GetMapping(path = "/cycle")
    public List<Cycle> lister_cycle(){
        return cycleService.lister_Cycle();

    
    }
    @GetMapping(path = "/cycle/{id}")
    public Cycle rechercher_cycle(@PathVariable Long id){
        return cycleService.rechercher_Cycle(id);
    }


    @PostMapping(path="/cycle")
    public Cycle ajouter_cycle(@RequestBody Cycle cycle){
        return cycleService.ajouter_Cycle(cycle);
    }

    @PutMapping(path = "/cycle/{id}")
    public Cycle modifier_cycle (@RequestBody Cycle cycle , @PathVariable Long id){
        return cycleService.modifier_Cycle(cycle, id);

    }

    @DeleteMapping(path = "/cycle/{id}")
    public void supprimer_cycle(@PathVariable Long id){
        cycleService.supprimer_Cycle(id);
    }
   
    
}
