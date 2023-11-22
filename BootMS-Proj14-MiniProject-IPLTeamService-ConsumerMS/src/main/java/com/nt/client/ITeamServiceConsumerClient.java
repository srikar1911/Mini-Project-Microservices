package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.entity.IPLTeam;

@FeignClient("TEAM-SERVICE")
public interface ITeamServiceConsumerClient {

	@GetMapping("/team/api/find/{id}")
	public ResponseEntity<IPLTeam> getTeamByID(Integer id);


}
