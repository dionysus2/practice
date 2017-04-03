package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dionysus.wine.dao.WineDeliveryInfoDAO;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineDeliveryInfo;
import dionysus.wine.vo.WineOrderInfo;

public class WineDeliveryInfoDaoImpl implements WineDeliveryInfoDAO {

	
		//배송번호별 추가
	@Override
	public int insertWineDeliveryInfoId(Connection conn, WineDeliveryInfo wineDeliveryInfo) throws SQLException {
		
		String Sql = "insert into wine_delivery_info(wine_delivery_id, wine_info_id, wine_delivery_info_count)"
				+ "values(wine_delivery_seq.nextval,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(Sql);
			//pstmt.setInt(1, wineDeliveryInfo.getWineDeliveryId());시퀀스 값으로 변경
			pstmt.setInt(2, wineDeliveryInfo.getWineInfoId());
			pstmt.setInt(3, wineDeliveryInfo.getWineDeliveryInfoCount());
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt,null);
		}
		return 0;
		
	}
	
	
	//배송번호별 삭제
	@Override
	public int deleteWineDeliveryInfoId(Connection conn, int wineDeliveryId) throws SQLException {
		String Sql = "delete from wine_delivery_info where wine_delivery_id=?";
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, wineDeliveryId);
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}
	
	

	//배송수량 변경
	@Override
	public int updateWineOrder(Connection conn, int wineDeliveryId, int wineDeliveryInfoCount)
			throws SQLException {
		String Sql = "update set wine_delivery_info(wine_delivery_info_count)values(?) where wine_delivery_id=?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, wineDeliveryInfoCount);
			pstmt.setInt(2, wineDeliveryId);			
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

}
