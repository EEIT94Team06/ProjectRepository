package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Class_Order")
public class Class_OrderVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer class_order_sd;
	@ManyToOne
	@JoinColumn(name="class_sd")
	private ClassVO classSd;//hibernate使用的方法是同名的getter和setter
	@ManyToOne
	@JoinColumn(name="Member_acct")
	private MemberVO memberAcct;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="class_order_sd")
	private List<Profe_Class_DetailVO> profe_class_details;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="class_order_sd")
	private List<OneOnOne_Class_DetailVO> oneonone_class_details;
	
	
	public List<Profe_Class_DetailVO> getProfe_class_details() {
		return profe_class_details;
	}
	@Override
	public String toString() {
		return "Class_OrderVO [class_order_sd=" + class_order_sd + ", classSd=" + classSd + ", memberAcct=" + memberAcct
				+ "]";
	}
	public void setProfe_class_details(List<Profe_Class_DetailVO> profe_class_details) {
		this.profe_class_details = profe_class_details;
	}
	public Integer getClass_order_sd() {
		return class_order_sd;
	}
	public void setClass_order_sd(Integer class_order_sd) {
		this.class_order_sd = class_order_sd;
	}
	public ClassVO getClassSd() {
		return classSd;
	}
	public void setClassSd(ClassVO classSd) {
		this.classSd = classSd;
	}
	public MemberVO getMemberAcct() {
		return memberAcct;
	}
	public void setMemberAcct(MemberVO memberAcct) {
		this.memberAcct = memberAcct;
	}
	public List<OneOnOne_Class_DetailVO> getOneonone_class_details() {
		return oneonone_class_details;
	}
	public void setOneonone_class_details(List<OneOnOne_Class_DetailVO> oneonone_class_details) {
		this.oneonone_class_details = oneonone_class_details;
	}

	
	
}
