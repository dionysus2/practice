package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dionysus.wine.dao.ResReservInfoDAO;
import dionysus.wine.query.ResResrvInfoQuery;
import dionysus.wine.query.ResReviewQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.ResReserv;
import dionysus.wine.vo.ResResevInfo;

public class ResResrvInfoDaoImpl implements ResReservInfoDAO {
	
	
//  예약추가	
	@Override
	public int insertResReservInfo(Connection conn, int resInfoId, int resReservId, int resResrvInfoBookingSeats)
			throws Exception {
	   PreparedStatement pstmt = null;
	   try{
		   pstmt = conn.prepareStatement(ResResrvInfoQuery.insert);
		   pstmt.setInt(1, resInfoId);
		   pstmt.setInt(2, resReservId);
		   pstmt.setInt(3, resResrvInfoBookingSeats);
		   return pstmt.executeUpdate();
	   }catch (SQLException e) {
   	   throw e;
	   }finally{
	   JDBCUtil.close(pstmt,null);
	   }
	 
	}
//  예약삭제
	@Override
	public int deleteResReservInfo(Connection conn, int resReservId, int resInfoId) throws Exception {
		   PreparedStatement pstmt = null;
		   try{
			   pstmt = conn.prepareStatement(ResResrvInfoQuery.delete);
			   pstmt.setInt(1, resReservId);
			   pstmt.setInt(2, resInfoId);
			   return pstmt.executeUpdate();
		   }catch (SQLException e) {
	   	   throw e;
		   }finally{
		   JDBCUtil.close(pstmt,null);
		   }
		}
//  예약변경
	@Override
	public int updateResReservInfo(Connection conn, int resInfoId, int resReservId, int resResrvInfoBookingSeats)
			throws Exception {
		   PreparedStatement pstmt = null;
		   try{
			   pstmt = conn.prepareStatement(ResResrvInfoQuery.update);
			   pstmt.setInt(1, resReservId);
			   pstmt.setInt(2, resResrvInfoBookingSeats);
			   pstmt.setInt(3, resInfoId);
			   return pstmt.executeUpdate();
		   }catch (SQLException e) {
	   	   throw e;
		   }finally{
		   JDBCUtil.close(pstmt,null);
		   }
		}
}
