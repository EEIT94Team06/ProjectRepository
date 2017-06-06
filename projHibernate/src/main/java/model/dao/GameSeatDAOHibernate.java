package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.GameSeatVO;
import model.GameVO;
import model.SeatVO;
import model.hibernate.HibernateUtil;

public class GameSeatDAOHibernate implements GameSeatDAO_interface {
	private SessionFactory sessionFactory;

	public GameSeatDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			GameSeatDAO_interface dao = new GameSeatDAOHibernate(HibernateUtil.getSessionFactory());

			// Receive one record
			GameSeatVO gs = dao.select(Integer.valueOf(1));
			System.out.println("Game_seat: " + gs);

			// Receive all information
			List<GameSeatVO> list = dao.select();
			System.out.println("List: " + list);

			// Add new record
//			GameSeatVO gameSeatVO = new GameSeatVO();
//			gameSeatVO.setGamesd(Integer.valueOf(1));
//			gameSeatVO.setSeatno("01-01");
//			gameSeatVO.setSold(true);
//			GameSeatVO result1 = dao.insert(gameSeatVO);
//			System.out.println("Result(Add): " + result1);

			// Update old record
//			GameSeatVO result2 = dao.update(Integer.valueOf(1), "01-01", false, Integer.valueOf(23));
//			System.out.println("Result(Update): " + result2);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	} // end of main()

	@Override
	public GameSeatVO select(Integer gameseatsd) {
		return getSession().get(GameSeatVO.class, gameseatsd);
	}

	@Override
	public List<GameSeatVO> select() {
		return this.getSession().createQuery("FROM GameSeatVO", GameSeatVO.class).getResultList();
	}

	@Override
	public GameSeatVO insert(GameSeatVO gameSeatVO) {
		if (gameSeatVO != null) {
			int result = (int) this.getSession().save(gameSeatVO);
			if (result > 0) {
				return gameSeatVO;
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public GameSeatVO update(GameVO gamesd, SeatVO seatno, Boolean sold, Integer gameseatsd) {
		GameSeatVO gameSeatVO = this.select(gameseatsd);
		if (gameSeatVO != null) {
			gameSeatVO.setGame(gamesd);
			gameSeatVO.setSeat(seatno);
			gameSeatVO.setSold(sold);
		}
		return gameSeatVO;
	}

} // end of class GameSeatJDBCDAO
