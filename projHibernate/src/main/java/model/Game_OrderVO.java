package model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Game_Order")
public class Game_OrderVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int game_order_sd;
	@ManyToOne
	@JoinColumn(name="Member_acct")
	private MemberVO member;
	private Timestamp buy_time;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="game_order_sd")
	private List<GameDetailVO> gameDetails;
	
	
	@Override
	public String toString() {
		return "Game_OrderVO [game_order_sd=" + game_order_sd + ", member=" + member + ", buy_time=" + buy_time
				 + "]";
	}
	public int getGame_order_sd() {
		return game_order_sd;
	}
	public void setGame_order_sd(int game_order_sd) {
		this.game_order_sd = game_order_sd;
	}
	public MemberVO getMember() {
		return member;
	}
	public void setMember(MemberVO member) {
		this.member = member;
	}
	public Timestamp getBuy_time() {
		return buy_time;
	}
	public void setBuy_time(Timestamp buy_time) {
		this.buy_time = buy_time;
	}
	public List<GameDetailVO> getGameDetails() {
		return gameDetails;
	}
	public void setGameDetails(List<GameDetailVO> gameDetails) {
		this.gameDetails = gameDetails;
	}
		

}
