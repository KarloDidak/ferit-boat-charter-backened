package com.didak.feritboatcharter.serviceImpl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.didak.feritboatcharter.models.Korisnik;
import com.didak.feritboatcharter.repository.KorisnikRepository;
import com.didak.feritboatcharter.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Korisnik saveKorisnik(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	@Override
	public List<Korisnik> getAllKorisnik() {
		return korisnikRepository.findAll();
	}

	@Override
	public Boolean checkIfUserExist(String email, String sifra) {
		String sql = "SELECT EXISTS(SELECT 1 FROM korisnik WHERE mail=:mail AND sifra=:sifra ) AS user_exists";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("mail", email);
		map.addValue("sifra", sifra);
		
		Boolean userExist = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class) > 0;
		
		return userExist;
	}

	@Override
	public int getUserStatus(String email, String pass) {
		String sql = "SELECT status FROM korisnik WHERE mail=:mail AND sifra=:sifra";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("mail", email);
		map.addValue("sifra", pass);
		
		return namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
		
	}

	@Override
	public int getUserId(String email, String pass) {
		String sql = "SELECT id FROM korisnik WHERE mail=:mail AND sifra=:sifra";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("mail", email);
		map.addValue("sifra", pass);
		
		return namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
	}

	@Override
	public void addDozvola(MultipartFile file, int id) {
		String img = null;
		
			try {
				img = Base64.getEncoder().encodeToString(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String sql = "UPDATE korisnik SET dozvola= ? WHERE id= ? ";
			
			jdbcTemplate.update(sql, img, id);
		
	}
}









