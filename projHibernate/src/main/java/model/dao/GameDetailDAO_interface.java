package model.dao;

import java.util.List;

import model.GameDetailVO;

public interface GameDetailDAO_interface {

	GameDetailVO select(Integer gamedetailsd);

	List<GameDetailVO> select();

	GameDetailVO insert(GameDetailVO gameDetailVO);

	boolean delete(Integer gamedetailsd);

}
