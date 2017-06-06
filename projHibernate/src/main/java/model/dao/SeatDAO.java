package model.dao;

import java.util.List;

import org.hibernate.Session;

import model.SeatAreaVO;
import model.SeatVO;

public interface SeatDAO {

	Session getSession();

	SeatVO select(String seat_no);

	List<SeatVO> selectAll();

	SeatVO insert(SeatVO bean);

	SeatVO update(String seat_no, SeatAreaVO seatAreaVO);

	boolean delete(String seat_no);

}