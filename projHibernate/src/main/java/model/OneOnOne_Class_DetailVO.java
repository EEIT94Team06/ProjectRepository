package model;

import javax.persistence.*;

@Entity
@Table(name="OneOnOne_Class_Detail")
public class OneOnOne_Class_DetailVO {
	@Id
	private String ooo_c_detail_sd;			//	ooo_c_detail  varchar(50) Primary key,
	@ManyToOne(targetEntity = Class_OrderVO.class)
	@JoinColumn(name="class_order_sd")
	private Class_OrderVO class_Order;	//	class_order_sd int FOREIGN KEY REFERENCES class_order(class_order_sd),
	@ManyToOne
	@JoinColumn(name="coach_acct")
	private CoachVO coachVO;				//	coach_acct varchar(50) FOREIGN KEY REFERENCES Coach(coach_acct),
	private java.sql.Timestamp ooo_start; 	//	ooo_start datetime,
	private java.sql.Timestamp ooo_end;		//	ooo_end datetime
	
	
	@Override
	public String toString() {
		return "OneOnOne_Class_DetailVO [ooo_c_detail_sd=" + ooo_c_detail_sd + ", class_Order=" + class_Order
				+ ", coachVO=" + coachVO + ", ooo_start=" + ooo_start + ", ooo_end=" + ooo_end + "]";
	}
	public String getOoo_c_detail_sd() {
		return ooo_c_detail_sd;
	}
	public void setOoo_c_detail_sd(String ooo_c_detail_sd) {
		this.ooo_c_detail_sd = ooo_c_detail_sd;
	}
	public Class_OrderVO getClass_Order() {
		return class_Order;
	}
	public void setClass_Order(Class_OrderVO class_Order) {
		this.class_Order = class_Order;
	}
	public CoachVO getCoachVO() {
		return coachVO;
	}
	public void setCoachVO(CoachVO coachVO) {
		this.coachVO = coachVO;
	}
	public java.sql.Timestamp getOoo_start() {
		return ooo_start;
	}
	public void setOoo_start(java.sql.Timestamp ooo_start) {
		this.ooo_start = ooo_start;
	}
	public java.sql.Timestamp getOoo_end() {
		return ooo_end;
	}
	public void setOoo_end(java.sql.Timestamp ooo_end) {
		this.ooo_end = ooo_end;
	}
	
		
}
