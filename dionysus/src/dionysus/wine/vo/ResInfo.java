package dionysus.wine.vo;

import lombok.Data;

@Data
public class ResInfo {
	
	private int resInfoId;
	private String resInfoName;
	private String resInfoPicture1;
	private String resInfoPicture2;
	private String resInfoPicture3;
	private int resInfoAvailableSeat;
	private String resInfoOpeningHours;
	private String resInfoWebsite;
	private int resId;

}
