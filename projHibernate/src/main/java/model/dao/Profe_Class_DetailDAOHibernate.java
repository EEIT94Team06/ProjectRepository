package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Profe_Class_DetailVO;
import model.hibernate.HibernateUtil;

public class Profe_Class_DetailDAOHibernate implements Profe_Class_DetailDAO {
	// 為了確保Session失效是dao能夠再造出session來使用，建構子改用SessionFactory
	private SessionFactory sessionfactory;

	public Profe_Class_DetailDAOHibernate(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public Session getSession() {
		return sessionfactory.getCurrentSession();// return屬性session
	}

	public static void main(String [] args){
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Profe_Class_DetailDAO dao = new Profe_Class_DetailDAOHibernate(sessionfactory); 
		Profe_Class_DetailVO bean= new Profe_Class_DetailVO();
		try{
			sessionfactory.getCurrentSession().beginTransaction();
			//test select
//			System.out.println(dao.select(1));
			
			//test selectAll
//			System.out.println(dao.selectAll(1));
			
			//test insert
//			bean.setClass_Order(new Class_OrderDAOhibernate(sessionfactory).select(1));
//			bean.setProfe_Class(new Profe_ClassDAOHibernate(sessionfactory).select(1));
//			System.out.println(dao.insert(bean));
			
			//test delete
			System.out.println(dao.delete(3));
			
			sessionfactory.getCurrentSession().getTransaction().commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			sessionfactory.getCurrentSession().getTransaction().rollback();
		}finally{
			HibernateUtil.closeSessionFactory();
		}
	}

	@Override
	public Profe_Class_DetailVO select(Integer profe_c_detail_sd) {
		return getSession().get(Profe_Class_DetailVO.class, profe_c_detail_sd);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Profe_Class_DetailVO> selectAll(Integer class_order_sd) {
		List<Profe_Class_DetailVO> result = getSession()
				.createQuery(
						"SELECT bean FROM Profe_Class_DetailVO bean WHERE class_order_sd =?")
				.setParameter(0, class_order_sd).getResultList();
		return result;
	}

	@Override
	public Profe_Class_DetailVO insert(Profe_Class_DetailVO bean) {
		if (bean != null) {
			int result = (int) getSession().save(bean);
			if (result > 0) {
				return bean;
			}else{
				return null;
			}
			
		}
		return null;
	}

	@Override
	public boolean delete(Integer profe_c_detail_sd) {
		// boolean result = false;
		// if(this.select(profe_c_detail_sd)!=null){
		// getSession().delete(profe_c_detail_sd);
		// result = true;
		// }
		// return result;
		int result = getSession().createQuery("DELETE FROM Profe_Class_DetailVO "
				+ "WHERE profe_c_detail_sd =?").setParameter(0, profe_c_detail_sd).executeUpdate();
		if (result > 0) {
			return true;
		} else if (result == 0) {
			return false;
		} else {
			System.err.println("delete failed");
			return false;
		}
	}
}
