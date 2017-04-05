package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.ResReviewDAO;
import dionysus.wine.query.ResInfoQuery;
import dionysus.wine.query.ResReviewQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.ResInfo;
import dionysus.wine.vo.ResReview;
import dionysus.wine.vo.ResReview;
import dionysus.wine.vo.WineReview;

public class ResReviewDaoImpl implements ResReviewDAO {

//  리뷰추가	
	@Override
	public int insertResReview(Connection conn, ResReview resReview) throws Exception {
	
	   PreparedStatement pstmt = null;
	   try{
		   pstmt = conn.prepareStatement(ResReviewQuery.insert);
		   pstmt.setInt(1, resReview.getResReviewId());
		   pstmt.setString(2, resReview.getResReviewContent());
		   pstmt.setInt(3, resReview.getResReviewRatings());
		   pstmt.setInt(4, resReview.getResInfoId());
		   pstmt.setInt(5, resReview.getCustomerId());
		   return pstmt.executeUpdate();
	   }catch (SQLException e) {
	   throw e;
	   }finally{
	   JDBCUtil.close(pstmt,null);
	   }
	 }
	// 리뷰 변경
	@Override
	public int updateResReview(Connection conn, ResReview resReview) throws Exception {
		      PreparedStatement pstmt = null;
		   try{
			   pstmt = conn.prepareStatement(ResReviewQuery.update);
			   pstmt.setString(1, resReview.getResReviewContent());
			   pstmt.setInt(2, resReview.getResReviewRatings());
			   pstmt.setInt(3, resReview.getResInfoId());
			   pstmt.setInt(4, resReview.getResReviewId());
			   return pstmt.executeUpdate();
		   }catch (SQLException e) {
		   throw e;
		   }finally{
		   JDBCUtil.close(pstmt,null);
		   }
		}
// 리뷰 삭제
	@Override
	public int deleteResReview(Connection conn, int customerId) throws Exception {
		   String sql = "delete from Res_Reivew where customer_Id=? and wine_Info_Id=?";
		   PreparedStatement pstmt = null;
		   try{
			   pstmt = conn.prepareStatement(ResReviewQuery.delete);
			   pstmt.setInt(1, customerId);
			   return pstmt.executeUpdate();
		   }catch (SQLException e) {
		   throw e;
		   }finally{
		   JDBCUtil.close(pstmt,null);
		   }
		 
		}
	// 레스토랑별 리뷰정보 전체리스트 조회
	@Override
	public ArrayList<ResReview> selectAllResReview(Connection conn, int resInfoId,int startRow, int  lastRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = conn.prepareStatement(ResReviewQuery.selectAllResReview);	
		pstmt.setInt(1, resInfoId);	
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, lastRow);
		ArrayList<ResReview>list = new ArrayList<>();
		ResReview resReview = new ResReview();
		while (rs.next()){
		resReview.setResReviewId(rs.getInt("resReviewId"));
		resReview.setResReviewContent(rs.getString("resReviewContent"));
		resReview.setResReviewRatings(rs.getInt("resReviewRatings"));
		resReview.setResInfoId(rs.getInt("resInfoId"));
		resReview.setCustomerId(rs.getInt("CustomerId"));
		list.add(resReview);
		}
		return list;
		}catch (SQLException e) {
         throw e;
		}finally{
		JDBCUtil.close(pstmt,rs);
		}
	
	}
	//리뷰변경시작
	@Override
	public ResReview selectByCustomerId(Connection conn, int customerId) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = conn.prepareStatement(ResReviewQuery.selectByCustomerId);
		pstmt.setInt(1, customerId);
		rs=pstmt.executeQuery();	
		if(rs.next()){
			ResReview resReview = new ResReview();
			resReview.setResReviewId(rs.getInt("resReviewId"));
			resReview.setResReviewContent(rs.getString("resReview"));
			resReview.setResReviewRatings(rs.getInt("resReviewRatings"));
			resReview.setResInfoId(rs.getInt("resInfoId"));
		}
		}catch (SQLException e) {
			throw e;
		}finally {
			JDBCUtil.close(pstmt, rs);
		}
		return null;
	}
	 //리뷰 개수 조회
	@Override
	public int selectByReviewCount(Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(ResReviewQuery.selectByReviewCount);	
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,rs);
		}
		return 0;
	
	}

}
