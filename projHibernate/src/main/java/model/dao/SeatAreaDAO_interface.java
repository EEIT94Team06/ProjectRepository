package model.dao;

import java.util.List;

import model.SeatAreaVO;

public interface SeatAreaDAO_interface {

	SeatAreaVO select(Integer seatarea);

	List<SeatAreaVO> select();

	SeatAreaVO insert(SeatAreaVO seatAreaVO);

	SeatAreaVO update(Integer seatprice, Integer seatarea);

	boolean delete(Integer seatarea);

}
