package dionysus.wine.vo;

import lombok.Data;

@Data
public class WineDeliveryInfo {
	private int wineInfoId;
	private int wineDeliveryId;
	private int wineDeliveryInfoCount;
	
	
public WineDeliveryInfo(int wineInfoId, int wineDeliveryId, int wineDeliveryInfoCount){
	this.wineInfoId = wineInfoId;
	this.wineDeliveryId = wineDeliveryId;
	this.wineDeliveryInfoCount=wineDeliveryInfoCount;
}
}
