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
import org.springframework.web.multipart.MultipartFile;

import com.didak.feritboatcharter.models.Korisnik;
import com.didak.feritboatcharter.service.KorisnikService;

@RestController
@RequestMapping("/korisnik")
@CrossOrigin
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;
	
	@PostMapping("/add")
	public String addKorisnik(@RequestBody Korisnik korisnik) { 
		korisnikService.saveKorisnik(korisnik);
		return "New Korisnik is added";
	}
	
	@GetMapping("/getAll")
    public List<Korisnik> list(){
        return korisnikService.getAllKorisnik();
    }
	
	@GetMapping("/checkIfUserExist")
	public Boolean checkIfUserExist(@RequestParam String email, @RequestParam String pass) {
		Boolean check = korisnikService.checkIfUserExist(email, pass);
		return check;
	}
	
	@GetMapping("/getUserStatus")
	public int getUserStatus(@RequestParam String email, @RequestParam String pass) {
		int res = korisnikService.getUserStatus(email, pass);
		return res;
	}
	
	@GetMapping("/getUserId")
	public int getUserId(@RequestParam String email, @RequestParam String pass) {
		int res = korisnikService.getUserId(email, pass);
		return res;
	}
	
	
	@GetMapping("/checkIfUserExistandGetUserStatus")
	public int checkIfUserExistandGetUserStatus(@RequestParam String email, @RequestParam String pass) {
		Boolean check = korisnikService.checkIfUserExist(email, pass);
		int res = -1; 
		
		if (check == true) {
			return res = korisnikService.getUserStatus(email, pass);
		}
		
		return res;
	}
	
	@PostMapping("/addDozvola")
	public void addDozvola(@RequestParam("image")MultipartFile file, @RequestParam("id")int id) {
		korisnikService.addDozvola(file, id);
	}
	
	
	@GetMapping("/provjeraDozvoleKorisnika")
	public boolean checkIfUserHasDozvola(@RequestParam int id) {
		return korisnikService.checkIfUserHasDozvola(id);
	}
	
	
}


