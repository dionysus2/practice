package dionysus.wine.dao;

import java.sql.*;
import java.util.*;

import dionysus.wine.vo.*;

public interface ResAuthorizationDAO {
	/*
	 *	- 레스토랑 업주 회원신청 리스트 조회.		리턴						매개변수
	 *	1. 레스토랑 업주 회원신청 리스트 조회	ArrayList<ResAuthorization>		Connection
	 *	2. 레스토랑 업주 회원신청자 count			int							Connection
	 *	- 레스토랑 업주 회원신청자 추가		
	 *	3. 레스토랑 업주 회원신청자 추가 			int							Connection, ResAuthorization 				
	 *	- 레스토랑 업주 회원신청자 삭제				int							Connection, 레스토랑 회원번호
	 * 	- 레스토랑 업주 회원신청 승인.
	 * 		4. 레스토랑 업주 회원신청자 비활성화 속성 1로 변경.		int							Connection
	 * */
	
	
	//1. 레스토랑 업주 회원신청 리스트 조회
	public ArrayList<ResAuthorization> selectResAuthorizitionAllList(Connection conn, int startRow, int lastRow)throws SQLException;
	
	//2. 레스토랑 업주 회원신청자 count
	public int resauthorization(Connection conn)throws SQLException;
	
	//3. 레스토랑 업주 회원신청자 추가
	public int insertResauthorization(Connection conn, ResAuthorization resauthorization)throws SQLException;
	
	//4.레스토랑 업주 회원신청자 삭제
	public int deleteResauthorization(Connection conn, int resAuthorizationId)throws SQLException;
	
	//5. 레스토랑 업주 회원신청자 승인
	public int yesWineSellerAuthorizated(Connection conn, int resAuthorizationId)throws SQLException;
	
	//6. 레스토랑 업주 회원 신청자 비활성화 속성 1로 변경
	//public int selectResauthorization(Connection conn, int resAuthorizationId)throws SQLException;
	
	
	
	
	
}
