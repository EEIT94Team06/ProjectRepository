package model.dao.test;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.OneOnOne_Class_DetailVO;
import model.dao.OneOnOne_Class_DetailDAO;
import model.dao.OneOnOne_Class_DetailDAOHibernate;
import model.hibernate.HibernateUtil;

public class OneOnOne_Class_DetailDAOTest {
	private Session session;
	private static OneOnOne_Class_DetailVO bean ; //除非寫成new OneOnOne_Class_DetailDAOTest().bean才不需要寫成static
	private OneOnOne_Class_DetailDAO dao ;
	
	@BeforeClass//利用static特性run的時候就載入
	public static SessionFactory getSessionFactory() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		bean = new OneOnOne_Class_DetailVO();

		return HibernateUtil.getSessionFactory();

	}

	@AfterClass
	public static void closeSessionFactory() {
		HibernateUtil.closeSessionFactory();
	}

	@Before
	public Session Session() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		dao = new OneOnOne_Class_DetailDAOHibernate(session);
		return session;

	}

	@After
	public void closeSession() {
		HibernateUtil.getSessionFactory().getCurrentSession().close();
	}

	@Test
	public void testSelect() {
		try {
			session.beginTransaction();
			dao.select("20150520-1");
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
	}

	@Test
	public void testSelectAll() {

	}

	@Test
	public void insert() {

	}

	@Test
	public void delete() {

	}
}
