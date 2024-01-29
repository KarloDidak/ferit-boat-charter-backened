package com.didak.feritboatcharter.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.didak.feritboatcharter.models.Brod;
import com.didak.feritboatcharter.service.BrodService;

@RestController
@RequestMapping("/brod")
@CrossOrigin
public class BoatController {

	@Autowired
    private BrodService brodService;
	
	@GetMapping("/getAll")
    public List<Brod> getAll(){
        return brodService.getAllBrod();
    }
	
	@GetMapping("/getBrodWithName")
    public Brod getBrodWithName(@RequestParam String ime){
		Brod temp = brodService.getBrodWithName(ime);
		return temp;
    }
	
	@GetMapping("/getBrodForSearchForm")
	public List<Brod> getBrodForSearchForm(@RequestParam(required = false) String tip_broda, @RequestParam(required = false) String regija, @RequestParam(required = false) String slobodanOd, @RequestParam(required = false) String slobodanDo ){
		
		Date datumOd = new Date();
		Date datumDo = new Date();
		
		String formatiraniDatumOd = null;
		
		datumOd.setTime(Long.parseLong(slobodanOd));
		formatiraniDatumOd = new SimpleDateFormat("yyyy-MM-dd").format(datumOd);
		
		datumDo.setTime(Long.parseLong(slobodanDo));
		String formatiraniDatumDo = new SimpleDateFormat("yyyy-MM-dd").format(datumDo);
		
		return brodService.getBrodForDropDownForm(tip_broda, regija, formatiraniDatumOd, formatiraniDatumDo);
    }
	
		
	@PostMapping("/add")
	public String postNewBrod(@RequestBody Brod brod) {	
		brodService.addNewBrod(brod);
		return "Dodan NOVI brod";
	}
	
	
	@PostMapping("/addSlikaToBrod")
	public String uploadImage(@RequestParam("image")MultipartFile file, @RequestParam("name")String ime){
		String temp = brodService.uploadImage(file, ime);
		System.out.println(temp);
		
		return "redirect:/BoatListing.jsx";
	}
	
	@PostMapping("/deleteBrod")
    public void deleteBrod(@RequestParam("name")String ime){
		brodService.deleteBrod(ime);
    }
	
}

