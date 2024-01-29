package com.didak.feritboatcharter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didak.feritboatcharter.models.VrsteBroda;
import com.didak.feritboatcharter.repository.VrsteBrodaRepository;
import com.didak.feritboatcharter.service.VrsteBrodaService;

@Service
public class VrsteBrodaServiceImpl implements VrsteBrodaService{

	
	@Autowired
	VrsteBrodaRepository vrsteBrodaRepository;
	
	@Override
	public List<VrsteBroda> getAllVrsteBroda() {
		return vrsteBrodaRepository.findAll();
	}

	
	
}
