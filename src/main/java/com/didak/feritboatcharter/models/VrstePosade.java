package com.didak.feritboatcharter.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VrstePosade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String naziv;
	
	public VrstePosade() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	
}
