package com.didak.feritboatcharter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didak.feritboatcharter.models.VrsteBroda;

@Repository
public interface VrsteBrodaRepository extends JpaRepository<VrsteBroda, Integer>{
}
