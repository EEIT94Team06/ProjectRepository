package model.dao;

import java.util.List;

import org.hibernate.Session;

import model.MemberVO;

public interface MemberDAO {

	Session getSession();

	MemberVO select(String acct);

	List<MemberVO> select();

	MemberVO insert(MemberVO bean);

	MemberVO update(String Member_acct, String pw, String member_name, String addr, java.util.Date b_d, String email,
			Integer sex, String tel);

	boolean delete(String acct);

}