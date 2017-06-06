package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.AdminVO;
import model.hibernate.HibernateUtil;

public class AdminDAOHibernate implements AdminDAO_interface {
	private SessionFactory sessionFactory;

	public AdminDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			AdminDAO_interface dao = new AdminDAOHibernate(HibernateUtil.getSessionFactory());

			// Receive information via an administrator account
			AdminVO admin = dao.select(Integer.valueOf(20411));
			System.out.println("Administrator: " + admin);

			// Add new record
			AdminVO adminVO = new AdminVO();
			adminVO.setAdminacct(Integer.valueOf(20421));
			adminVO.setPw("883jobs");
			adminVO.setAdminname("賈伯斯");
			AdminVO result1 = dao.insert(adminVO);
			System.out.println("Result(Add): " + result1);

			// Update old record
			boolean result2 = dao.update("Benedict Cumberbatch", "98765ghiied", Integer.valueOf(20411));
			System.out.println("Result: " + result2);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	} // end of main()

	@Override
	public AdminVO select(Integer adminacct) {
		return getSession().get(AdminVO.class, adminacct);
	}

	@Override
	public AdminVO insert(AdminVO adminVO) {
		if (adminVO != null) {
			AdminVO select = this.select(adminVO.getAdminacct());
			if (select == null) {
				this.getSession().save(adminVO);
				return adminVO;
			}
		}
		return null;
	}

	@Override
	public boolean update(String adminname, String pw, Integer adminacct) {
		AdminVO adminVO = this.select(adminacct);
		if (adminVO != null) {
			adminVO.setAdminname(adminname);
			adminVO.setPw(pw);
		}
		return false;
	}

} // end of class AdminJDBCDAO
