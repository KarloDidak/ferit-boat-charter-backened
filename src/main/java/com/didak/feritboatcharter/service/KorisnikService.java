package com.didak.feritboatcharter.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.didak.feritboatcharter.models.Korisnik;

public interface KorisnikService {
    public Korisnik saveKorisnik(Korisnik korisnik);
    public List<Korisnik> getAllKorisnik();
    public Boolean checkIfUserExist(String email, String pass);
    public int getUserStatus(String email, String pass);
    public int getUserId(String email, String pass);
    public void addDozvola(MultipartFile file, int id);
}
