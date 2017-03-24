package dionysus.wine.daoimpl;

import java.sql.*;
import java.util.*;

import dionysus.wine.dao.*;
import dionysus.wine.vo.*;

public class ResAuthorizationDaoImpl implements ResAuthorizationDAO {
	
	//1. 레스토랑 업주 회원신청 리스트 조회
	@Override
	public ArrayList<ResAuthorization> selectResAuthorizitionAllList(Connection conn, int startRow, int lastRow)
			throws SQLException {
		return null;
	}
	//2. 레스토랑 업주 회원신청자 count
	@Override
	public int resauthorization(Connection conn) throws SQLException {
		return 0;
	}
	//3. 레스토랑 업주 회원신청자 추가
	@Override
	public ResAuthorization insertResauthorization(Connection conn, ResAuthorization resauthorization)
			throws SQLException {
		return null;
	}
	//4.레스토랑 업주 회원신청자 삭제
	@Override
	public int deleteResauthorization(Connection conn, int resAuthorizationId) throws SQLException {
		return 0;
	}
	//5. 레스토랑 업주 회원신청자 승인
	@Override
	public int yesWineSellerAuthorizated(Connection conn, int resAuthorizationId) throws SQLException {
		return 0;
	}
	//6. 레스토랑 업주 회원 신청자 비활성화 속성 1로 변경
	@Override
	public int selectResauthorization(Connection conn, int resAuthorizationId) throws SQLException {
		return 0;
	}

}
