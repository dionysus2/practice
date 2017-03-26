package dionysus.wine.daoimpl;

import java.sql.*;
import java.util.*;

import dionysus.wine.dao.*;
import dionysus.wine.util.*;
import dionysus.wine.vo.*;

public class WineDelivaryDaoImpl implements WineDeliveryDAO {

	
	//배송추가
	@Override
	public int insertWineDelivery(Connection conn, WineDelivery wine) throws SQLException {		
		
		PreparedStatement pstmt = null;
		String Sql = "insert set wine_delivery(wine_delivery_id,wine_delivery_date,wine_delivery_progress,customer_id"
				+ ",wine_seller_id,res_id) values(?,?,?,?,?,?)";
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1,wine.getWineDeliveryId());
			pstmt.setDate(2, wine.getWineDeliveryDate());
			pstmt.setString(3, wine.getWineDeliveryProgress());
			pstmt.setInt(4, wine.getCustomerId());
			pstmt.setInt(5, wine.getWineSellerId());
			pstmt.setInt(6, wine.getResId());
			return pstmt.executeUpdate();
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, null);
		}		
		
		return 0;
	}

	//페이지별 배송리스트 조회 
	@Override
	public ArrayList<WineDelivery> selectWineDeliveryAllList(Connection conn, int startRow, int lastRow,
			int wineDeliveryId) throws SQLException {
		PreparedStatement pstmt = null;
		String Sql = "sfasdfsadf";
		ResultSet rs = null;
		ArrayList<WineDelivery> list = new ArrayList<>();
		WineDelivery wine = new WineDelivery();
		try{
			pstmt=conn.prepareStatement(Sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			rs = pstmt.executeQuery();
			while(rs.next()){
				wine.setCustomerId(rs.getInt("customer_id"));
				wine.setResId(rs.getInt("res_id"));
				wine.setWineDeliveryDate(rs.getDate("wine_delivery_date"));
				wine.setWineDeliveryId(rs.getInt("wine_delivery_id"));
				wine.setWineDeliveryProgress(rs.getString("wine_delivery_progress"));
				wine.setWineSellerId(rs.getInt("seller_id"));
			list.add(wine);
			}
			return list;
			
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}
	//배송번호로 조회
	@Override
	public WineDelivery selectWineDeliveryCustomerId(Connection conn, int wineDeliveryId) throws SQLException {
		String Sql = "select customer_id,res_id,wine_delivery_date"
				+ ",wine_delivery_id,wine_delivery_progress,seller_id"
				+ " from wine_delivery where wine_delivery_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		WineDelivery wine = new WineDelivery();
		try{
			pstmt=conn.prepareStatement(Sql);
			pstmt.setInt(1, wineDeliveryId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				wine.setCustomerId(rs.getInt("customer_id"));
				wine.setResId(rs.getInt("res_id"));
				wine.setWineDeliveryDate(rs.getDate("wine_delivery_date"));
				wine.setWineDeliveryId(rs.getInt("wine_delivery_id"));
				wine.setWineDeliveryProgress(rs.getString("wine_delivery_progress"));
				wine.setWineSellerId(rs.getInt("seller_id"));				
			}
			return wine;
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}
	//회원이름으로 배송리스트 조회
	@Override
	public ArrayList<WineDelivery> selectWineDeliveryCustomerId(Connection conn, int startRow, int lastRow,
			int customerId) throws SQLException {
		String Sql = "select customer_id,res_id,wine_delivery_date"
				+ ",wine_delivery_id,wine_delivery_progress,seller_id"
				+ " from wine_delivery where customer=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WineDelivery> list = new ArrayList<>();
		WineDelivery wine = new WineDelivery();
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			pstmt.setInt(3, customerId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				wine.setCustomerId(rs.getInt("customer_id"));
				wine.setResId(rs.getInt("res_id"));
				wine.setWineDeliveryDate(rs.getDate("wine_delivery_date"));
				wine.setWineDeliveryId(rs.getInt("wine_delivery_id"));
				wine.setWineDeliveryProgress(rs.getString("wine_delivery_progress"));
				wine.setWineSellerId(rs.getInt("seller_id"));				
				list.add(wine);
			}
			return list;
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}
	//배송진행사항 수정
	@Override
	public int updateWineDelivery(Connection conn, WineDelivery wineDelivery) throws SQLException {
		String Sql = "update wine_delivery set(wine_delivery_progress=?)where customer_id=?";
		PreparedStatement pstmt = null;		
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, wineDelivery.getWineDeliveryProgress());
			pstmt.setInt(2, wineDelivery.getWineDeliveryId());
			return pstmt.executeUpdate();
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, null);
		}		
		
		return null;
	}
	//와인회사명으로 배송리스트 조회
	@Override
	public ArrayList<WineDelivery> selectWineDeliveryWineSellerId(Connection conn, int startRow, int lastRow,
			int wineSellerId) throws SQLException {
		String Sql ="select  from wine_delivery where wine_delivery_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WineDelivery> list = new ArrayList<>();
		WineDelivery wine = new WineDelivery();
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
			}
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, null);
		}		
		
		return null;
	}
	//레스토랑며으로 배송리스트 조회
	@Override
	public ArrayList<WineDelivery> selectWineDeliveryResId(Connection conn, int startRow, int lastRow, int resId)
			throws SQLException {
		PreparedStatement pstmt = null;
		try{
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}

}
