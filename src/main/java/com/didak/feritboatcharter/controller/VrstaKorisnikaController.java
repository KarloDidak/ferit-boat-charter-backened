package com.didak.feritboatcharter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didak.feritboatcharter.models.VrstaKorisnika;
import com.didak.feritboatcharter.service.VrstaKorisnikaService;

@RestController
@RequestMapping("/vrsta-korisnika")
@CrossOrigin
public class VrstaKorisnikaController {

	@Autowired
	private VrstaKorisnikaService vrstaKorisnikaService;
	
	@GetMapping("/getAll")
    public List<VrstaKorisnika> getAll(){
        return vrstaKorisnikaService.getAllVrsteKorisnika();
    }
	
}
