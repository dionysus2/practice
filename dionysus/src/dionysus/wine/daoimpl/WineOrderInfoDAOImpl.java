package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.WineOrderInfoDAO;
import dionysus.wine.query.WineOrderInfoQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineOrderInfo;

public class WineOrderInfoDAOImpl implements WineOrderInfoDAO {

	//	와인주문 상세 추가하기.
	@Override
	public int wineOrderInfoInsert(Connection conn, int wineOrderInfoCount, int wineOrderId, int wineInfoId) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderInfoQuery.insertWineOrderInfo);
			pstm.setInt(1, wineOrderInfoCount);
			pstm.setInt(2, wineOrderId);
			pstm.setInt(3, wineInfoId);
			return pstm.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
	}

	@Override
	public int wineOrderInfoDelete(Connection conn, int wineOrderId, int wineInfoId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int wineInfoAmountUpdate(Connection conn, int wineOrderId, int wineInfoId, int wineOrderInfoCount)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//	와인상품번호 가져오기.
	@Override
	public ArrayList<WineOrderInfo> selectByBasicInfoUsernameWineInfoId(Connection conn, String basicInfoUsername) throws SQLException{
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderInfoQuery.selectByWinInfoIdBasicInfoUsername);
			pstm.setString(1, basicInfoUsername);
			rs= pstm.executeQuery();
			ArrayList<WineOrderInfo>list= new ArrayList<WineOrderInfo>();
			while(rs.next()){
				WineOrderInfo wine= new WineOrderInfo();
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
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
