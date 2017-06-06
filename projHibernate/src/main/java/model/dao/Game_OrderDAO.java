package model.dao;

import java.util.List;

import model.Game_OrderVO;
import model.MemberVO;

public interface Game_OrderDAO {

	Game_OrderVO select(Integer game_order_sd);

	List<Game_OrderVO> select(String Member_acct);

	Game_OrderVO insert(Game_OrderVO bean);

	boolean delete(Integer game_order_sd);

}