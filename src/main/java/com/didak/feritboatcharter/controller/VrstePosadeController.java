package com.didak.feritboatcharter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didak.feritboatcharter.models.VrstePosade;
import com.didak.feritboatcharter.service.VrstePosadeService;

@RestController
@RequestMapping("/vrste-posade")
@CrossOrigin
public class VrstePosadeController {

	@Autowired
	private VrstePosadeService vrstePosadeService;
	
	@GetMapping("/getAll")
	public List<VrstePosade> list(){
        return vrstePosadeService.getAllVrstePosade();
    }
	
}
