package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dionysus.wine.dao.WineOrderDAO;
import dionysus.wine.query.WineOrderQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Customer;
import dionysus.wine.vo.WineOrder;

public class WineOrderDAOImpl implements WineOrderDAO {
	/*
	 * 	- 와인상품 주문전체 리스트 조회								리턴					매개변수
	 * 		1. 와인상품 주문전체 리스트 페이지별 조회			ArrayList<WineOrder>		Connection, 게시글, 게시글
	 * 		2. 와인상품 주문전체 리스트 count조회					int						Connection
	 * 	- 와인상품 레스토랑별 주문 리스트 조회
	 * 		5. 와인상품 레스토랑별 주문 리스트 조회		ArrayList<WineOrder>	Connection, 레스토랑번호
	 * 	- 와인회사별 상품 주문건 판매량 조회
	 * 		6. 와인회사별 상품 주문건 전체 판매량 조회			ArrayList<WineOrder>		Connection
	 * 	- 월별/일별 상품 주문건 판매량 조회
	 * 		7. 와인회사별/월별 상품 주문건 판매량 조회	ArrayList<Integer>	Connection, 주문일자(월별), 와인회사번호
	 * 		8. 와인회사별/일별 상품 주문건 판매량 조회	ArrayList<Integer>	Connection, 주문일자(일별), 와인회사번호
	 * 	- 와인상품 주문회원 정보조회
	 * 		9. 와인상품 주문회원 정보조회						ArryList<Customer>			Connection, 와인회사번호, 고객번호
	 * 	- 주문건 등록.
	 * 		10. 주문건 등록											int						Connection, WineOrder
	 * 	- 주문건 삭제.
	 * 		11. 주문건 삭제											int						Connection, 주문번호
	 * 	- 주문건수정(주문상세에서 처리)
	 * */
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
	//	- 월별/일별 주문 리스트 조회
	// *3. 주문일자별(월별)주문 리스트 조회		ArrayList<WineOrder>		Connection, 주문일자(월별)
	// * 4. 주문일자별(일별)주문 리스트 조회	ArrayList<WineOrder>		Connection, 주문일자(일별)
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
	
	@Override
	public ArrayList<WineOrder> selectByWineSellerWineOrder(Connection conn, int wineSellerId)throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int selectByWineOrderAmountSum(Connection conn, int wineSellerId)throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

}
