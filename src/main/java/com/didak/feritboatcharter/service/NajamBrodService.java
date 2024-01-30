package com.didak.feritboatcharter.service;

import java.util.List;

import com.didak.feritboatcharter.models.NajamBrod;

public interface NajamBrodService {

	public List<NajamBrod> getNajamBrodWithUserId(int korisnikId);
}
