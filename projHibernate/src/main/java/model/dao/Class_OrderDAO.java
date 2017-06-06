package model.dao;

import java.util.List;

import model.Class_OrderVO;
import model.MemberVO;

public interface Class_OrderDAO {

	Class_OrderVO select(Integer class_order_sd);

	List<Class_OrderVO> select(String memberBean);

	Class_OrderVO insert(Class_OrderVO bean);

	boolean delete(Integer class_order_sd);

}