package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 

@Entity
@Table(name = "MS_MP_IPLTEAM")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class IPLTeam implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer teamid;
	@NonNull
	@Column(length = 20)
	private String teamName;
	@NonNull
	private Integer teamSize;
	@NonNull
	@Column(length = 20)
	private String teamOwner; 
	 
	
	@OneToMany(targetEntity = IPLPlayer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teaminfo")
	@NonNull
//	@JoinColumn(name = "TEAM_INFO_ID", referencedColumnName = "TEAM_ID")
	private Set<IPLPlayer> players;
	
}
