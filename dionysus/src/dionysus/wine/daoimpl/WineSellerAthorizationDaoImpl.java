package dionysus.wine.daoimpl;

import java.sql.*;
import java.util.*;

import dionysus.wine.dao.*;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.*;

public class WineSellerAthorizationDaoImpl implements WineSellerAuthorizationDAO{

	
	//1. 와인회사 업주 회원신청 리스트 조회
	@Override
	public ArrayList<WineSellerAuthorization> selectWineSellerAuthozationAllList(Connection conn, int startRow, int lastRow)
			throws SQLException {
		String Sql ="select r2.*from(select rownum rnum, r1.* from "
				+ "(select wine_seller_id, wine_seller_authorization_date,wine_seller_authorizated "
				+ "from wine_seller_authorization)r1)r2 where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WineSellerAuthorization> list = new ArrayList<>();
		WineSellerAuthorization wine = new WineSellerAuthorization();
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			rs = pstmt.executeQuery();
			while(rs.next()){
				wine.setWineSellerAuthorizated(rs.getString("wine_seller_authorizated"));
				wine.setWineSellerAuthorizationDate(rs.getDate("wine_seller_authorization_date"));
				wine.setWineSellerId(rs.getInt("wine_seller_id"));
				list.add(wine);				
			}return list;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, rs);
		}		
		return null;
	}
	//2. 와인회사 업주 회원신청자 count
	@Override
	public int wineSellerAuthorization(Connection conn) throws SQLException {
		String Sql = "select count(wine_seller_id) from wine_seller_authorization";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(Sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, rs);
		}		
		return 0;
	}
	//3. 와인회사 업주 회원신청자 추가
	@Override
	public int insertWineSellerAuthorization(Connection conn, WineSellerAuthorization wineSellerAuthorization) throws SQLException {
		String Sql = "insert into wine_seller_authorization(wine_seller_id,wine_seller_authorization_date, "
				+ "wine_seller_authorizated)values(res_seq.nextval,?,'승인신청중')";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, wineSellerAuthorization.getWineSellerId());
			pstmt.setDate(2, wineSellerAuthorization.getWineSellerAuthorizationDate());
			return pstmt.executeUpdate();		
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, null);
		}	
		return 0;
	}
	//4.와인회사 업주 회원신청자 삭제
	@Override
	public int deleteWineSellerAuthorization(Connection conn, int wineSellerAuthorizationId) throws SQLException {
		String Sql = "delete from wine_seller_authorization where wine_seller_id=?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, wineSellerAuthorizationId);
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, null);
		}	
		return 0;
	}
	//5. 와인회사 업주 회원신청자 승인
	@Override
	public int yesWineSellerAuthorizated(Connection conn, int wineSellerAuthorizationId) throws SQLException {
		String Sql ="update wine_seller_authorization "
				+ "set wine_seller_authorizated = '승인완료' "
				+ "where wine_seller_id=?";
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, wineSellerAuthorizationId);
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, null);
		}	
		return 0;
	}
	//6. 와인회사 업주 회원 신청자 비활성화 속성 0로 변경
	//@Override
	//public int selectWineSellerAuthorization(Connection conn, int wineSellerAuthorizationId) throws SQLException {
	//	return 0;
//	}

}
