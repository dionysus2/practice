package dionysus.wine.daoimpl;

import java.sql.*;
import java.util.*;

import dionysus.wine.dao.*;
import dionysus.wine.vo.*;

public class WineSellerAthorizationDaoImpl implements WineSellerAuthorizationDAO{

	
	//1. 와인회사 업주 회원신청 리스트 조회
	@Override
	public ArrayList<WineSellerAuthorization> selectWineSellerAuthozationAllList(Connection conn, int startRow, int lastRow)
			throws SQLException {
		return null;
	}
	//2. 와인회사 업주 회원신청자 count
	@Override
	public int wineSellerAuthorization(Connection conn) throws SQLException {
		return 0;
	}
	//3. 와인회사 업주 회원신청자 추가
	@Override
	public WineSellerAuthorization insertWineSellerAuthorization(Connection conn, WineSellerAuthorization wineSellerAuthorization) throws SQLException {
		return null;
	}
	//4.와인회사 업주 회원신청자 삭제
	@Override
	public int deleteWineSellerAuthorization(Connection conn, int wineSellerAuthorizationId) throws SQLException {
		return 0;
	}
	//5. 와인회사 업주 회원신청자 승인
	@Override
	public int yesWineSellerAuthorizated(Connection conn, int wineSellerAuthorizationId) throws SQLException {
		return 0;
	}
	//6. 와인회사 업주 회원 신청자 비활성화 속성 1로 변경
	@Override
	public int selectWineSellerAuthorization(Connection conn, int wineSellerAuthorizationId) throws SQLException {
		return 0;
	}

}
