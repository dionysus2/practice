package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;

import dionysus.wine.dao.WineOrderInfoDAO;

public class WineOrderInfoDAOImpl implements WineOrderInfoDAO {

	@Override
	public int wineOrderInfoInsert(Connection conn, int wineOrderId, int wineInfoId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
