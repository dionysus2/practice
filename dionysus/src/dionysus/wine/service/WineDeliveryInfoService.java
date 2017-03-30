package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface WineDeliveryInfoService {

	public String createWineDeliverInfo(HttpServletRequest req);
	public String deleteWineDeliveryInfo(HttpServletRequest req);
	public String updateWineDeliveryInfo(HttpServletRequest req);
}
