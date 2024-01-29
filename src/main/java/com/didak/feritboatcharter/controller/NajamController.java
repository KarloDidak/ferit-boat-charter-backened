package com.didak.feritboatcharter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.didak.feritboatcharter.models.Najam;
import com.didak.feritboatcharter.service.NajamService;

@RestController
@RequestMapping("/najam")
@CrossOrigin
public class NajamController {
	
	@Autowired
	NajamService najamService;

	@PostMapping("/add")
	public void dodajNoviNajam(@RequestBody Najam najam) {	
		najamService.addNewNajam(najam);
	}
	
	@GetMapping("/getNajamWithBrodId")
    public List<Najam> getNajamWithBrodId(@RequestParam int brodId){
        return najamService.getNajamWithBrodId(brodId);
    }
	
}		