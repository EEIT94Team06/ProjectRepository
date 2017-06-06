package model.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.GameVO;

public class GameDAOhibernate implements GameDAO {
	private SessionFactory sessionFactory;
	public GameDAOhibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
//	private static final String SELECT_BY_ID =
//			"select * from Game where game_sd=?";
	@Override
	public GameVO select(Integer game_sd) {
		return getSession().get(GameVO.class,game_sd);
	}
	
//	private static final String SELECT_ALL =
//			"select * from Game";
	@Override
	public List<GameVO> select() {
		return this.getSession().createQuery("FROM Game",GameVO.class).getResultList();
	}
	
//	private static final String INSERT =
//			"insert into Game values(?,?)";
	@Override
	public GameVO insert(GameVO bean) {
		if(bean!=null){
				this.getSession().save(bean);
				return bean;
			}
		return null;
	}
	
	
//	private static final String UPDATE =
//			"update Game set game_name=?, game_time=? where game_sd=?";
	@Override
	public GameVO update(String game_name,
			java.util.Date game_time, Integer game_sd) {
		GameVO bean = this.select(game_sd);
		if(bean!=null){
			bean.setGame_name(game_name);
			bean.setGame_time(game_time);
		}
		return bean;
	}
	
//	private static final String DELETE =
//			"delete from Game where game_sd=?";
	@Override
	public boolean delete(Integer game_sd) {
		GameVO bean = this.select(game_sd);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
}
