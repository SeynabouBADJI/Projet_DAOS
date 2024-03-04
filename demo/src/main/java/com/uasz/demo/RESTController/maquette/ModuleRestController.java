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
import com.uasz.demo.modele.maquette.Module;
import com.uasz.demo.service.maquette.ModuleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")

public class ModuleRestController {
     @Autowired
    private ModuleService moduleService ;
    
    @GetMapping(path = "/module")
    public List<Module> lister_module(){
        return moduleService.lister_Module();

    
    }
    @GetMapping(path = "/module/{id}")
    public Module rechercher_module(@PathVariable Long id){
        return moduleService.rechercher_Module(id);
    }


    @PostMapping(path="/module")
    public Module ajouter_module(@RequestBody Module module){
        return moduleService.ajouter_Module(module);
    }

    @PutMapping(path = "/module/{id}")
    public Module modifier_module (@RequestBody Module module , @PathVariable Long id){
        return moduleService.modifier_Module(module, id);

    }

    @DeleteMapping(path = "/module/{id}")
    public void supprimer_module(@PathVariable Long id){
        moduleService.supprimer_Module(id);
    }
   
    
}
