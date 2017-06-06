package model.dao;

import java.util.List;

import model.GameSeatVO;
import model.GameVO;
import model.SeatVO;

public interface GameSeatDAO_interface {
	GameSeatVO select(Integer gameseatsd);

	List<GameSeatVO> select();

	GameSeatVO insert(GameSeatVO gameSeatVO);

	GameSeatVO update(GameVO gamesd, SeatVO seatno, Boolean sold, Integer gameseatsd);

}
