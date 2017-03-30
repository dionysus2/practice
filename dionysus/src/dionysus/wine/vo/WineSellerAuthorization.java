package dionysus.wine.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class WineSellerAuthorization {
	
	private int wineSellerId;
	private Date wineSellerAuthorizationDate;
	private String wineSellerAuthorizated;

	public WineSellerAuthorization(int wineSellerId, Date wineSellerAuthorizationDate){
		this.wineSellerId = wineSellerId;
		this.wineSellerAuthorizationDate = wineSellerAuthorizationDate;
	}
}
