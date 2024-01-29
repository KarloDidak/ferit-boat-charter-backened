package com.didak.feritboatcharter.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.didak.feritboatcharter.models.Brod;

public interface BrodService {
	public List<Brod> getAllBrod();
	public List<Brod> getBrodForDropDownForm(String tipBroda, String regija, String slobodanOd, String slobodanDo);
	public Brod getBrodWithName(String ime);
	public List<Brod> getBrodWithRegijaTipBroda(String tipBroda, String regija);
	public List<Brod> getBrodWithRegija(String regija);
	public List<Brod> getBrodWithTipBroda(String tipBroda);
	public List<Brod> getBrodWithDatumi(String slobodanOd, String slobodanDo);
	
	public Brod addNewBrod(Brod brod);
	public String uploadImage(MultipartFile file, String ime);
	
	public void deleteBrod(String ime);
}
