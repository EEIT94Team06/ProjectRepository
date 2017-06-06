package model.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.ClassVO;
import model.Class_PriceRangeVO;

public class ClassDAOhibernate implements ClassDAO {
	private SessionFactory sessionFactory;
	public ClassDAOhibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
//	private static final String SELECT_BY_CLASS = 
//			"select * from Class where class_sd = ?";
	@Override
	public ClassVO select(Integer class_sd){
		return getSession().get(ClassVO.class, class_sd);
	}
	
//	private static final String SELECT_ALL = "select * from Class ";
	@Override
	public List<ClassVO> select() {
		return this.getSession().createQuery("FROM ClassVO", ClassVO.class).getResultList();
	}
	
//	private static final String INSERT =
//			"insert into Class values (?,?,?)";
	@Override
	public ClassVO insert(ClassVO bean) {
		if(bean!=null){
				this.getSession().save(bean);
				return bean;
			}

		return null;
	}
	
//	private static final String UPDATE =
//			"update Class set class_name=?, class_intro=?, class_level=? where class_sd=?";
	@Override
	public ClassVO update(String class_name,
			String class_intro, Class_PriceRangeVO class_level, Integer class_sd) {
		ClassVO bean = this.select(class_sd);
		if(bean!=null){
			bean.setClass_name(class_name);
			bean.setClass_intro(class_intro);
			bean.setClass_PriceRange(class_level);
		}
		return bean;
	}
	
//	private static final String DELETE =
//			"delete from Class where class_sd=?";
	@Override
	public boolean delete(Integer class_sd) {
		ClassVO bean = this.select(class_sd);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	
}
