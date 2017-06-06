package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Seat_Area")
public class SeatAreaVO implements java.io.Serializable {
	@Id
	@Column(name="seat_area")
	private Integer seat_area;
	@Column(name="seat_price")
	private Integer seat_price;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="seat_area")
	private List<SeatVO> seats;
	
	@Override
	public String toString() {
		return "SeatAreaVO [seat_area=" + seat_area + ", seat_price=" + seat_price + "]";
	}
	public Integer getSeat_area() {
		return seat_area;
	}
	public void setSeat_area(Integer seat_area) {
		this.seat_area = seat_area;
	}
	public Integer getSeat_price() {
		return seat_price;
	}
	public void setSeat_price(Integer seat_price) {
		this.seat_price = seat_price;
	}
	public List<SeatVO> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatVO> seats) {
		this.seats = seats;
	}

	

} // end of class SeatAreaVO
