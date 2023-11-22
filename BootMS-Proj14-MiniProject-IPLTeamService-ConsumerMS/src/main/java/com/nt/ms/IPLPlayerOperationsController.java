package com.nt.ms;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.ITeamServiceConsumerClient;
import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.service.IPlayerManagmentService;

@RestController
@RequestMapping("/player/api")
public class IPLPlayerOperationsController {

	@Autowired
	private IPlayerManagmentService playerService;
	
	@Autowired
	private ITeamServiceConsumerClient client;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> registerplayer(@RequestBody IPLPlayer player){
		
		IPLTeam team = client.getTeamByID(player.getTeaminfo().getTeamid()).getBody();
		player.setTeaminfo(team);
		
		String msg = playerService.savePlayer(player);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLPlayer>> fetchAllPlayers(){
		Iterable<IPLPlayer> list = playerService.showAllPlayers();
		return new ResponseEntity<Iterable<IPLPlayer>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLPlayer> findPlayerByID(@PathVariable(name = "id") Integer id){
		
		IPLPlayer player = playerService.showPlayerByID(id);
		return new ResponseEntity<IPLPlayer>(player, HttpStatus.OK);
	}



}
