package model.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import model.OneOnOne_Class_DetailVO;
import model.hibernate.HibernateUtil;
//任務一：實作CRUD功能
//任務二：降低使用資料庫的次數但達到相同效果，提高程式效能。
public class OneOnOne_Class_DetailDAOHibernate implements OneOnOne_Class_DetailDAO {
	// 為了確保Session失效是dao能夠再造出session來使用，建構子改用SessionFactory
	private SessionFactory sessionfactory;

	public OneOnOne_Class_DetailDAOHibernate( SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public Session getSession() {
		return sessionfactory.getCurrentSession();// return屬性session
	}

	public static void main(String[] args) {
		OneOnOne_Class_DetailVO bean = new OneOnOne_Class_DetailVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
			OneOnOne_Class_DetailDAO dao = new OneOnOne_Class_DetailDAOHibernate(sessionfactory);
			// session.getTransaction().begin();
			//test select
//			 System.out.println(dao.select("20150520-1"));
			
			//test select all
//			List<Object[]> list = (ArrayList<Object[]>) dao.selectAll(2);
//			System.out.println("111");
//			for(Object[] array:list){
//				System.out.print(array[0]+",");	
//				System.out.print(array[1]+",");
//				System.out.print(array[2]+",");
//				System.out.print(array[3]+",");
//				System.out.println(array[4]);
//			}		
//			List<OneOnOne_Class_DetailVO> list = (ArrayList<OneOnOne_Class_DetailVO>) dao.selectAll(2);
//			System.out.println("111");
//			for(OneOnOne_Class_DetailVO array:list){
//				System.out.print(array.getOoo_c_detail_sd()+",");	
//				System.out.print(array.getClass_order_sd()+",");
//				System.out.print(array.getCoach_acct()+",");
//				System.out.print(array.getOoo_start()+",");
//				System.out.println(array.getOoo_end());
//			}
			System.out.println(dao.selectAll(10));
//			List<OneOnOne_Class_DetailVO> list = dao.selectAll(3);
//			for(OneOnOne_Class_DetailVO array:list){
//				System.out.println(array);
//			}
			
			//test insert
//			 bean.setOoo_c_detail_sd("20150520-2");
//			 bean.setClass_order_sd(2);
//			 bean.setCoach_acct("alex");
//			 bean.setOoo_start(new
//			 Timestamp(sdf.parse("2000/02/21").getTime()));
//			 bean.setOoo_end(new
//			 Timestamp(sdf.parse("2000/03/20").getTime()));
//			 System.out.println(dao.insert(bean));
			
			//test delete
//			 dao.delete("20170602-8");
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			// session.getTransaction().commit();//使用getCurrentSession()此時session就close了
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
		} finally {
			HibernateUtil.closeSessionFactory();// 記得關sessionFactory，不然會process會一直開著
		}
	}


	@Override
	public OneOnOne_Class_DetailVO select(String ooo_c_detail_sd) {
		return getSession().get(OneOnOne_Class_DetailVO.class, ooo_c_detail_sd);// 可以省略this
	}

	@Override
	@SuppressWarnings("unchecked")//無法在回傳值上加入泛型，所以jvm提醒我們要小心。
	public List<OneOnOne_Class_DetailVO> selectAll(Integer class_order_sd) {
		// return getSession().createQuery("FROM OneOnOne_Class_Detail",
		// OneOnOne_Class_DetailVO.class).list();//"or".getResultList();
		//方法1
//		Query query = getSession().createQuery(
//				"select ooo_c_detail_sd,class_order_sd,coach_acct ,ooo_start,ooo_end"
//				+ " from OneOnOne_Class_DetailVO "
//				+ " where class_order_sd =?");
//		return (ArrayList<Object[]>)query.setParameter(0,class_order_sd).getResultList();
		//方法2
		Query query = getSession().createQuery(
				"select bean"//從 OneOnOne_Class_DetailVO實體 中取出bean(就是他自己)//如果這裡又寫OneOnOne_Class_DetailVO他會表示沒辦法從bean中取出 另一個OneOnOne_Class_DetailVO的實體，而且想想也是這樣。
				+ " from OneOnOne_Class_DetailVO bean"//等於new OneOnOne_Class_DetailVO實體 取變數名稱bean
				+ " where class_order_sd =?");
		return (ArrayList<OneOnOne_Class_DetailVO>)query.setParameter(0,class_order_sd).getResultList();
	}

	@Override
	public OneOnOne_Class_DetailVO insert(OneOnOne_Class_DetailVO bean) {
		OneOnOne_Class_DetailVO result = null;
		// 不用store Procedule 和CallableStatement stmt =
		// connection.preparedCall("{call procedureName(?,?)}")
		// Connection.preparedCall很昂貴。
		// https://docs.oracle.com/cd/E17952_01/connector-j-en/connector-j-usagenotes-statements-callable.html
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String pkPrefix = sdf2.format(new Date());
//  v3		
		ArrayList<?> list = (ArrayList<?>) getSession().createQuery("SELECT count(*) from OneOnOne_Class_DetailVO").getResultList();
		long rCount = (long)list.get(0);
//	v2	long rCount = (long) getSession().createQuery("SELECT count(*) from OneOnOne_Class_DetailVO").getSingleResult();//getResultList()
//	v1	long rCount = (long) getSession().createCriteria(OneOnOne_Class_DetailVO.class)
//				.setProjection(Projections.rowCount()).uniqueResult();// 測試可用但已經過時

		if (bean != null) {
			bean.setOoo_c_detail_sd(pkPrefix + "-" + String.valueOf(rCount + 1));
			OneOnOne_Class_DetailVO context = this.select(bean.getOoo_c_detail_sd());
			System.out.println(context);
			if (context == null) {// 如果id不存在。
				getSession().save(bean);
				result = bean;
			}
		}
		return result;
	}

	@Override
	public boolean delete(String ooo_c_detail_sd) {
//		boolean flag = false;// 旗標作法
//		OneOnOne_Class_DetailVO bean = this.select(ooo_c_detail_sd);
//		if (bean != null) {
//			getSession().delete(bean);
//			flag = true;
//		}
//		return flag;
		//只送出一次delete指令提高效能
		int result = getSession().createQuery("DELETE FROM OneOnOne_Class_DetailVO "
						+ " WHERE ooo_c_detail_sd =?").setParameter(0, ooo_c_detail_sd).executeUpdate();//新刪修記得executeUpdate
		if(result>0){
			return true;
		}else if(result==0){
			return false;
		}else{
			System.err.println("delete failed");
			return false;
		}
		
	}
}
