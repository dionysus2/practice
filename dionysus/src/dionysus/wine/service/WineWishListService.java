package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface WineWishListService {
	//	장바구니 담기
	public String createWishList(HttpServletRequest	request);
	//	장바구니 삭제
	public String deleteWishList(HttpServletRequest request);
}
