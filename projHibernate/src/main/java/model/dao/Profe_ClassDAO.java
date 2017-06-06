package model.dao;

import java.util.List;

import org.hibernate.Session;

import model.ClassVO;
import model.CoachVO;
import model.Profe_ClassVO;

public interface Profe_ClassDAO {

	Session getSession();
	Profe_ClassVO select(Integer Profe_sd);

	List<Profe_ClassVO> selectAll();

	Profe_ClassVO insert(Profe_ClassVO bean);

	Profe_ClassVO update(Integer profe_sd, ClassVO classVO, CoachVO coachVO, java.sql.Timestamp start_time,
			java.sql.Timestamp end_time, Integer class_qty);

	boolean delete(String Profe_sd);

}