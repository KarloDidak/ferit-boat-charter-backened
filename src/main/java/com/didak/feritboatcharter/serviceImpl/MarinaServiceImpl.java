package com.didak.feritboatcharter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didak.feritboatcharter.models.Marina;
import com.didak.feritboatcharter.repository.MarinaRepository;
import com.didak.feritboatcharter.service.MarinaService;

@Service
public class MarinaServiceImpl implements MarinaService{

	
	@Autowired
	private MarinaRepository marinaRepository;
	
	@Override
	public List<Marina> getAllMarina() {
		return marinaRepository.findAll();
	}

}
