package model.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Game_OrderVO;
import model.MemberVO;

public class Game_OrderDAOhibernate implements Game_OrderDAO {
	private SessionFactory sessionFactory;
	public Game_OrderDAOhibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
//	private static final String SELECT_BY_GAME_ORDER = 
//			"select * from Game_Order where game_order_sd = ?";
	@Override
	public Game_OrderVO select(Integer game_order_sd){
		return getSession().get(Game_OrderVO.class, game_order_sd);
	}
	
//	private static final String SELECT_ALL = "select * from Game_Order where Member_acct = ?";
	@Override
	public List<Game_OrderVO> select(String Member_acct) {
		return this.getSession().createQuery("FROM Game_OrderVO where Member_acct=?")
				   .setParameter("Member_acct", Member_acct).getResultList();
	}
	
//	private static final String INSERT =
//			"insert into Game_Order values (?,?)";
	@Override
	public Game_OrderVO insert(Game_OrderVO bean) {
		if(bean!=null){
				this.getSession().save(bean);
				return bean;
			}
		return null;
	}
	
//	private static final String DELETE =
//			"delete from Game_Order where game_order_sd=?";
	@Override
	public boolean delete(Integer game_order_sd) {
		Game_OrderVO bean = this.select(game_order_sd);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
}
