package com.didak.feritboatcharter.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NajamBrod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNajamBrod;

	private int najamId;
	private int brodId;
	private int korisnikId;
	private Date zauzetOd;
	private Date zauzetDo;
	private int cijena;
	
	// OVO JE IME BRODA
	private String ime;
	
	public int getNajamId() {
		return najamId;
	}

	public void setNajamId(int najamId) {
		this.najamId = najamId;
	}

	public int getBrodId() {
		return brodId;
	}

	public void setBrodId(int brodId) {
		this.brodId = brodId;
	}

	public int getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(int korisnikId) {
		this.korisnikId = korisnikId;
	}

	public Date getZauzetOd() {
		return zauzetOd;
	}

	public void setZauzetOd(Date zauzetOd) {
		this.zauzetOd = zauzetOd;
	}

	public Date getZauzetDo() {
		return zauzetDo;
	}

	public void setZauzetDo(Date zauzetDo) {
		this.zauzetDo = zauzetDo;
	}

	public int getCijena() {
		return cijena;
	}

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
}
