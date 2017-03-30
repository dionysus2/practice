package dionysus.wine.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dionysus.wine.daoimpl.WineOrderDAOImpl;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class WineOrderServiceTest {
	//	@Test
	//	성공
	public void selectWineOrderListTest(){
		Connection conn= JDBCUtil.getConnection();
		int startRow= 1;
		int lastRow= 10;
		WineOrderDAOImpl dao= new WineOrderDAOImpl();
		ArrayList<WineOrder> list;
		try {
			list = dao.selectWineOrderList(conn, startRow, lastRow);
			assertThat(list.size(), is(0));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
	}
	@Test
	public void selectWineOrderCountTest(){
		Connection conn= JDBCUtil.getConnection();
		try {
			int result= new WineOrderDAOImpl().selectWineOrderCount(conn);
			assertThat(result, is(0));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
	}
//	테스트 진행예정
	/*
	public int selectWineOrderCount(Connection conn)throws SQLException;
	public ArrayList<WineOrder> selectWineOrderByMonth(Connection conn, Date wineOrderDate)throws SQLException;
	public ArrayList<WineOrder> selectWineOrderByDay(Connection conn, Date wineOrderDate)throws SQLException;
	public ArrayList<WineOrder> selectByWineSellerWineOrder(Connection conn, int wineSellerId)throws SQLException;
	public int selectByWineOrderAmountSum(Connection conn, int wineSellerId)throws SQLException;
	public int wineSellerSellMonth(Connection conn, Date wineOrderDate, int wineSellerId)throws SQLException;
	public int wineSellerSellDay(Connection conn, Date wineOrderDate, int wineSellerId)throws SQLException;
	public ArrayList<HashMap<String, Object>> wineOrderCustomer(Connection conn, int wineSellerId, int customerId)throws SQLException;
	public int wineOrderInsert(Connection conn, WineOrder wineorder)throws SQLException;
	public int wineOrderDelete(Connection conn, int wineOrderId)throws SQLException;
	public ArrayList<HashMap<String, Object>> selectByWineSellerId(Connection conn)throws SQLException;
	public int selectByCustomerIdOfWineOrderId(Connection conn, int customerId)throws SQLException;
	 * */
}
