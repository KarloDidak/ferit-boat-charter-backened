package com.didak.feritboatcharter.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Brod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int userId;
	private String ime;
	private String tip;
	private String regija;
	private int godina;
	private int kabine;
	private int lezajevi;
	private String gaz;
	private String brzina;
	private String duljinaPrekoSvega;
	private int tus;
	private int cijena;
	private String posada;
	private String motor;
	private String opis;
	private Date slobodanOd;
	private Date slobodanDo;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String slika;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tipBroda) {
		this.tip = tipBroda;
	}

	public String getRegija() {
		return regija;
	}

	public void setRegija(String regija) {
		this.regija = regija;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public int getKabine() {
		return kabine;
	}

	public void setKabine(int kabine) {
		this.kabine = kabine;
	}

	public int getLezajevi() {
		return lezajevi;
	}

	public void setLezajevi(int lezajevi) {
		this.lezajevi = lezajevi;
	}

	public String getGaz() {
		return gaz;
	}

	public void setGaz(String gaz) {
		this.gaz = gaz;
	}

	public String getBrzina() {
		return brzina;
	}

	public void setBrzina(String brzinaKrstarenja) {
		this.brzina = brzinaKrstarenja;
	}

	public String getDuljinaPrekoSvega() {
		return duljinaPrekoSvega;
	}

	public void setDuljinaPrekoSvega(String duljinaPrekoSvega) {
		this.duljinaPrekoSvega = duljinaPrekoSvega;
	}

	public int getTus() {
		return tus;
	}

	public void setTus(int tus) {
		this.tus = tus;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public int getCijena() {
		return cijena;
	}

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}

	public String getPosada() {
		return posada;
	}

	public void setPosada(String posada) {
		this.posada = posada;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getSlobodanOd() {
		return slobodanOd;
	}

	public void setSlobodanOd(Date slobodanOd) {
		this.slobodanOd = slobodanOd;
	}

	public Date getSlobodanDo() {
		return slobodanDo;
	}

	public void setSlobodanDo(Date slobodanDo) {
		this.slobodanDo = slobodanDo;
	}
	
}
