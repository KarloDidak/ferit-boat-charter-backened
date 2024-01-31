package com.didak.feritboatcharter.service;

import java.util.List;

import com.didak.feritboatcharter.models.Najam;

public interface NajamService {
	public void addNewNajam(Najam najam);
	public List<Najam> getNajamWithBrodId(int brodId);
	public List<Najam> getNajamWithUserId(int userId);
	public void deleteNajam(int najamId);
}
