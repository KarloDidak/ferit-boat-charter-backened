package com.didak.feritboatcharter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.didak.feritboatcharter.models.NajamBrod;
import com.didak.feritboatcharter.service.NajamBrodService;

@RestController
@RequestMapping("/najamBrod")
@CrossOrigin
public class NajamBrodController {

	@Autowired
	private NajamBrodService najamBrodService;
	
	@GetMapping("/getWithUserId")
    public List<NajamBrod> getNajamBrodWithUserId(@RequestParam int korisnikId){
		return najamBrodService.getNajamBrodWithUserId(korisnikId);
    }
	
}
