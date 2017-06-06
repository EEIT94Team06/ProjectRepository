package model;

import javax.persistence.*;

@Entity
@Table(name="Admin")
public class AdminVO implements java.io.Serializable {
	@Id
	@Column(name="Admin_acct")
	private Integer adminacct;
	private String pw;
	@Column(name="Admin_name")
	private String adminname;

	@Override
	public String toString() {
		return "AdminVO[" + adminacct + ", " + pw + ", " + adminname + "]";
	}

	public Integer getAdminacct() {
		return adminacct;
	}

	public void setAdminacct(Integer adminacct) {
		this.adminacct = adminacct;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

} // end of class AdminVO
