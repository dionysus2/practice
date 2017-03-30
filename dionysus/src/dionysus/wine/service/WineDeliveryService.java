package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface WineDeliveryService {

	public String createWineDelivery(HttpServletRequest req);
	public String readWineDeliveryAllList(HttpServletRequest req);
	public String readWineDeliveryId(HttpServletRequest req);
	public String readWineDeliverCustomerId(HttpServletRequest req);
	public String updateWineDelivery(HttpServletRequest req);
	public String readWineDeliveryWineSellerId(HttpServletRequest req);
	public String readWineDeliveryResId(HttpServletRequest req);
	
}
