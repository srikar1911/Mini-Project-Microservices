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

import com.nt.entity.IPLTeam;
import com.nt.service.ITeamManagmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/team/api")
public class IPLTeamOperationsController {

	@Autowired
	private ITeamManagmentService teamService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team){
		log.info("IPLTeamOPerationsController:: registerTeam(-)method");
		String msg = teamService.saveTeam(team);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLTeam>> fetchAllTeams(){
		log.info("IPLTeamOPerationsController:: fetchTeam()method");
		Iterable<IPLTeam> list = teamService.showAllTeams();
		return new ResponseEntity<Iterable<IPLTeam>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLTeam> findTeamByI(@PathVariable(name = "id") Integer id){
		log.info("IPLTeamOPerationsController:: findTeamByIDmethod");
		IPLTeam team = teamService.showTeamByID(id);
		return new ResponseEntity<IPLTeam>(team, HttpStatus.OK);
	}



}
