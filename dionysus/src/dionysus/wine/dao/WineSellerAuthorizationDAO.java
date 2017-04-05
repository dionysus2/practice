package dionysus.wine.dao;

import java.sql.*;
import java.util.*;

import dionysus.wine.vo.*;

public interface WineSellerAuthorizationDAO {
	/*
	 *	- 와인회사 업주 회원신청 리스트 조회.		리턴								매개변수
	 *	1. 와인회사 업주 회원신청 리스트 조회	ArrayList<WineSellerAuthorization>		Connection
	 *	2. 와인회사 업주 회원신청자 count			int									Connection
	 *	- 와인회사 업주 회원신청자 추가		
	 *	3. 와인회사 업주 회원신청자 추가 			int									Connection, WineSellerAuthorization 				
	 *	- 와인회사 업주 회원신청자 삭제				int									Connection, 와인회사 회원번호
	 * 	와인회사 업주 회원신청 승인.
	 * 4. 와인회사 업주 회원신청자 비활성화 속성 1로 변경.		int							Connection
	 * */
	
	//1. 와인회사 업주 회원신청 리스트 조회
	public ArrayList<WineSellerAuthorization> selectWineSellerAuthorizationAllList(Connection conn, int startRow, int lastRow)throws SQLException;
	
	//2. 와인회사 업주 회원신청자 count
	public int wineSellerAuthorization(Connection conn)throws SQLException;
	
	//3. 와인회사 업주 회원신청자 추가
	public int insertWineSellerAuthorization(Connection conn, WineSellerAuthorization wineSellerAuthorization)throws SQLException;
	
	//4.와인회사 업주 회원신청자 삭제
	public int deleteWineSellerAuthorization(Connection conn, int wineSellerAuthorizationId)throws SQLException;
	
	//5. 와인회사 업주 회원신청자 승인
	public int yesWineSellerAuthorizated(Connection conn, int wineSellerAuthorizationId)throws SQLException;
	
	//6. 와인회사 업주 회원 신청자 비활성화 속성 1로 변경
//	public int selectWineSellerAuthorization(Connection conn, int wineSellerAuthorizationId)throws SQLException;
	
	
	
	
}
