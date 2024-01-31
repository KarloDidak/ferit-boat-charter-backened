package com.didak.feritboatcharter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.didak.feritboatcharter.models.Najam;
import com.didak.feritboatcharter.repository.NajamRepository;
import com.didak.feritboatcharter.service.NajamService;

@Service
public class NajamServiceImpl implements NajamService{

	@Autowired
	private NajamRepository najamRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void addNewNajam(Najam najam) {
		najamRepository.save(najam);
	}

	@Override
	public List<Najam> getNajamWithBrodId(int brodId) {
		String sql = "SELECT * FROM najam WHERE brod_id = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Najam.class), new Object[] {brodId});
	}

	@Override
	public List<Najam> getNajamWithUserId(int userId) {
		String sql = "SELECT * FROM najam WHERE korisnik_id = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Najam.class), new Object[] {userId});
	}
	
	@Override
	public void deleteNajam(int najamId) {
		String sql = "DELETE FROM najam WHERE najam_id= ?";
		jdbcTemplate.update(sql, najamId);
		
	}


}
