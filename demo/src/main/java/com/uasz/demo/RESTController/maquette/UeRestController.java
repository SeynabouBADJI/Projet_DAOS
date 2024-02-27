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
import com.uasz.demo.modele.maquette.Ue;
import com.uasz.demo.service.maquette.UeService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")
public class UeRestController {

    @Autowired
    private UeService ueService ;
    
    @GetMapping(path = "/ue")
    public List<Ue> lister_ue(){
        return ueService.lister_Ue();

    
    }
    @GetMapping(path = "/ue/{id}")
    public Ue rechercher_ue(@PathVariable Long id){
        return ueService.rechercher_Ue(id);
    }


    @PostMapping(path="/ue")
    public Ue ajouter_ue(@RequestBody Ue ue){
        return ueService.ajouter_Ue(ue);
    }

    @PutMapping(path = "/ue/{id}")
    public Ue modifier_ue (@RequestBody Ue ue , @PathVariable Long id){
        return ueService.modifier_Ue(ue, id);

    }

    @DeleteMapping(path = "/ue/{id}")
    public void supprimer_ue(@PathVariable Long id){
        ueService.supprimer_Ue(id);
    }
    
}







