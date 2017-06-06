package model;

import javax.persistence.*;

@Entity
@Table(name="Game_Detail")
public class GameDetailVO implements java.io.Serializable {
	@Id
	@Column(name="game_detail_sd")
	private Integer gamedetailsd;
	@ManyToOne
	@JoinColumn(name="game_order_sd")
	private Game_OrderVO game_Order;
	@ManyToOne
	@JoinColumn(name="seat_no")
	private SeatVO seatVO;
	@ManyToOne
	@JoinColumn(name="game_sd")
	private GameVO gameVO;
	
	
	@Override
	public String toString() {
		return "GameDetailVO [gamedetailsd=" + gamedetailsd + ", game_Order=" + game_Order + ", seatVO=" + seatVO
				+ ", gameVO=" + gameVO + "]";
	}
	public Integer getGamedetailsd() {
		return gamedetailsd;
	}
	public void setGamedetailsd(Integer gamedetailsd) {
		this.gamedetailsd = gamedetailsd;
	}
	public Game_OrderVO getGame_Order() {
		return game_Order;
	}
	public void setGame_Order(Game_OrderVO game_Order) {
		this.game_Order = game_Order;
	}
	public SeatVO getSeatVO() {
		return seatVO;
	}
	public void setSeatVO(SeatVO seatVO) {
		this.seatVO = seatVO;
	}
	public GameVO getGameVO() {
		return gameVO;
	}
	public void setGameVO(GameVO gameVO) {
		this.gameVO = gameVO;
	}
	

} // end of class GameDetailVO
