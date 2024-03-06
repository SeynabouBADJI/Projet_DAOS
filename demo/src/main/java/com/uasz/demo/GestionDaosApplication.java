package com.uasz.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.demo.modele.maquette.Ue;
import com.uasz.demo.modele.repartition.Enseignant;
import com.uasz.demo.modele.repartition.Per;
import com.uasz.demo.service.maquette.UeService;

@SpringBootApplication
public class GestionDaosApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(GestionDaosApplication.class, args);
	}
	@Autowired
	private UeService ueService;
	@Autowired
	@Override
	public void run(String... args)throws Exception {
		ueService.ajouterUe(new Ue(
		null,"GL1","INF351","bgbgbg",1,1,null,null,null,null));
		ueService.ajouterUe(new Ue(null,"GL2","INF751","vvvvvv",3,5,null,null,null,null));
;
	}
	
}
