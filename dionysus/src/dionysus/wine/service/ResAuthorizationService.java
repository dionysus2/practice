package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface ResAuthorizationService {

	
	public String readResAuthorizationAllList(HttpServletRequest req);
	public String createResAuthorization(HttpServletRequest req);
	public String yesResAuthorization(HttpServletRequest req);
	public String deleteResAuthorization(HttpServletRequest req);
}
