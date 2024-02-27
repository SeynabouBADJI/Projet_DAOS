package com.uasz.demo.controller.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.demo.modele.maquette.Ec;
import com.uasz.demo.modele.maquette.Module;
import com.uasz.demo.modele.maquette.Ue;
import com.uasz.demo.service.maquette.UeService;

import lombok.AllArgsConstructor;

import org.springframework.ui.Model;

@Controller
@AllArgsConstructor
public class UeController {

    @Autowired
    private UeService ueService ;
    @RequestMapping(value = "/ue", method = RequestMethod.GET)
    public String Lister_ue(Model model){
        List<Ue> ueList=ueService.listerToutUe();
        model.addAttribute("listeDesUe",ueList);
        return "ue";

    }
    @RequestMapping(value = "/ajouter_ue", method = RequestMethod.POST)
    public String ajouter_ue(Model model,Ue ue){
        ueService.ajouterUe(ue);
        return "redirect:/ue";

    }

    @RequestMapping(value = "/modifier_ue", method = RequestMethod.POST)
    public String modifier_ue(Model model,Ue ue){
        ueService.modifierUe(ue);
        return "redirect:/ue";

    }

    @RequestMapping(value = "/supprimer_ue", method = RequestMethod.POST)
    public String supprimer_ue(Model model,Ue ue){
        ueService.supprimerUe(ue);
        return "redirect:/ue";

    }
    @RequestMapping(value = "/details_ue", method = RequestMethod.GET)
    public String details_ue(Model model, @RequestParam("id") Long id) {
        Ue ue=ueService.rechercherUe(id);
        List<Ec> ecList=ueService.afficherleEc(ue);
        model.addAttribute("ue",ue);
        model.addAttribute("listeDesEC",ecList);
        return "ue_details";

    }
    @RequestMapping(value = "/details_module", method = RequestMethod.GET)
    public String details_module(Model model, @RequestParam("id") Long id) {
        Ue ue=ueService.rechercherUe(id);
        List<Module> moduleList=ueService.afficherlaModule(ue);
        model.addAttribute("ue",ue);
        model.addAttribute("listeDesModules",moduleList);
        return "module_details";

    }

    



    
}







