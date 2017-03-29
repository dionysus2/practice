package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import dionysus.wine.vo.Customer;
import dionysus.wine.vo.WineOrder;

public interface WineOrderDAO {
	/*
	 * 	- 와인상품 주문전체 리스트 조회								리턴					매개변수
	 * 		1. 와인상품 주문전체 리스트 페이지별 조회			ArrayList<WineOrder>		Connection, 게시글, 게시글
	 * 		2. 와인상품 주문전체 리스트 count조회					int						Connection
	 * 	- 월별/일별 주문 리스트 조회
	 * 		3. 주문일자별(월별)주문 리스트 조회					ArrayList<WineOrder>		Connection, 주문일자(월별)
	 * 		4. 주문일자별(일별)주문 리스트 조회					ArrayList<WineOrder>		Connection, 주문일자(일별)
	 * 	- 와인상품 레스토랑별 주문 리스트 조회
	 * 		5. 와인상품 와인회사별 주문 리스트 조회		ArrayList<WineOrder>	Connection, 와인회사번호
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
	 * 와인주문 번호별 와인업주번호 가져오기 
	 * */
	public ArrayList<WineOrder> selectWineOrderList(Connection conn, int startRow, int lastRow)throws SQLException;
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
}
