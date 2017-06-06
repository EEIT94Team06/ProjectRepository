package model.dao;

import java.util.List;

import model.GameVO;

public interface GameDAO {

	GameVO select(Integer game_sd);

	List<GameVO> select();

	GameVO insert(GameVO bean);

	GameVO update(String game_name, java.util.Date game_time, Integer game_sd);

	boolean delete(Integer game_sd);

}