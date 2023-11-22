package com.nt.service;

import com.nt.entity.IPLPlayer;


public interface IPlayerManagmentService {

	public String savePlayer(IPLPlayer player);

	public Iterable<IPLPlayer>showAllPlayers();
	
	public IPLPlayer showPlayerByID(Integer id);
	
}
