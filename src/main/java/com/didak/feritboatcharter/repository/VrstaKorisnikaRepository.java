package com.didak.feritboatcharter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didak.feritboatcharter.models.VrstaKorisnika;

@Repository
public interface VrstaKorisnikaRepository extends JpaRepository<VrstaKorisnika, Integer> {

}
