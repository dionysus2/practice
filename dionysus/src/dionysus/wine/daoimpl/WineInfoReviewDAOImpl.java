package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.WineReviewDAO;
import dionysus.wine.query.WineReviewQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineReview;

public class WineInfoReviewDAOImpl implements WineReviewDAO {

	//	상품별 리뷰정보 등록
	@Override
	public int wineReviewInsert(Connection conn, int wineInfoId, int customerId, WineReview winereview) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(WineReviewQuery.insertWineReview);
			pstm.setString(1, winereview.getWineReviewContent());
			pstm.setInt(2, winereview.getWineReviewRatings());
			pstm.setInt(3, customerId);
			pstm.setInt(4, wineInfoId);
			return pstm.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, null);
		}
	}
	
	//	상품별 리뷰정보 수정
	@Override
	public int wineReviewUpdate(Connection conn, int wineInfoId, int customerId, WineReview winereview) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(WineReviewQuery.updateWineReview);
			pstm.setString(1, winereview.getWineReviewContent());
			pstm.setInt(2, winereview.getWineReviewRatings());
			pstm.setInt(3, winereview.getWineReviewId());
			pstm.setInt(4, winereview.getCustomerId());
			pstm.setInt(5, winereview.getWineInfoId());
			return pstm.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, null);
		}
	}

	//	상품별 상품별 리뷰정보 삭제
	@Override
	public int wineReviewDelete(Connection conn, int wineReviewId ,int wineInfoId, int customerId) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(WineReviewQuery.deleteWineReview);
			pstm.setInt(1, wineReviewId);
			pstm.setInt(2, customerId);
			pstm.setInt(3, wineInfoId);
			return pstm.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, null);
		}
	}

	//	상품별 리뷰 전체리스트 조회
	@Override
	public ArrayList<WineReview> selectAllWineReview(Connection conn, int wineInfoId) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		ArrayList<WineReview>list= new ArrayList<WineReview>();
		try {
			pstm= conn.prepareStatement(WineReviewQuery.selectAllWineReview);
			pstm.setInt(1, wineInfoId);
			rs= pstm.executeQuery();
			while(rs.next()){
				WineReview wine= new WineReview();
				wine.setCustomerId(rs.getInt("CUSTOMER_ID"));
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineReviewContent(rs.getString("WINE_REVIEW_CONTENT"));
				wine.setWineReviewId(rs.getInt("WINE_REVIEW_ID"));
				wine.setWineReviewRatings(rs.getInt("WINE_REVIEW_RATINGS"));
				list.add(wine);
			}
			return list;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
	}

}
