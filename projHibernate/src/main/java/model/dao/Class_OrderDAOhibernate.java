package model.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.ClassVO;
import model.Class_OrderVO;
import model.Class_PriceRangeVO;
import model.MemberVO;
import model.hibernate.HibernateUtil;

public class Class_OrderDAOhibernate implements Class_OrderDAO {
	private SessionFactory sessionFactory;
	public Class_OrderDAOhibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		try{
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		
		Class_OrderDAO classOrderDao = new Class_OrderDAOhibernate(HibernateUtil.getSessionFactory());
//		List<Class_OrderVO> select = classOrderDao.select("alan001");
//		ClassDAO classDao = new ClassDAOhibernate(HibernateUtil.getSessionFactory());
//		System.out.println(classDao.delete(1));
		
		
		System.out.println(classOrderDao.select("alan001"));
//		Class_OrderVO bean = new Class_OrderVO();
//		bean.setClass_sd(beanClass);
//		bean.setMemberBean(beanmember);

//		Class_OrderVO insert = classOrderDao.insert(bean);
//		System.out.println(insert);
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}finally{
			HibernateUtil.closeSessionFactory();
		}
	}
	
//	private static final String SELECT_BY_CLASS_ORDER = "select * from Class_Order where class_order_sd = ?";
	@Override
	public Class_OrderVO select(Integer class_order_sd) {
		return getSession().get(Class_OrderVO.class, class_order_sd);
	}


	@Override
	public List<Class_OrderVO> select(String memberBean) {
		List<Class_OrderVO> select = this.getSession()
				.createQuery("FROM Class_OrderVO where Member_acct=:Member_acct")
				.setParameter("Member_acct",memberBean).getResultList();
		return select;
				
	}

//	private static final String INSERT =
//			"insert into Class_Order values (?,?)";
	@Override
	public Class_OrderVO insert(Class_OrderVO bean) {
		if(bean!=null) {
				this.getSession().save(bean);
				return bean;
			}

		return null;
	}
	
//	private static final String DELETE =
//			"delete from Class_Order where class_order_sd=?";
	@Override
	public boolean delete(Integer class_order_sd) {
		Class_OrderVO bean = this.select(class_order_sd);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	
}
