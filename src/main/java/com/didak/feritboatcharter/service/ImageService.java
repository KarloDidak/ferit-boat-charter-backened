package com.didak.feritboatcharter.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	public String uploadImage(MultipartFile file);
	public String downloadImage(String imageName);
}
