package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.SeatAreaVO;
import model.SeatVO;
import model.hibernate.HibernateUtil;

public class SeatDAOHibernate implements SeatDAO {
	// 為了確保Session失效是dao能夠再造出session來使用，建構子改用SessionFactory
	private SessionFactory sessionfactory;

	public SeatDAOHibernate( SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public Session getSession() {
		return sessionfactory.getCurrentSession();// return屬性session
	}

	public static void main(String[] args) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		SeatDAO dao = new SeatDAOHibernate(sessionfactory);
		try {
			sessionfactory.getCurrentSession().beginTransaction();

			sessionfactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			sessionfactory.getCurrentSession().getTransaction().rollback();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	
	@Override
	public SeatVO select(String seat_no) {
		return getSession().get(SeatVO.class, seat_no);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SeatVO> selectAll() {
		List<SeatVO> result = getSession().createQuery("SELECT bean FROM SeatVO bean").getResultList();
		return result;
	}

	@Override
	public SeatVO insert(SeatVO bean) {
		SeatVO result = null;
		if(bean != null){
			SeatVO context = this.select(bean.getSeat_no());
			if(context == null){
				getSession().save(bean);
				return bean;
			}
		}
		return result;
	}

	@Override
	public SeatVO update(String seat_no, SeatAreaVO seat_area ) {
		SeatVO result = this.select(seat_no);
		if(result != null){
			result.setSeat_no(seat_no);//不是實體的東西無法儲存資料。 reference variable: you cannot use this variable because it just doesn't point to anywhere (it is null).
			result.setSeatArea(seat_area);//用vo進行修改
			getSession().update(result);
		}
		return result;
	}

	
	@Override
	public boolean delete(String seat_no) {
		int result = getSession().createQuery("DELETE FROM SeatVO WHERE seat_no=:seat_no")
				.setParameter(0, seat_no).executeUpdate();
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
