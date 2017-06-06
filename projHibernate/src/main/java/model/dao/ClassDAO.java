package model.dao;

import java.util.List;

import model.ClassVO;
import model.Class_PriceRangeVO;

public interface ClassDAO {

	ClassVO select(Integer class_sd);

	List<ClassVO> select();

	ClassVO insert(ClassVO bean);

	ClassVO update(String class_name, String class_intro, Class_PriceRangeVO class_level, Integer class_sd);

	boolean delete(Integer class_sd);

}