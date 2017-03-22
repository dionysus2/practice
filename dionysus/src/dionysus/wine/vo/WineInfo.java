package dionysus.wine.vo;

import lombok.Data;

@Data
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

}
