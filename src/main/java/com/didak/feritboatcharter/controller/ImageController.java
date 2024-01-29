package com.didak.feritboatcharter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.didak.feritboatcharter.service.ImageService;

@RestController
@RequestMapping("/slika")
@CrossOrigin
public class ImageController {

	@Autowired
	ImageService imageService; 

	@PostMapping("/add")
	public String uploadImage(@RequestParam("image")MultipartFile file){
		String temp = imageService.uploadImage(file);
		System.out.println(temp);
		
		return "redirect:/BoatListing.jsx";
	}
	
	@GetMapping("/get")
	public String downloadImage(@RequestParam("name")String name){
		String imageData = imageService.downloadImage(name);
		
		return imageData;
	}
	
}
