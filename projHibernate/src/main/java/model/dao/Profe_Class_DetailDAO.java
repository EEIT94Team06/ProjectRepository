package model.dao;

import java.util.List;

import org.hibernate.Session;

import model.Profe_Class_DetailVO;

public interface Profe_Class_DetailDAO {

	Session getSession();

	Profe_Class_DetailVO select(Integer profe_c_detail_sd);

	List<Profe_Class_DetailVO> selectAll(Integer class_order_sd);

	Profe_Class_DetailVO insert(Profe_Class_DetailVO bean);

	boolean delete(Integer profe_c_detail_sd);

}