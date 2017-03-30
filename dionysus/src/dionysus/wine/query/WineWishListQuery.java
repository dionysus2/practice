package dionysus.wine.query;

public interface WineWishListQuery {
	//	장바구니 상품담기
	public String insertWineWishList="INSERT INTO WINE_WISHLIST(CUSTOMER_ID, WINE_INFO_ID)VALUES(?, ?)";
	//	장바구니 상품삭제
	public String deleteWineWishList="DELETE FROM WINE_WISHLIST WHERE CUSTOMER_ID=? AND WINE_INFO_ID=?";
}
