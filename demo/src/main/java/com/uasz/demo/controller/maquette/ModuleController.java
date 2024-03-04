/* package com.uasz.demo.controller.maquette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.demo.modele.maquette.Module;
import com.uasz.demo.service.maquette.ModuleService;
import com.uasz.demo.service.maquette.UeService;

import lombok.AllArgsConstructor;


@Controller
    
@AllArgsConstructor

public class ModuleController {

    @Autowired
    private ModuleService moduleService ;
    private UeService ueService;

    @RequestMapping(value ="/ajouter_module_ue", method = RequestMethod.POST)
    public String ajouter_module_ue(Model model, Module module ){
        moduleService.ajouterModule(module);
        return "redirect:/details_module?id="+module.getUe().getId();

    }

    @RequestMapping(value = "/modifier_module_ue",method = RequestMethod.POST)
    public String modifier_module_ue(Model model , Module module ){
        moduleService.modifierModule(module);
        Module module2=moduleService.rechercherModule(module.getId());
        return "redirect:/details_module?id="+ module2.getUe().getId();
    }
    
    @RequestMapping(value ="/supprimer_module_ue",method = RequestMethod.POST)
    public String supprimer_module_ue(Model model , Module module ){
        Long id=module.getUe().getId();
        moduleService.supprimerModule(module);
        return "redirect:/details_module?id="+id;
    }
    

    
}
 */