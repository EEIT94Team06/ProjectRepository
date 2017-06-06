package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seat")
public class SeatVO {
	@Id
	private String seat_no;		//	seat_no char(5) Primary key,
	@ManyToOne
	@JoinColumn(name="seat_area")
	private SeatAreaVO seatArea;	//	seat_area int FOREIGN KEY REFERENCES Seat_Area(seat_area),
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="seat_no")
	private List<GameSeatVO> gameSeats;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="seat_no")
	private List<GameDetailVO> gameDetails;

	@Override
	public String toString() {
		return "SeatVO [seat_no=" + seat_no + ", seatArea=" + seatArea + ", gameSeats=" +  "]";
	}
	public String getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}
	public SeatAreaVO getSeatArea() {
		return seatArea;
	}
	public void setSeatArea(SeatAreaVO seatArea) {
		this.seatArea = seatArea;
	}
	public List<GameSeatVO> getGameSeats() {
		return gameSeats;
	}
	public void setGameSeats(List<GameSeatVO> gameSeats) {
		this.gameSeats = gameSeats;
	}
	public List<GameDetailVO> getGameDetails() {
		return gameDetails;
	}
	public void setGameDetails(List<GameDetailVO> gameDetails) {
		this.gameDetails = gameDetails;
	}

}
