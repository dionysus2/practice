package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dionysus.wine.dao.WineOrderInfoDAO;
import dionysus.wine.query.WineOrderInfoQuery;
import dionysus.wine.util.JDBCUtil;

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

}
