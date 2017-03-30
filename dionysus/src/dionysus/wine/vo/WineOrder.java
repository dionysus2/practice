package dionysus.wine.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WineOrder {
	
	private int wineOrderId;
	private Date wineOrderDate;
	private int wineOrderAmount;
	private int customerId;
	private int wineSellerId;
	public WineOrder(Date wineOrderDate, int wineOrderAmount, int customerId, int wineSellerId) {
		super();
		this.wineOrderDate = wineOrderDate;
		this.wineOrderAmount = wineOrderAmount;
		this.customerId = customerId;
		this.wineSellerId = wineSellerId;
	}
			
}
