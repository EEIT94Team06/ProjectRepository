package model.dao;

import model.CoachVO;

public interface CoachDAO_interface {

	CoachVO select(String coachacct);

	CoachVO insert(CoachVO coachVO);

	boolean update(String coachpw, String coachname, String coachtel, String coachemail, String coachacct);

}


