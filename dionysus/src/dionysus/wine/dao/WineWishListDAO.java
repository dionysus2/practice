package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface WineWishListDAO {
	/*
	    *        장바구니                               리턴                         매개변수
		 *  1. 장바구니에 상품 담기                   int                   상품번호, 고객번호         
		 *  2. 장바구니에 상품 삭제                   int                   상품번호, 고객번호
	    */
	public int wineWishListInsert(Connection conn, int customerId, int wineInfoId)throws SQLException;
	public int wineWishListDelete(Connection conn, int customerId, int wineInfoId)throws SQLException;
}
