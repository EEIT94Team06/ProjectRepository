package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.SeatAreaVO;
import model.hibernate.HibernateUtil;

public class SeatAreaDAOHibernate implements SeatAreaDAO_interface {
	private SessionFactory sessionFactory;

	public SeatAreaDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			SeatAreaDAO_interface dao = new SeatAreaDAOHibernate(HibernateUtil.getSessionFactory());

			// Receive information via selected administrator accounts
			SeatAreaVO sa = dao.select(Integer.valueOf(1));
			System.out.println("Seat_area: " + sa);

			// Receive all information
			List<SeatAreaVO> list = dao.select();
			System.out.println("List: " + list);

			// Add new record
//			SeatAreaVO seatAreaVO = new SeatAreaVO();
//			seatAreaVO.setSeatarea(Integer.valueOf(6));
//			seatAreaVO.setSeatprice(Integer.valueOf(250));
//			SeatAreaVO result1 = dao.insert(seatAreaVO);
//			System.out.println("Result(Add): " + result1);

			// Update old record
			SeatAreaVO result2 = dao.update(Integer.valueOf(2500), Integer.valueOf(1));
			System.out.println("Result(Update): " + result2);

			// Delete a record
			boolean result3 = dao.delete(Integer.valueOf(6));
			System.out.println("Result(Delete): " + result3);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	} // end of main()

	@Override
	public SeatAreaVO select(Integer seatarea) {
		return getSession().get(SeatAreaVO.class, seatarea);
	}

	@Override
	public List<SeatAreaVO> select() {
		return this.getSession().createQuery("FROM SeatAreaVO", SeatAreaVO.class).getResultList();
	}

	@Override
	public SeatAreaVO insert(SeatAreaVO seatAreaVO) {
		if (seatAreaVO != null) {
			SeatAreaVO select = this.select(seatAreaVO.getSeat_area());
			if (select == null) {
				this.getSession().save(seatAreaVO);
				return seatAreaVO;
			}
		}
		return null;
	}

	@Override
	public SeatAreaVO update(Integer seatprice, Integer seatarea) {
		SeatAreaVO seatAreaVO = this.select(seatarea);
		if (seatAreaVO != null) {
			seatAreaVO.setSeat_price(seatprice);
		}
		return seatAreaVO;
	}

	@Override
	public boolean delete(Integer seatarea) {
		SeatAreaVO seatAreaVO = this.select(seatarea);
		if (seatAreaVO != null) {
			this.getSession().delete(seatAreaVO);
			return true;
		}
		return false;
	}

} // end of class SeatAreaJDBCDAO
