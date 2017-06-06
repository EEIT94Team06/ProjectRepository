package model.dao;

import model.AdminVO;

public interface AdminDAO_interface {

	AdminVO select(Integer adminacct);

	AdminVO insert(AdminVO adminVO);

	boolean update(String adminname, String pw, Integer adminacct);

}

