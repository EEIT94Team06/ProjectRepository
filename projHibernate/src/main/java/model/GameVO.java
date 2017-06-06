package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Game")
public class GameVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int game_sd;
	private String game_name;
	private Date game_time;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="game_sd")
	private List<GameDetailVO> gameDetails;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="game_sd")
	private List<GameSeatVO> gameSeats;
	
	@Override
	public String toString() {
		return "GameVO [game_sd=" + game_sd + ", game_name=" + game_name + ", game_time=" + game_time + "]";
	}
	public int getGame_sd() {
		return game_sd;
	}
	public void setGame_sd(int game_sd) {
		this.game_sd = game_sd;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public Date getGame_time() {
		return game_time;
	}
	public void setGame_time(Date game_time) {
		this.game_time = game_time;
	}
	public List<GameDetailVO> getGameDetails() {
		return gameDetails;
	}
	public void setGameDetails(List<GameDetailVO> gameDetails) {
		this.gameDetails = gameDetails;
	}
	public List<GameSeatVO> getGameSeats() {
		return gameSeats;
	}
	public void setGameSeats(List<GameSeatVO> gameSeats) {
		this.gameSeats = gameSeats;
	}
	
	
}
