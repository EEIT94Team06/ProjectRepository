package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.ClassVO;
import model.CoachVO;
import model.Profe_ClassVO;
import model.hibernate.HibernateUtil;

public class Profe_ClassDAOHibernate implements Profe_ClassDAO {
	// 為了確保Session失效是dao能夠再造出session來使用，建構子改用SessionFactory
	private SessionFactory sessionfactory;

	public Profe_ClassDAOHibernate( SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public Session getSession() {
		return sessionfactory.getCurrentSession();// return屬性session
	}
	public static void main(String[] args) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Profe_ClassDAO dao = new Profe_ClassDAOHibernate(sessionfactory);
		Profe_ClassVO bean = new Profe_ClassVO();
		try {
			sessionfactory.getCurrentSession().beginTransaction();
			//test select 
//			System.out.println(dao.select(1));
			
			//test selectAll
//			System.out.println(dao.selectAll());
			
			//test insert
			bean.setClassbean(new ClassDAOhibernate(sessionfactory).select(1));
			bean.setCoach(new CoachDAOHibernate(sessionfactory).select("alex"));
			bean.setStart_time(new java.sql.Timestamp(new Date().getTime()) );
			bean.setEnd_time(new java.sql.Timestamp(new Date().getTime()) );
			System.out.println(dao.insert(bean));
			
			//test update
//			System.out.println(dao.update("05-05", new SeatAreaDAOHibernate(sessionfactory).select(1)));
			
			//test delete
//			System.out.println(dao.delete("05-05"));
			
			sessionfactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			sessionfactory.getCurrentSession().getTransaction().rollback();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	
	@Override
	public Profe_ClassVO select(Integer Profe_sd) {
		return getSession().get(Profe_ClassVO.class, Profe_sd);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Profe_ClassVO> selectAll() {
		List<Profe_ClassVO> result = getSession().createQuery("SELECT bean FROM Profe_ClassVO bean ")
				.getResultList();
		return result;
	}

	@Override
	public Profe_ClassVO insert(Profe_ClassVO bean) {
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
	public Profe_ClassVO update(Integer profe_sd, ClassVO class_sd, CoachVO coach_acct, java.sql.Timestamp start_time,
			java.sql.Timestamp end_time, Integer class_qty) {
		Profe_ClassVO result = this.select(profe_sd);
		if (result != null) {
			result.setProfe_sd(profe_sd);// 不是實體的東西無法儲存資料。 reference variable:
											// you cannot use this variable
											// because it just doesn't point to
											// anywhere (it is null).
			result.setClassbean(class_sd);// 用vo進行修改
			result.setCoach(coach_acct);// 用vo進行修改
			result.setStart_time(start_time);// Timestamp原本就是java.sql內的類別不轉型。
			result.setEnd_time(end_time);// Timestamp原本就是java.sql內的類別不轉型。
			result.setClass_qty(class_qty);
			getSession().update(result);
		}
		return result;
	}

	@Override
	public boolean delete(String Profe_sd) {
		int result = getSession().createQuery("DELETE FROM Profe_ClassVO WHERE Profe_sd=:Profe_sd")
				.setParameter(0, Profe_sd).executeUpdate();
		if (result > 0) {
			return true;
		} else if (result == 0) {
			return false;
		} else {
			System.err.println("delete fail");
			return false;
		}
	}
}
