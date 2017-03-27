package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;

import dionysus.wine.vo.WineDeliveryInfo;
import dionysus.wine.vo.WineOrderInfo;

public interface WineDeliveryInfoDAO {
	/*
	 * 	- 배송번호별/배송상품번호별 추가			리턴							매개변수
	 * 		1. 배송번호별/상품번호별 등록			int					Connection, 배송번호, 상품번호
	 * 	- 배송번호별/배송상품별 삭제
	 * 		2. 배송번호별/상품번호별 삭제		    int					Connection, 배송번호, 상품번호
	 * 	- 배송번호별/배송상품별 수량수정
	 * 		3. 주문번호별 상품수량 수정		 	WineOrderInfo			Connection, 배송번호, 상품번호, 수량
	 * */


	public int insertWineDeliveryInfoId(Connection conn, WineDeliveryInfo wineDeliveryInfo)throws SQLException;
	public int deleteWineDeliveryInfoId(Connection conn, int wineDeliveryId)throws SQLException;
	public int updateWineOrder(Connection conn, int wineDeliveryId, int wineDeliveryInfoCount)throws SQLException;
	
	
}
