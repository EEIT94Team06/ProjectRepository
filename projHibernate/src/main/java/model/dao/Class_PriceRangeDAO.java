package model.dao;

import model.Class_PriceRangeVO;

public interface Class_PriceRangeDAO {

	Class_PriceRangeVO select(String class_level);

	Class_PriceRangeVO update(Integer class_price, String class_level);

}