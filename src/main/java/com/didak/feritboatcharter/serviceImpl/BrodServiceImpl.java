package com.didak.feritboatcharter.serviceImpl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.didak.feritboatcharter.models.Brod;
import com.didak.feritboatcharter.repository.BrodRepository;
import com.didak.feritboatcharter.service.BrodService;

@Service
public class BrodServiceImpl implements BrodService {

    @Autowired
    private BrodRepository brodRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Override
	public Brod addNewBrod(Brod brod) {
		return brodRepository.save(brod);
	}
	
	@Override
	public List<Brod> getAllBrod() {
		return brodRepository.findAll();
	}

	@Override
	public Brod getBrodWithId(int id) {
		String sql = "select id, brzina, cijena, duljina_preko_svega, gaz, godina, ime, slika, kabine, lezajevi, motor, opis, posada, "
				+ "regija, tip, tus, slobodan_do, slobodan_od from brod where id = ?";		
		
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Brod.class) ,new Object[] {id});
	}

	
	@Override
	public Brod getBrodWithName(String ime) {
		String sql = "select id, brzina, cijena, duljina_preko_svega, gaz, godina, ime, slika, kabine, lezajevi, motor, opis, posada, "
				+ "regija, tip, tus, slobodan_do, slobodan_od from brod where ime = ?";
		Brod tBrod = null;
		
		try {
			tBrod = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Brod.class) ,new Object[] {ime});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		return tBrod;
	}

	
	
	@Override
	public List<Brod> getBrodWithRegijaTipBroda(String tip, String regija) {
		String sql = "select brzina, cijena, duljina_preko_svega, gaz, godina, ime, slika, kabine, lezajevi, motor, opis, posada, "
				+ "regija, tip, tus from brod where tip = ? and regija = ?";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {tip, regija});
		
	}

	@Override
	public List<Brod> getBrodWithRegija(String regija) {
		
		String sql = "select brzina, cijena, duljina_preko_svega, gaz, godina, ime, slika, kabine, lezajevi, motor, opis, posada, "
				+ "regija, tip, tus from brod where regija = ?";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {regija});
		
	}

	@Override
	public List<Brod> getBrodWithTipBroda(String tipBroda) {
		
		String sql = "select brzina, cijena, duljina_preko_svega, gaz, godina, ime, slika, kabine, lezajevi, motor, opis, posada, "
				+ "regija, tip, tus from brod where tip = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {tipBroda});
	}
	
	@Override
	public List<Brod> getBrodWithDatumi(String slobodanOd, String slobodanDo) {
		String sql = "SELECT * FROM `brod` WHERE `slobodan_od`>= ? AND `slobodan_od`<= ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {slobodanOd, slobodanDo});
	}
	
	@Override
	public List<Brod> getBrodForDropDownForm(String tipBroda, String regija, String slobodanOd, String slobodanDo) {
		
		String sql;
		
		if(tipBroda == null && slobodanOd.equals("1970-01-01") && slobodanDo.equals("1970-01-01")) {
			sql = "SELECT * FROM `brod` WHERE regija = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {regija});
			
		}else if(regija == null && slobodanOd.equals("1970-01-01") && slobodanDo.equals("1970-01-01")) {
			sql = "SELECT * FROM `brod` WHERE tip = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {tipBroda});
			
		}else if(regija == null && tipBroda == null) {
			sql = "SELECT * FROM `brod` WHERE `slobodan_od`<= ? AND `slobodan_do`>= ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {slobodanOd, slobodanDo});
			
		}else if (tipBroda == null) {
			 sql = "SELECT * FROM `brod` WHERE regija = ? AND `slobodan_od`>= ? AND `slobodan_od`<= ?";
			 return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {regija, slobodanOd, slobodanDo});
			 
		}else if(regija == null) {
			 sql = "SELECT * FROM `brod` WHERE tip = ? AND `slobodan_od`>= ? AND `slobodan_od`<= ?";
			 return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {tipBroda, slobodanOd, slobodanDo});
			 
		}else if(slobodanOd != "1970-01-01" && slobodanDo != "1970-01-01") {
			sql = "SELECT * FROM `brod` WHERE tip = ? and regija = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {tipBroda, regija});
			 
		}else {
			sql = "SELECT * FROM `brod` WHERE tip = ? AND regija = ? AND `slobodan_od`>= ? AND `slobodan_od`<= ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brod.class), new Object[] {tipBroda, regija, slobodanOd, slobodanDo});
		}
	}
	
	@Override
	public String uploadImage(MultipartFile file, String ime) {

			String img = null;
		
			try {
				 img = Base64.getEncoder().encodeToString(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String sql = "UPDATE brod SET slika= ? WHERE ime= ? ";
						
			jdbcTemplate.update(sql, img, ime);
			
			return "Proces spremanja slike odraden";
				
	}

	@Override
	public void deleteBrod(String ime) {
		String sql = "DELETE FROM brod WHERE ime= ?";
		jdbcTemplate.update(sql, ime);
	}


	/*
	
	 PRIMJER IZ SUI-a
	 @Override
	 public List<Artefakt> getArtefatke(Integer pIdGrupe){
	 	String tSql = "select ID_ARTEFAKTA, ID_GRUPE, SIF_ARTEFAKTA, NAZ_ARTEFAKATA, OPIS_ARTEFAKATA, STS, TSTAMP, TSTAMP_OBRADE form
	 	ARTEFAKT where ID_GRUPE = ? ORDER by SIF_ARTEFAKTA ASC";
	 	return jdbcTemplate.query(tSql, new Object[]){pIdGrupe}, new BeanPropertyRowMapper<>(Artefakt.class));
	 
	 }
	 	  
	 */

}
