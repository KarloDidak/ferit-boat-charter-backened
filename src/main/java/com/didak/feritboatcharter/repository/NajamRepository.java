package com.didak.feritboatcharter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didak.feritboatcharter.models.Najam;

@Repository
public interface NajamRepository extends JpaRepository<Najam, Integer>{

}
