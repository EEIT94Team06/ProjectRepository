package model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Coach")
public class CoachVO implements java.io.Serializable {
	@Id
	@Column(name="coach_acct")
	private String coach_acct;
	@Column(name="coach_pw")
	private String coach_pw;
	@Column(name="coach_name")
	private String coach_name;
	@Column(name="coach_tel")
	private String coach_tel;
	private String coachemail;
	private Byte[] coachimg;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="coach_acct")
	private List<OneOnOne_Class_DetailVO> oneonone_class_details;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="coach_acct")
	private List<Profe_ClassVO> profe_classes;
	
	
	@Override
	public String toString() {
		return "CoachVO [coach_acct=" + coach_acct + ", coach_pw=" + coach_pw + ", coach_name=" + coach_name
				+ ", coach_tel=" + coach_tel + ", coachemail=" + coachemail + ", coachimg=" + Arrays.toString(coachimg)
				+"]";
	}
	public String getCoach_acct() {
		return coach_acct;
	}
	public void setCoach_acct(String coach_acct) {
		this.coach_acct = coach_acct;
	}
	public String getCoach_pw() {
		return coach_pw;
	}
	public void setCoach_pw(String coach_pw) {
		this.coach_pw = coach_pw;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}
	public String getCoach_tel() {
		return coach_tel;
	}
	public void setCoach_tel(String coach_tel) {
		this.coach_tel = coach_tel;
	}
	public String getCoachemail() {
		return coachemail;
	}
	public void setCoachemail(String coachemail) {
		this.coachemail = coachemail;
	}
	public Byte[] getCoachimg() {
		return coachimg;
	}
	public void setCoachimg(Byte[] coachimg) {
		this.coachimg = coachimg;
	}
	public List<OneOnOne_Class_DetailVO> getOneonone_class_details() {
		return oneonone_class_details;
	}
	public void setOneonone_class_details(List<OneOnOne_Class_DetailVO> oneonone_class_details) {
		this.oneonone_class_details = oneonone_class_details;
	}
	public List<Profe_ClassVO> getProfe_classes() {
		return profe_classes;
	}
	public void setProfe_classes(List<Profe_ClassVO> profe_classes) {
		this.profe_classes = profe_classes;
	}
	
} // end of class CoachVO
