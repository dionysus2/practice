package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.vo.BasicInfo;

public interface BasicInfoDAO {
	/*
	 * 	1. 추가
	 * 	3. 비밀번호, 이메일 수정
	 * 	4. 로그인
	 * 	5. 아이디 중복확인
	 * 	6. basicInfoUsername별 customerId빼오기
	 * */
	public int basicInfoInsert(Connection conn, BasicInfo basicinfo)throws SQLException;
	public int basicInfoUpdate(Connection conn, BasicInfo basicinfo)throws SQLException;
	public int Login(Connection conn, String basicInfoUserName, String basicInfoPwd)throws SQLException;
	public int basicInfoUserNameCheck(Connection conn, String basicInfoUserName)throws SQLException;
	public BasicInfo selectByBasicInfoId(Connection conn, String basicInfoUsername)throws SQLException;
	public int selectByUsernameOfCustomerId(Connection conn, String basicInfoUsername)throws SQLException;
}
