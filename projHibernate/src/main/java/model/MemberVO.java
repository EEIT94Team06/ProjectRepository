package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Member")
public class MemberVO {
	//ctrl+shift+v可以將框起內容s移到console內
	@Id
	private String Member_acct ;//	Member_acct Varchar(50) Primary key,//使用大寫OK?
	private String pw;			//	pw varChar(50),
	private String member_name;	//	member_name nVarchar(10),
	private String email;		//	email varchar(50),
	private String addr;  		//	addr Varchar(50),
	private int sex;			//	sex int,
	@Temporal(TemporalType.DATE)
	private java.util.Date b_d; //	b_d Date,
	private String tel;			//	tel varchar(50),
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_acct")
	private List<Game_OrderVO> game_orders;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_acct")
	private List<Class_OrderVO> class_orders;
	

	@Override
	public String toString() {
		return "MemberVO [Member_acct=" + Member_acct + ", pw=" + pw + ", member_name=" + member_name + ", email="
				+ email + ", addr=" + addr + ", sex=" + sex + ", b_d=" + b_d + ", tel=" + tel + "]";
	}
	public String getMember_acct() {
		return Member_acct;
	}
	public void setMember_acct(String member_acct) {
		Member_acct = member_acct;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public java.util.Date getB_d() {
		return b_d;
	}
	public void setB_d(java.util.Date b_d) {
		this.b_d = b_d;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
		
}
