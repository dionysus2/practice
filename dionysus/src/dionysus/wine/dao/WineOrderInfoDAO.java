package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface WineOrderInfoDAO {
	/*
	 * 	- 주문번호별 상품등록				리턴						매개변수
	 * 		1. 주문번호별 상품등록			int							Connection, 주문번호, 상품번호
	 * 	- 주문번호별 상품삭제
	 * 		2. 주문번호별 상품삭제			int							Connection, 주문번호, 상품번호
	 * 	- 주문번호별 상품별 수량수정
	 * 		3. 주문번호별 상품수량 수정		WineOrderInfo				Connection, 주문번호, 상품번호, 수량
	 * */
	public int wineOrderInfoInsert(Connection conn, int wineOrderInfoCount, int wineOrderId, int wineInfoId)throws SQLException;
	public int wineOrderInfoDelete(Connection conn, int wineOrderId, int wineInfoId)throws SQLException;
	public int wineInfoAmountUpdate(Connection conn, int wineOrderId, int wineInfoId, int wineOrderInfoCount)throws SQLException;
}
