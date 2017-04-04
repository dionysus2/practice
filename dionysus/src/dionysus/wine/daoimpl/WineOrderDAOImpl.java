package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import dionysus.wine.dao.WineOrderDAO;
import dionysus.wine.query.WineOrderQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Customer;
import dionysus.wine.vo.WineOrder;
import dionysus.wine.vo.WineSeller;

public class WineOrderDAOImpl implements WineOrderDAO {

	//	와인상품 주문전체 리스트 페이지별 조회
	@Override
	public ArrayList<WineOrder> selectWineOrderList(Connection conn, int startRow, int lastRow) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		ArrayList<WineOrder>list= new ArrayList<WineOrder>();
		try {
			pstm= conn.prepareStatement(WineOrderQuery.sellectAllWineOrder);
			pstm.setInt(1, startRow);
			pstm.setInt(2, lastRow);
			rs= pstm.executeQuery();
			while(rs.next()){
				WineOrder wine= new WineOrder();
				wine.setCustomerId(rs.getInt("WINE_CUSTOMER_ID"));
				wine.setWineOrderAmount(rs.getInt("WINE_ORDER_AMOUNT"));
				wine.setWineOrderDate(rs.getDate("WINE_ORDER_DATE"));
				wine.setWineOrderId(rs.getInt("WINE_ORDER_ID"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
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

	//	와인상품 주문전체 리스트 count조회
	@Override
	public int selectWineOrderCount(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.selectAllCount);
			rs= pstm.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return 0;
	}
	
	//	주문일자별(년별/월별)주문전체 리스트 조회
	@Override
	public ArrayList<WineOrder> selectWineOrderByMonth(Connection conn, Date wineOrderDate) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.wineOrderByMonth);
			pstm.setDate(1, new java.sql.Date(wineOrderDate.getTime()));
			ArrayList<WineOrder>list= new ArrayList<WineOrder>();
			rs= pstm.executeQuery();
			while(rs.next()){
				WineOrder wine= new WineOrder();
				wine.setCustomerId(rs.getInt("CUSTOMER_ID"));
				wine.setWineOrderAmount(rs.getInt("WINE_ORDER_AMOUNT"));
				wine.setWineOrderDate(rs.getDate("WINE_ORDER_DATE"));
				wine.setWineOrderId(rs.getInt("WINE_ORDER_ID"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
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

	//	주문일자별(년별/월별/일별)주문전체 리스트 조회
	@Override
	public ArrayList<WineOrder> selectWineOrderByDay(Connection conn, Date wineOrderDate) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.wineOrderByDay);
			pstm.setDate(1, new java.sql.Date(wineOrderDate.getTime()));
			ArrayList<WineOrder>list= new ArrayList<WineOrder>();
			rs= pstm.executeQuery();
			while(rs.next()){
				WineOrder wine= new WineOrder();
				wine.setCustomerId(rs.getInt("CUSTOMER_ID"));
				wine.setWineOrderAmount(rs.getInt("WINE_ORDER_AMOUNT"));
				wine.setWineOrderDate(rs.getDate("WINE_ORDER_DATE"));
				wine.setWineOrderId(rs.getInt("WINE_ORDER_ID"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
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

	//	회사번호별/년별/월별 주문 판매량 총금액 조회.
	@Override
	public int wineSellerSellMonth(Connection conn, Date wineOrderDate, int wineSellerId) throws SQLException
		 {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.wineOrderByMonthOfWineSeller);
			pstm.setDate(1, new java.sql.Date(wineOrderDate.getTime()));
			pstm.setInt(2, wineSellerId);
			rs= pstm.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return 0;
	}

	//	회사번호별/년별/월별/일별 주문 판매량 총금액 조회.
	@Override
	public int wineSellerSellDay(Connection conn, Date wineOrderDate, int wineSellerId) throws SQLException
			 {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.wineOrderByDayOfWineSeller);
			pstm.setDate(1, new java.sql.Date(wineOrderDate.getTime()));
			pstm.setInt(2, wineSellerId);
			rs= pstm.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return 0;
	}

	//	와인상품 주문회원 정보조회
	@Override
	public ArrayList<HashMap<String, Object>> wineOrderCustomer(Connection conn, int wineSellerId, int customerId) throws SQLException
			 {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		ArrayList<HashMap<String, Object>>list= new ArrayList<HashMap<String, Object>>();
		try {
			pstm= conn.prepareStatement(WineOrderQuery.wineOrderByCustomer);
			pstm.setInt(1, wineSellerId);
			pstm.setInt(2, customerId);
			rs= pstm.executeQuery();
			while(rs.next()){
				WineOrder wine= new WineOrder();
				Customer customer= new Customer();
				HashMap<String, Object>map= new HashMap<String, Object>();
				wine.setWineOrderId(rs.getInt("WINE_ORDER_ID"));
				wine.setWineOrderDate(rs.getDate("WINE_ORDER_DATE"));
				wine.setWineOrderAmount(rs.getInt("WINE_ORDER_AMOUNT"));
				customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setCustomerTel(rs.getString("CUSTOMER_TEL"));
				customer.setCustomerGender(rs.getString("CUSTOMER_GENDER"));
				customer.setCustomerAccountNo(rs.getString("CUSTOMER_ACCOUNTNO"));
				customer.setCustomerJob(rs.getString("CUSTOMER_JOB"));
				customer.setCustomerActivated(rs.getString("CUSTOMER_ACTIVATED"));
				map.put("wine", wine);
				map.put("customer", customer);
				list.add(map);
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

	//	주문건 추가
	@Override
	public int wineOrderInsert(Connection conn, WineOrder wineorder) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.insertWineOrder);
			pstm.setDate(1, new java.sql.Date(wineorder.getWineOrderDate().getTime()));
			pstm.setInt(2, wineorder.getWineOrderAmount());
			pstm.setInt(3, wineorder.getCustomerId());
			pstm.setInt(4, wineorder.getWineSellerId());
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

	//	주문건 삭제
	@Override
	public int wineOrderDelete(Connection conn, int wineOrderId) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.deleteWineOrder);
			pstm.setInt(1, wineOrderId);
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
	
	@Override
	public ArrayList<WineOrder> selectByWineSellerWineOrder(Connection conn, int wineSellerId)throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}
	
	//	와인회사별 상품 주문건 전체 판매량 조회	
	@Override
	public int selectByWineOrderAmountSum(Connection conn, int wineSellerId) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.wineOrderAmountByWineSeller);
			pstm.setInt(1, wineSellerId);
			rs= pstm.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return 0;
	}
	
	//	와인주문번호별 와인업주번호 가져오기(매칭되는 것으로만)
	@Override
	public ArrayList<HashMap<String, Object>> selectByWineSellerId(Connection conn) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.selectByWineSellerId);
			rs= pstm.executeQuery();
			ArrayList<HashMap<String, Object>>list= new ArrayList<>();
			while(rs.next()){
				WineOrder wine= new WineOrder();
				WineSeller seller= new WineSeller();
				HashMap<String, Object>map= new HashMap<String, Object>();
				wine.setWineOrderId(rs.getInt("WINE_ORDER_ID"));
				seller.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
				map.put("wine", wine);
				map.put("seller", seller);
				list.add(map);
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
	
	//	고객번호별 와인 주문번호 가져오기
	@Override
	public int selectByCustomerIdOfWineOrderId(Connection conn, int customerId) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.selectByWineOrderId);
			pstm.setInt(1, customerId);
			rs= pstm.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return 0;
	}
	
	//	와인주문번호 최댓값 조회
	@Override
	public int selectWinOrderIdMax(Connection conn) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineOrderQuery.selectByWineOrderIdMax);
			rs= pstm.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return 0;
	}
}
