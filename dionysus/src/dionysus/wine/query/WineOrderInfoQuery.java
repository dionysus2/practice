package dionysus.wine.query;

public interface WineOrderInfoQuery {

	public String insertWineOrderInfo="INSERT INTO WINE_ORDER_INFO(WINE_ORDER_INFO_COUNT, WINE_ORDER_ID, WINE_INFO_ID)VALUES(?, ?, ?)";
	public String deleteWineOrderInfo="DELETE FROM WINE_ORDER_INFO WHERE WINE_ORDER_ID=? AND WINE_INFO_ID=?";
	public String updateWineOrderInfo="UPDATE WINE_ORDER_INFO SET WINE_ORDER_INFO_COUNT=? WHERE WINE_ORDER_ID=? AND WWINE_INFO_ID=?";
}
