package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.GameDetailVO;
import model.hibernate.HibernateUtil;

public class GameDetailDAOHibernate implements GameDetailDAO_interface {
	private SessionFactory sessionFactory;

	public GameDetailDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			GameDetailDAO_interface dao = new GameDetailDAOHibernate(HibernateUtil.getSessionFactory());

			// Receive one record
			GameDetailVO gd = dao.select(Integer.valueOf(1));
			System.out.println("Game_Detail: " + gd);

			// Receive all information
			List<GameDetailVO> list = dao.select();
			System.out.println("List: " + list);

			// Add new record
//			GameDetailVO gameDetailVO = new GameDetailVO();
//			gameDetailVO.setGameordersd(Integer.valueOf(10));
//			gameDetailVO.setSeatno("02-19");
//			gameDetailVO.setGamesd(Integer.valueOf(1));
//			GameDetailVO result1 = dao.insert(gameDetailVO);
//			System.out.println("Result(Add): " + result1);

			// Delete a record
			boolean result2 = dao.delete(Integer.valueOf(17));
			System.out.println("Result(Delete): " + result2);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	} // end of main()

	@Override
	public GameDetailVO select(Integer gamedetailsd) {
		return getSession().get(GameDetailVO.class, gamedetailsd);
	}

	@Override
	public List<GameDetailVO> select() {
		return this.getSession().createQuery("FROM GameDetailVO", GameDetailVO.class).getResultList();
	}

	@Override
	public GameDetailVO insert(GameDetailVO gameDetailVO) {
		if (gameDetailVO != null) {
			int result = (int) this.getSession().save(gameDetailVO);
			if (result > 0) {
				return gameDetailVO;
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer gamedetailsd) {
		GameDetailVO gameDetailVO = this.select(gamedetailsd);
		if (gameDetailVO != null) {
			this.getSession().delete(gameDetailVO);
			return true;
		}
		return false;
	}

} // end of class GameDetailJDBCDAO
