package com.didak.feritboatcharter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didak.feritboatcharter.models.Marina;
import com.didak.feritboatcharter.service.MarinaService;

@RestController
@RequestMapping("/marina")
@CrossOrigin
public class MarinaController {

	@Autowired
	private MarinaService marinaService;
	
	@GetMapping("/getAll")
	public List<Marina> list(){
        return marinaService.getAllMarina();
    }
	
}
