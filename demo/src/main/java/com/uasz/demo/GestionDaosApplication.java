package com.uasz.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.demo.modele.maquette.Ue;
import com.uasz.demo.modele.repartition.Enseignant;
import com.uasz.demo.modele.repartition.Per;
import com.uasz.demo.modele.repartition.Vacataire;
import com.uasz.demo.service.maquette.UeService;
import com.uasz.demo.service.repartition.EnseignantService;

@SpringBootApplication
public class GestionDaosApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(GestionDaosApplication.class, args);
	}
	@Autowired
	private UeService ueService;
	@Autowired
	private EnseignantService enseignantService;
	@Override
	public void run(String... args)throws Exception {
		ueService.ajouterUe(new Ue(
		null,"GL1","INF351","bgbgbg",1,1,null,null,null,null));
		ueService.ajouterUe(new Ue(null,"GL2","INF751","vvvvvv",3,5,null,null,null,null));

			Per per1 = new Per(); 
			per1.setNom("Badji");
			per1.setPrenom("Idrissa");
			per1.setGrade("enseignant chercheur");
			per1.setDatecreation("04-03-2024");
			per1.setRepartition(null);
			per1.setMatricule("B5");
			enseignantService.ajouter_Ens(per1);

			Per per2 = new Per(); 
			per2.setNom("Badji");
			per2.setPrenom("Idrissa");
			per2.setGrade("enseignant chercheur");
			per2.setDatecreation("04-03-2024");
			per2.setRepartition(null);
			per2.setMatricule("B5");
			enseignantService.ajouter_Ens(per2);

			Vacataire vacataire = new Vacataire();
			vacataire.setNom("hdhh");
			vacataire.setPrenom("ds");
			vacataire.setGrade("sxsx");
			vacataire.setDatecreation("null");
			vacataire.setRepartition(null);
			vacataire.setSpecialite("ssss");
			enseignantService.ajouter_Ens(vacataire);
	}
	
}
