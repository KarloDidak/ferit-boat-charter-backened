package com.didak.feritboatcharter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.didak.feritboatcharter.models.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>{
}