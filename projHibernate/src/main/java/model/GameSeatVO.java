package model;

import javax.persistence.*;

@Entity
@Table(name="Game_seat")
public class GameSeatVO implements java.io.Serializable {
	@Id
	@Column(name="game_seat_sd")
	private Integer game_seat_sd;
	@ManyToOne
	@JoinColumn(name="game_sd")
	private GameVO game;
	@ManyToOne
	@JoinColumn(name="seat_no")
	private SeatVO seat;
	private Boolean sold;
	
	
	@Override
	public String toString() {
		return "GameSeatVO [game_seat_sd=" + game_seat_sd + ", game=" + game + ", seat=" + seat + ", sold=" + sold
				+ "]";
	}
	public Integer getGame_seat_sd() {
		return game_seat_sd;
	}
	public void setGame_seat_sd(Integer game_seat_sd) {
		this.game_seat_sd = game_seat_sd;
	}
	public GameVO getGame() {
		return game;
	}
	public void setGame(GameVO game) {
		this.game = game;
	}
	public SeatVO getSeat() {
		return seat;
	}
	public void setSeat(SeatVO seat) {
		this.seat = seat;
	}
	public Boolean getSold() {
		return sold;
	}
	public void setSold(Boolean sold) {
		this.sold = sold;
	}

} // end of class GameSeatVO
