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
@Table(name="Profe_Class")
public class Profe_ClassVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Profe_sd;					//	Profe_sd int identity Primary key,
	@ManyToOne
	@JoinColumn(name="class_sd")
	private ClassVO classbean;					//	class_sd int FOREIGN KEY REFERENCES Class(class_sd),
	@ManyToOne
	@JoinColumn(name="coach_acct")
	private CoachVO coach;				//	coach_acct varchar(50) FOREIGN KEY REFERENCES Coach(coach_acct),
	private java.sql.Timestamp start_time;	//	start_time datetime,
	private java.sql.Timestamp end_time;	//	end_time datetime,
	private int Class_qty;					//	Class_qty int,
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Profe_sd")
	private List<Profe_Class_DetailVO> profe_class_details;
	
	@Override
	public String toString() {
		return "Profe_ClassVO [Profe_sd=" + Profe_sd + ", classbean=" + classbean + ", coach=" + coach + ", start_time="
				+ start_time + ", end_time=" + end_time + ", Class_qty=" + Class_qty +"]";
	}
	public int getProfe_sd() {
		return Profe_sd;
	}
	public void setProfe_sd(int profe_sd) {
		Profe_sd = profe_sd;
	}
	public ClassVO getClassbean() {
		return classbean;
	}
	public void setClassbean(ClassVO classbean) {
		this.classbean = classbean;
	}
	public CoachVO getCoach() {
		return coach;
	}
	public void setCoach(CoachVO coach) {
		this.coach = coach;
	}
	public java.sql.Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(java.sql.Timestamp start_time) {
		this.start_time = start_time;
	}
	public java.sql.Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(java.sql.Timestamp end_time) {
		this.end_time = end_time;
	}
	public int getClass_qty() {
		return Class_qty;
	}
	public void setClass_qty(int class_qty) {
		Class_qty = class_qty;
	}
	public List<Profe_Class_DetailVO> getProfe_class_details() {
		return profe_class_details;
	}
	public void setProfe_class_details(List<Profe_Class_DetailVO> profe_class_details) {
		this.profe_class_details = profe_class_details;
	}

	
}
