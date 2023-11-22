package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLTeam;
//import com.nt.repository.IIPLPlayerRepository;
import com.nt.repository.IIPLTeamRepository;

import lombok.extern.slf4j.Slf4j;


@Service("teamService")
@Slf4j
public class TeamManagmentService implements ITeamManagmentService {
	
	@Autowired
	private IIPLTeamRepository teamRepo;
//	@Autowired
//	private IIPLPlayerRepository playerRepo;
	
	
	@Override
	public String saveTeam(IPLTeam team) { 
		log.info("TeamMgmtServiceimpl::saveTeam(-)method");
		return "Team and Players are saved with id Value: "+teamRepo.save(team).getTeamid();
	}


	@Override
	public Iterable<IPLTeam> showAllTeams() {
		log.info("TeamMgmtServiceimpl::showAllTeams()method");
		return teamRepo.findAll();
	}


	@Override
	public IPLTeam showTeamByID(Integer id) {
		log.info("TeamMgmtServiceimpl::showTeamByID()method");
		return teamRepo.getOne(id);
	}

}
