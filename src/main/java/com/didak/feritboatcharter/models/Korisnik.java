package com.didak.feritboatcharter.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Korisnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private	String ime;
	private String mail;
	private String sifra;
	private	int status;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String dozvola;
	
	public Korisnik() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getSifra() {
		return sifra;
	}
	
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
		
}
