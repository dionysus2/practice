package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;

import dionysus.wine.vo.BasicInfo;

public interface BasicInfoDAO {
	/*
	 * 	1. 추가
	 * 	2. 삭제
	 * 	3. 비밀번호, 이메일 수정
	 * 	4. 아이디 찾기
	 * 	5. 비밀번호 찾기
	 * 	6. 이메일 찾기
	 * 	7. 로그인
	 * 	8. 아이디 중복확인
	 * */
	public int basicInfoInsert(Connection conn, BasicInfo basicinfo)throws SQLException;
	public int basicInfoDelete(Connection conn, int basicinfoid)throws SQLException;
	public int basicInfoUpdate(Connection conn, BasicInfo basicinfo)throws SQLException;
	public BasicInfo selectByBasicInfoUserName(Connection conn, String basicInfoEmail)throws SQLException;
	public BasicInfo selectByBasicInfoPwd(Connection conn, String basicInfoEmail)throws SQLException;
	public int Login(Connection conn, String basicInfoUserName, String basicInfoPwd)throws SQLException;
	public int basicInfoUserNameCheck(Connection conn, String basicInfoUserName)throws SQLException;
}
