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

import com.uasz.demo.modele.repartition.Per;
import com.uasz.demo.service.repartition.PerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/repartition")


public class PerRestController {
    @Autowired
    private PerService perService;

    @GetMapping(path = "/per")
    public List<Per> lister_per(){
        return perService.lister_Per();

    
    }
    @GetMapping(path = "/per/{id}")
    public Per rechercher_per(@PathVariable Long id){
        return perService.rechercher_Per(id);
    }


    @PostMapping(path="/per")
    public Per ajouter_per(@RequestBody Per per){
        return perService.ajouter_Per(per);
    }

    @PutMapping(path = "/per/{id}")
    public Per modifier_per (@RequestBody Per per , @PathVariable Long id){
        return perService.modifier_Per(per, id);

    }

    @DeleteMapping(path = "/per/{id}")
    public void supprimer_per(@PathVariable Long id){
        perService.supprimer_Per(id);
    }



    
}
