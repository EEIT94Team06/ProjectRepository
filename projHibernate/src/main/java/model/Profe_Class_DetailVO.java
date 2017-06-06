package model;

import javax.persistence.*;

@Entity
@Table(name="Profe_Class_Detail")
public class Profe_Class_DetailVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int profe_c_detail_sd;		//	profe_c_detail_sd int identity Primary key,
	@ManyToOne
	@JoinColumn(name="class_order_sd")
	private Class_OrderVO class_Order;		//	class_order_sd int FOREIGN KEY REFERENCES class_order(class_order_sd),
	@ManyToOne
	@JoinColumn(name="Profe_sd")
	private Profe_ClassVO profe_Class;			//	Profe_sd int FOREIGN KEY REFERENCES Profe_Class(Profe_sd)
	
	
	@Override
	public String toString() {
		return "Profe_Class_DetailVO [profe_c_detail_sd=" + profe_c_detail_sd + ", class_Order=" + class_Order
				+ ", profe_Class=" + profe_Class + "]";
	}
	public int getProfe_c_detail_sd() {
		return profe_c_detail_sd;
	}
	public void setProfe_c_detail_sd(int profe_c_detail_sd) {
		this.profe_c_detail_sd = profe_c_detail_sd;
	}
	public Class_OrderVO getClass_Order() {
		return class_Order;
	}
	public void setClass_Order(Class_OrderVO class_Order) {
		this.class_Order = class_Order;
	}
	public Profe_ClassVO getProfe_Class() {
		return profe_Class;
	}
	public void setProfe_Class(Profe_ClassVO profe_Class) {
		this.profe_Class = profe_Class;
	}
	

}
