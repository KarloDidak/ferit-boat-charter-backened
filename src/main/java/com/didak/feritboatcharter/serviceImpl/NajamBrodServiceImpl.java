package com.didak.feritboatcharter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.didak.feritboatcharter.models.NajamBrod;
import com.didak.feritboatcharter.service.NajamBrodService;

@Service
public class NajamBrodServiceImpl implements NajamBrodService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<NajamBrod> getNajamBrodWithUserId(int korisnikId) {
		String sql = "SELECT najam.najam_id, najam.brod_id, najam.korisnik_id, najam.zauzet_od, najam.zauzet_do, najam.cijena, brod.ime "
				+ "FROM najam INNER JOIN brod ON najam.brod_id = brod.id WHERE najam.korisnik_id = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(NajamBrod.class), new Object[] {korisnikId});
	}

}
