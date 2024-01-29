package com.didak.feritboatcharter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didak.feritboatcharter.models.Brod;

@Repository
public interface BrodRepository extends JpaRepository<Brod, Integer> {
}
