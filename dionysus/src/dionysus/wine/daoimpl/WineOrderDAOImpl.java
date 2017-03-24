package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dionysus.wine.dao.WineOrderDAO;
import dionysus.wine.vo.Customer;
import dionysus.wine.vo.WineOrder;

public class WineOrderDAOImpl implements WineOrderDAO {

	@Override
	public ArrayList<WineOrder> selectWineOrderList(Connection conn, int startRow, int lastRow) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectWineOrderCount(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<WineOrder> selectWineOrderByMonth(Connection conn, Date wineOrderDate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WineOrder> selectWineOrderByDay(Connection conn, Date wineOrderDate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> wineSellerSellMonth(Connection conn, Date wineOrderDate, int wineSellerId)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> wineSellerSellDay(Connection conn, Date wineOrderDate, int wineSellerId)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> wineOrderCustomer(Connection conn, int wineSellerId, int customerId)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int wineOrderInsert(Connection conn, WineOrder wineorder) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int wineOrderDelete(Connection conn, int wineOrderId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
