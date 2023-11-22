package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.micrometer.core.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "MS_MP_PLAYER")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class IPLPlayer {

	@Id
	@SequenceGenerator(name = "gen1", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer playerId;
	@Column(length = 20)
	@NonNull
	private String playerName;
	@Column(length = 10)
	@NonNull
	private String role;
	@NonNull
	private Integer jersyNo;
	
	
	
	@Override
	public String toString() {
		return "IPLPlayer [playerId=" + playerId + ", playerName=" + playerName + ", role=" + role + ", jersyNo="
				+ jersyNo + "]";
	}



	@ManyToOne(targetEntity = IPLTeam.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_INFI_ID", referencedColumnName = "TEAM_ID")
	private IPLTeam teaminfo;
	
}
