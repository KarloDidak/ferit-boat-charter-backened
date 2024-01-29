package com.didak.feritboatcharter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didak.feritboatcharter.models.VrstePosade;
import com.didak.feritboatcharter.repository.VrstePosadeRepository;
import com.didak.feritboatcharter.service.VrstePosadeService;

@Service
public class VrstePosadeServiceImpl implements VrstePosadeService{

	@Autowired
	VrstePosadeRepository vrstePosadeRepository;
	
	@Override
	public List<VrstePosade> getAllVrstePosade() {
		return vrstePosadeRepository.findAll();
	}

}
