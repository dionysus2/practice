package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.WineReviewDAO;
import dionysus.wine.vo.WineReview;

public class WineReviewDAOImpl implements WineReviewDAO {

	@Override
	public int wineReviewInsert(Connection conn, int wineInfoId, int customerId, WineReview winereview)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int wineReviewUpdate(Connection conn, int wineInfoId, int customerId, WineReview winereview)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int wineReviewDelete(Connection conn, int wineInfoId, int customerId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<WineReview> selectAllWineReview(Connection conn, int wineInfoId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
