package model.dao;

import java.util.List;

import org.hibernate.Session;

import model.Class_OrderVO;
import model.OneOnOne_Class_DetailVO;

public interface OneOnOne_Class_DetailDAO {

	Session getSession();

	OneOnOne_Class_DetailVO select(String ooo_c_detail_sd);

	List<OneOnOne_Class_DetailVO> selectAll(Integer class_order_sd);

	OneOnOne_Class_DetailVO insert(OneOnOne_Class_DetailVO bean);

	boolean delete(String ooo_c_detail_sd);

}