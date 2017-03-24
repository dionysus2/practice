package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.WineDeliveryDAO;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineDelivery;

public class WineDelivaryDaoImpl implements WineDeliveryDAO {

	
	//배송추가
	@Override
	public int insertWineDelivery(Connection conn, WineDelivery wine) throws SQLException {
		
		
		PreparedStatement pstmt = null;
		try{
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return 0;
	}

	@Override
	public ArrayList<WineDelivery> selectWineDeliveryAllList(Connection conn, int startRow, int lastRow,
			int wineDeliveryId) throws SQLException {
		PreparedStatement pstmt = null;
		try{
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}

	@Override
	public WineDelivery selectWineDeliveryCustomerId(Connection conn, int wineDeliveryId) throws SQLException {
		PreparedStatement pstmt = null;
		try{
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}

	@Override
	public ArrayList<WineDelivery> selectWineDeliveryCustomerId(Connection conn, int startRow, int lastRow,
			int customerId) throws SQLException {
		PreparedStatement pstmt = null;
		try{
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}

	@Override
	public String updateWineDelivery(Connection conn, int WineDelivery) throws SQLException {
		PreparedStatement pstmt = null;
		try{
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}

	@Override
	public ArrayList<WineDelivery> selectWineDeliveryWineSellerId(Connection conn, int startRow, int lastRow,
			int wineSellerId) throws SQLException {
		PreparedStatement pstmt = null;
		try{
			
		}catch (Exception e) {
		e.printStackTrace();
		
		}finally {
			JDBCUtil.close(pstmt, rs);
		}		
		
		return null;
	}

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
