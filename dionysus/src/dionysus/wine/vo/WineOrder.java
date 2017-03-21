package dionysus.wine.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class WineOrder {
	
	private int wineOrderId;
	private Date wineOrderDate;
	private int wineOrderAmount;
	private int customerId;
	private int wineSellerId;
}
