package dionysus.wine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WineInfo {

	private int wineInfoId;
	private String wineInfoName;
	private String wineInfoProfilePicture;
	private int wineInfoPrice;
	private String wineInfoOrigin;
	private String wineInfoPicture1;
	private String wineInfoPicture2;
	private String wineInfoPicture3;
	private int wineSellerId;
	public WineInfo(String wineInfoName, String wineInfoProfilePicture, int wineInfoPrice, String wineInfoOrigin,
			String wineInfoPicture1, String wineInfoPicture2, String wineInfoPicture3, int wineSellerId) {
		super();
		this.wineInfoName = wineInfoName;
		this.wineInfoProfilePicture = wineInfoProfilePicture;
		this.wineInfoPrice = wineInfoPrice;
		this.wineInfoOrigin = wineInfoOrigin;
		this.wineInfoPicture1 = wineInfoPicture1;
		this.wineInfoPicture2 = wineInfoPicture2;
		this.wineInfoPicture3 = wineInfoPicture3;
		this.wineSellerId = wineSellerId;
	}
	
}
