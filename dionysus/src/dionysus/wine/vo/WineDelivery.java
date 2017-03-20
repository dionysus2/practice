package dionysus.wine.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class WineDelivery {
	private int wineDeliveryId;
	private Date wineDeliveryDate;
	private String wineDeliveryProgress;
	private int customerId;
	private int wineSellerId;
	private int resId;

}
