package dionysus.wine.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class WineSellerAuthorization {
	
	private int wineSellerId;
	private Date wineSellerAuthorizationDate;
	private String wineSellerAuthorizated;

}
