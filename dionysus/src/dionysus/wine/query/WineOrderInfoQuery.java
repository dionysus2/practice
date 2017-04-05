package dionysus.wine.query;

public interface WineOrderInfoQuery {

	public String insertWineOrderInfo="INSERT INTO WINE_ORDER_INFO(WINE_ORDER_INFO_COUNT, WINE_ORDER_ID, WINE_INFO_ID)VALUES(?, ?, ?)";
	public String deleteWineOrderInfo="DELETE FROM WINE_ORDER_INFO WHERE WINE_ORDER_ID=? AND WINE_INFO_ID=?";
	public String updateWineOrderInfo="UPDATE WINE_ORDER_INFO SET WINE_ORDER_INFO_COUNT=? WHERE WINE_ORDER_ID=? AND WWINE_INFO_ID=?";
	//	와인주문정보 가져오기(와인상품번호 꺼내옵니다)
	public String selectByWinInfoIdBasicInfoUsername="SELECT WOI.WINE_INFO_ID FROM WINE_ORDER O, CUSTOMER C, BASIC_INFO B, WINE_ORDER_INFO WOI, WINE_INFO WI WHERE C.BASIC_INFO_ID=B.BASIC_INFO_ID AND C.CUSTOMER_ID=O.CUSTOMER_ID AND O.WINE_ORDER_ID=WOI.WINE_ORDER_ID AND WOI.WINE_INFO_ID=WI.WINE_INFO_ID AND B.BASIC_INFO_USERNAME=?";
}
