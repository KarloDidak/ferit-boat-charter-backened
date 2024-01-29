package com.didak.feritboatcharter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didak.feritboatcharter.models.VrstePosade;

@Repository
public interface VrstePosadeRepository extends JpaRepository<VrstePosade, Integer>{

}
