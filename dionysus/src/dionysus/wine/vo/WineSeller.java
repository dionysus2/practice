package dionysus.wine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WineSeller {
	private int wineSellerId;
	private String wineSellerBrn;
	private String wineSellerLocation;
	private String wineSellerTel;
	private String wineSellerAccountNo;
	private String wineSellerProfilePicture;
	private String wineSellerActivated;
	private String wineSellerName;
	private int basicInfoId;
	
	
	
	public WineSeller(int wineSellerId,String wineSellerBrn,String wineSellerLocation,String wineSellerTel,
			String wineSellerAccountNo, String wineSellerProfilePicture
			,String wineSellerName, int basicInfoId){
		super();
		this.wineSellerId = wineSellerId;
		this.wineSellerBrn = wineSellerBrn;
		this.wineSellerLocation = wineSellerLocation;
		this.wineSellerTel = wineSellerTel;
		this.wineSellerAccountNo = wineSellerAccountNo;
		this.wineSellerProfilePicture = wineSellerProfilePicture;
		this.wineSellerName = wineSellerName;
		this.basicInfoId = basicInfoId;		
	}
	public WineSeller(int wineSellerId,String wineSellerLocation,String wineSellerTel,
			String wineSellerAccountNo, String wineSellerProfilePicture
			,String wineSellerName){
		super();
		this.wineSellerId = wineSellerId;
		this.wineSellerLocation = wineSellerLocation;
		this.wineSellerTel = wineSellerTel;
		this.wineSellerAccountNo = wineSellerAccountNo;
		this.wineSellerProfilePicture = wineSellerProfilePicture;
		this.wineSellerName = wineSellerName;
	}

	
	
	
}
