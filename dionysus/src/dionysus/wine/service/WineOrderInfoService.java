package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface WineOrderInfoService {
	/*
	 * 	- 주문번호별 상품등록				리턴						매개변수
	 * 		1. 주문번호별 상품등록			int							Connection, 주문번호, 상품번호
	 * 	- 주문번호별 상품삭제
	 * 		2. 주문번호별 상품삭제			int							Connection, 주문번호, 상품번호
	 * 	- 주문번호별 상품별 수량수정
	 * 		3. 주문번호별 상품수량 수정		WineOrderInfo				Connection, 주문번호, 상품번호, 수량
	 * */
	public String createWineOrderInfo(HttpServletRequest request);
	public String deleteWineOrderInfo(HttpServletRequest request);
	public String updateWineOrderInfo(HttpServletRequest reuqest);
}
