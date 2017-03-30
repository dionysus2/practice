package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface WineSellerAuthorizationService {

	
	public String readWineSellerAuthorizationAllList(HttpServletRequest req);
	public String createWineSellerAuthorization(HttpServletRequest req);
	public String yesWineSellerAuthorization(HttpServletRequest req);
	public String deleteWineSellerAuthorization(HttpServletRequest req);
	
	
}
