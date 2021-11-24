package com.haythem.miniprojet.restcontrollers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haythem.miniprojet.entities.Joueur;
import com.haythem.miniprojet.service.JoueurService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JoueurRESTController {
	@Autowired
	JoueurService joueurservice;
	
	
	@RequestMapping(path ="all",method = RequestMethod.GET)
	public List<Joueur> getAllJoueurs() {
	return joueurservice.getAllJoueur();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Joueur getJoueurById(@PathVariable("id") Long id) {
	return joueurservice.getJoueur(id);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Joueur createJoueur(@RequestBody Joueur joueur) {
	return joueurservice.saveJoueur(joueur);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Joueur updateJoueur(@RequestBody Joueur joueur) {
	return joueurservice.updateJoueur(joueur);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteJoueur(@PathVariable("id") Long id)
	{
		joueurservice.deleteJoueurById(id);
	}
	
	
}
