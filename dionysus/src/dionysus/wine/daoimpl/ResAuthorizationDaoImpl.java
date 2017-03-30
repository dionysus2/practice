package dionysus.wine.daoimpl;

import java.sql.*;
import java.util.*;

import dionysus.wine.dao.*;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.*;

public class ResAuthorizationDaoImpl implements ResAuthorizationDAO {
	
	//1. 레스토랑 업주 회원신청 리스트 조회
	@Override
	public ArrayList<ResAuthorization> selectResAuthorizitionAllList(Connection conn, int startRow, int lastRow)throws SQLException {
		String Sql ="select r2.*from(select rownum rnum, r1.* from "
				+ "(select res_id, res_authorization_date,res_authorizated "
				+ "from res_authorization)r1)r2 where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ResAuthorization> list = new ArrayList<>();
		ResAuthorization res = new ResAuthorization();
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			rs = pstmt.executeQuery();
			while(rs.next()){
				res.setResAuthorizated(rs.getString("res_authorizated"));
				res.setResAuthorizationDate(rs.getDate("res_authorization_date"));
				res.setResId(rs.getInt("res_id"));
				list.add(res);				
			}return list;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, rs);
		}		
		return null;
	}
	//2. 레스토랑 업주 회원신청자 count
	@Override
	public int resauthorization(Connection conn) throws SQLException {
		String Sql = "select count(res_id+1) from res_authorization";
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
	//3. 레스토랑 업주 회원신청자 추가
	@Override
	public int insertResauthorization(Connection conn, ResAuthorization resauthorization){
	String Sql = "insert into res_authorization(res_id,res_authorization_date, "
			+ "res_authorizated)values(?,?,'승인신청중')";
	PreparedStatement pstmt = null;
	try{
		pstmt = conn.prepareStatement(Sql);
		pstmt.setInt(1, resauthorization.getResId());
		pstmt.setDate(2, resauthorization.getResAuthorizationDate());
		return pstmt.executeUpdate();		
	
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		JDBCUtil.close(pstmt, null);
	}	
	return 0;
}
	//4.레스토랑 업주 회원신청자 삭제
	@Override
	public int deleteResauthorization(Connection conn, int resAuthorizationId) throws SQLException {
		String Sql = "delete from res_authorization where res_id=?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, resAuthorizationId);
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, null);
		}	
		return 0;
	}
	//5. 레스토랑 업주 회원신청자 승인
	@Override
	public int yesResAuthorizated(Connection conn, int resAuthorizationId) throws SQLException {
		String Sql ="update res_authorization "
				+ "set res_authorizated = '승인완료' "
				+ "where res_id=?";
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, resAuthorizationId);
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, null);
		}	
		return 0;
	}
	//6. 레스토랑 업주 회원 신청자 비활성화 속성 1로 변경
	//@Override
//	public int selectResauthorization(Connection conn, int resAuthorizationId) throws SQLException {
//		return 0;
//	}

}
