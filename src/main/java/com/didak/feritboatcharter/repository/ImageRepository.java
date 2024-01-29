package com.didak.feritboatcharter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didak.feritboatcharter.models.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
	String findByName(String name);
}
