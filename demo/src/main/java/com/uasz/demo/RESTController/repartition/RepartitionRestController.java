package com.uasz.demo.RESTController.repartition;

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

import com.uasz.demo.modele.repartition.Repartition;
import com.uasz.demo.service.repartition.RepartitionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/repartition")


public class RepartitionRestController {
    @Autowired
    private RepartitionService repartitionService;

    @GetMapping(path = "/repartition")
    public List<Repartition> lister_repartition(){
        return repartitionService.lister_Repartition();

    
    }
    @GetMapping(path = "/repartition/{id}")
    public Repartition rechercher_repartition(@PathVariable Long id){
        return repartitionService.rechercher_Repartition(id);
    }


    @PostMapping(path="/repartition")
    public Repartition ajouter_repartition(@RequestBody Repartition repartition){
        return repartitionService.ajouter_Repartition(repartition);
    }

    @PutMapping(path = "/repartition/{id}")
    public Repartition modifier_repartition (@RequestBody Repartition repartition , @PathVariable Long id){
        return repartitionService.modifier_Repartition(repartition, id);

    }

    @DeleteMapping(path = "/repartition/{id}")
    public void supprimer_repartition(@PathVariable Long id){
        repartitionService.supprimer_Repartition(id);
    }
    
}
