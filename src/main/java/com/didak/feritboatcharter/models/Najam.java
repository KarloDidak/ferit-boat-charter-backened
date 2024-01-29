package com.didak.feritboatcharter.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Najam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int brodId;
	private Date zauzetOd;
	private Date zauzetDo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBrodId() {
		return brodId;
	}
	public void setBrodId(int brodId) {
		this.brodId = brodId;
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
	
}
