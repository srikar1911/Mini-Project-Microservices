package com.nt.service;

import com.nt.entity.IPLTeam;

public interface ITeamManagmentService {

	public String saveTeam(IPLTeam team);

	public Iterable<IPLTeam>showAllTeams();
	
	public IPLTeam showTeamByID(Integer id);
	
}
