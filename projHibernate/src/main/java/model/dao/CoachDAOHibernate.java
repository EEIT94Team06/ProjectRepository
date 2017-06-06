package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.CoachVO;
import model.hibernate.HibernateUtil;

public class CoachDAOHibernate implements CoachDAO_interface {
	private SessionFactory sessionFactory;

	public CoachDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			CoachDAO_interface dao = new CoachDAOHibernate(HibernateUtil.getSessionFactory());

			// Receive information via a coach account
			CoachVO coach = dao.select("coach666");
			System.out.println("Coach: " + coach);

			// Add new record
//			CoachVO coachVO = new CoachVO();
//			coachVO.setCoachacct("coach681");
//			coachVO.setCoachpw("jobs223");
//			coachVO.setCoachname("愛因斯坦");
//			coachVO.setCoachtel("02-23647821");
//			coachVO.setCoachemail("anass@c.nut.emailfake.nut");
//			CoachVO result1 = dao.insert(coachVO);
//			System.out.println("Result(Add): " + result1);

			// Update old record
			boolean result2 = dao.update("psf9829we", "Elizabeth", "0988329543", "jessica_59513@hotmail.com",
					"coach666");
			System.out.println("Result: " + result2);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	} // end of main()

	@Override
	public CoachVO select(String coachacct) {
		return getSession().get(CoachVO.class, coachacct);
	}

	@Override
	public CoachVO insert(CoachVO coachVO) {
		if (coachVO != null) {
			CoachVO select = this.select(coachVO.getCoach_acct());
			if (select == null) {
				this.getSession().save(coachVO);
				return coachVO;
			}
		}
		return null;
	}

	@Override
	public boolean update(String coachpw, String coachname, String coachtel, String coachemail, String coachacct) {
		CoachVO coachVO = this.select(coachacct);
		if (coachVO != null) {
			coachVO.setCoach_pw(coachpw);
			coachVO.setCoach_name(coachname);
			coachVO.setCoach_tel(coachtel);
			coachVO.setCoachemail(coachemail);
		}
		return false;
	}

} // end of class CoachJDBCDAO
