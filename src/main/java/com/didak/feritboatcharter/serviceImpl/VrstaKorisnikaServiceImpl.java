package com.didak.feritboatcharter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didak.feritboatcharter.models.VrstaKorisnika;
import com.didak.feritboatcharter.repository.VrstaKorisnikaRepository;
import com.didak.feritboatcharter.service.VrstaKorisnikaService;

@Service
public class VrstaKorisnikaServiceImpl implements VrstaKorisnikaService{

	@Autowired
	VrstaKorisnikaRepository vrstaKorisnikaRepository;

	@Override
	public List<VrstaKorisnika> getAllVrsteKorisnika() {
		return vrstaKorisnikaRepository.findAll();
	}
	
}
