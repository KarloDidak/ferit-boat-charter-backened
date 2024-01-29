package com.didak.feritboatcharter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didak.feritboatcharter.models.VrsteBroda;
import com.didak.feritboatcharter.service.VrsteBrodaService;

@RestController
@RequestMapping("/vrste-broda")
@CrossOrigin
public class VrsteBrodaController {

	@Autowired
	private VrsteBrodaService brodaService;
	
	@GetMapping("/getAll")
	public List<VrsteBroda> list(){
        return brodaService.getAllVrsteBroda();
    }
}
