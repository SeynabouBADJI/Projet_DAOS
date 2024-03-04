/* package com.uasz.demo.controller.maquette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.demo.modele.maquette.Ec;
import com.uasz.demo.modele.maquette.Ue;
import com.uasz.demo.service.maquette.EcService;
import com.uasz.demo.service.maquette.UeService;

import lombok.AllArgsConstructor;

@Controller
    
@AllArgsConstructor

public class EcController {

    @Autowired
    private EcService ecService ;
    private UeService ueService;

    @RequestMapping(value ="/ajouter_ec_ue", method = RequestMethod.POST)
    public String ajouter_ec_ue(Model model, Ec ec){
        ecService.ajouterEC(ec);
        return "redirect:/details_ue?id="+ec.getUe().getId();

    }

    @RequestMapping(value = "/modifier_ec_ue",method = RequestMethod.POST)
    public String modifier_ec_ue(Model model , Ec ec ){
        ecService.modifierEC(ec);
        Ec ec2=ecService.rechercherEc(ec.getId());
        return "redirect:/details_ue?id="+ ec2.getUe().getId();
    }
    
    @RequestMapping(value ="/supprimer_ec_ue",method = RequestMethod.POST)
    public String supprimer_ec_ue(Model model , Ec ec ){
        Long id=ec.getUe().getId();
        ecService.supprimerEc(ec);
        return "redirect:/details_ue?id="+id;
    }
    
    
}
 */