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

import com.uasz.demo.modele.maquette.Ec;
import com.uasz.demo.service.maquette.EcService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class EcRestController {
    @Autowired

    private EcService ecService;

    @GetMapping(path = "/ec")
    public List<Ec> lister_ec(){
        return ecService.lister_Ec();

    
    }
    
    @GetMapping(path = "/ec/{id}")
    public Ec rechercher_ec(@PathVariable Long id){
        return ecService.rechercher_Ec(id);
    }


    @PostMapping(path="/ec")
    public Ec ajouter_ec(@RequestBody Ec ec){
        return  ecService.ajouter_Ec(ec);
    }

    @PutMapping(path = "/ec/{id}")
    public Ec modifier_ec (@RequestBody Ec ec , @PathVariable Long id){
        return  ecService.modifier_Ec(ec, id);

    }

    @DeleteMapping(path = "/ec/{id}")
    public void supprimer_ec(@PathVariable Long id){
        ecService.supprimer_Ec(id);
    }

    
}
