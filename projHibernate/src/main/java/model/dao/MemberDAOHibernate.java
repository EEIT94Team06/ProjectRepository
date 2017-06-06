package model.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.MemberVO;
import model.hibernate.HibernateUtil;

public class MemberDAOHibernate implements MemberDAO {
	// 為了確保Session失效是dao能夠再造出session來使用，建構子改用SessionFactory
	private SessionFactory sessionfactory;

	public MemberDAOHibernate( SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public Session getSession() {
		return sessionfactory.getCurrentSession();// return屬性session
	}

	public static void main(String[] args) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		MemberDAO dao = new MemberDAOHibernate(sessionfactory);
		MemberVO bean = new MemberVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			sessionfactory.getCurrentSession().beginTransaction();
			// test select
			// System.out.println(dao.select("alan001"));

			// test select all
			// List<MemberVO> list = dao.select();
			// for(MemberVO array:list){
			// System.out.println(array);
			// }

			// test insert
			// bean.setMember_acct("bil588");
			// bean.setPw("789456");
			// bean.setMember_name("柳彥吉");
			// bean.setEmail("iiiedu9412@iiiemail.com");
			// bean.setAddr("台北市大安區");
			// bean.setSex(1);
			// try {
			// bean.setB_d(sdf.parse("1991/01/01"));
			// } catch (ParseException e) {
			// e.printStackTrace();
			// }
			// bean.setTel("0922123456");
			// dao.insert(bean);

			// test update
			System.out.println(dao.select("alan001"));
			sessionfactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			sessionfactory.getCurrentSession().getTransaction().rollback();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	@Override
	public MemberVO select(String acct) {
		return getSession().get(MemberVO.class, acct);
	}

	@Override
	public List<MemberVO> select() {
		// 藉由Query介面操作->B車 //注意Query.list()與iterator()的不同
		List<MemberVO> result = getSession().createQuery("SELECT bean FROM MemberVO bean").getResultList();
		return result;
	}

	@Override
	public MemberVO insert(MemberVO bean) {
		MemberVO result = null;
		if (bean != null) {
			MemberVO context = this.select(bean.getMember_acct());
			if (context == null) {// 如果id不存在
				getSession().save(bean);
				return bean;
			} else {
				System.out.println(bean.getMember_acct() + "已經存在");
			}
		}
		return result;
	}

	@Override
	public MemberVO update(String Member_acct, String pw, String member_name, String addr, java.util.Date b_d,
			String email, Integer sex, String tel) {
		MemberVO result = this.select(Member_acct);
		if (result != null) {
			result.setMember_acct(Member_acct);
			result.setPw(pw);
			result.setMember_name(member_name);
			result.setEmail(email);
			result.setAddr(addr);
			result.setSex(sex);
			result.setB_d(b_d);
			result.setTel(tel);
			getSession().update(result);
		}
		return result;
	}

	@Override
	public boolean delete(String acct) {
		// boolean flag = false;
		// MemberVO bean = this.select(acct);
		// if(bean!=null){
		// getSession().delete(bean);
		// flag = true;
		// }
		// return flag;
		int result = getSession().createQuery("DELETE FROM MemberVO WHERE Member_acct =?").setParameter(0, acct)
				.executeUpdate();
		if (result > 0) {
			return true;
		} else if (result == 0) {
			return false;
		} else {
			System.err.println("DELETE FAIL");
			return false;
		}
	}
}
