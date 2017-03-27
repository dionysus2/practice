package dionysus.wine.query;

public interface WineWishListQuery {
	/*
	    *        장바구니                               리턴                         매개변수
		 *  1. 장바구니에 상품 담기                   int                   상품번호, 고객번호         
		 *  2. 장바구니에 상품 삭제                   int                   상품번호, 고객번호
	    */
	public String insertWineWishList="INSERT INTO WINE_WISHLIST(CUSTOMER_ID, WINE_INFO_ID)VALUES(?, ?)";
	public String deleteWineWishList="DELETE FROM WINE_WISHLIST WHERE CUSTOMER_ID=? AND WINE_INFO_ID=?";
}
