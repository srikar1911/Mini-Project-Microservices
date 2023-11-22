package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.repository.IIPLPlayerRepository;
//import com.nt.repository.IIPLPlayerRepository;
import com.nt.repository.IIPLTeamRepository;

import lombok.extern.slf4j.Slf4j;


@Service("playerService")
@Slf4j
public class PlayerManagmentService implements IPlayerManagmentService {
	
	@Autowired
	private IIPLPlayerRepository playerRepo;

	
	
	
	@Override
	public String savePlayer(IPLPlayer player) {
		log.info("PlayerManagmentService:: savePlayer");
		int idVal = playerRepo.save(player).getPlayerId();
		return "Player is saved with id Value: "+idVal;
	}


	@Override
	public Iterable<IPLPlayer> showAllPlayers() {
		// TODO Auto-generated method stub
		log.info("PlayerManagmentService:: showAllPlayers");
		return playerRepo.findAll();
	}


	@Override
	public IPLPlayer showPlayerByID(Integer id) {
		// TODO Auto-generated method stub
		log.info("PlayerManagmentService:: showPlayerByID");
		
		return playerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid Player id"));
	}

}
