package model.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Class_PriceRangeVO;

public class Class_PriceRangeDAOhibernate implements Class_PriceRangeDAO {
	private SessionFactory sessionFactory;
	public Class_PriceRangeDAOhibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
//	private static final String SELECT_BY_CLASS_LEVEL = 
//			"select class_price from Class_PriceRange where class_level = ?";
	@Override
	public Class_PriceRangeVO select(String class_level) {
			return getSession().get(Class_PriceRangeVO.class, class_level);
	}

//	private static final String UPDATE =
//			"update Class_PriceRange set class_price=? where class_level = ?";
	@Override
	public Class_PriceRangeVO update(Integer class_price, String class_level) {
		Class_PriceRangeVO bean = this.select(class_level);
		if(bean!=null){
			bean.setClass_price(class_price);
		}
		return bean;
	}
	
	
}
