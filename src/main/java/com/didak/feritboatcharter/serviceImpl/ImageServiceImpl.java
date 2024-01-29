package com.didak.feritboatcharter.serviceImpl;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.didak.feritboatcharter.models.Image;
import com.didak.feritboatcharter.repository.ImageRepository;
import com.didak.feritboatcharter.service.ImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{

	@Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public String uploadImage(MultipartFile file) {
		
		Image img = new Image();
	/*	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		iF(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
	*/
		try {
			img.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		imageRepository.save(img);
		
		return "Proces spremanja slike odraden";
	}
	
	
	@Override
	public String downloadImage(String imageName) {
		String sql = "SELECT img FROM image WHERE name=:name";		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("name", imageName);
		
		return namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
				
	}

}
