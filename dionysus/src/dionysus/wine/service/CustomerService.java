package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface CustomerService {	
	/*																리턴				매개변수
	 * 	<리턴은 무조건 Gson사용>
	 * 	- 일반회원 정보 페이지별 조회.								String				void										
	 * 	- 연령대별 일반회원 정보 페이지별 조회.					
	 * 	- 직업별 일반회원 정보 페이지별 조회
	 * 	- 성별 일반회원 정보 페이지별 조회.
	 * 	- 이름으로 회원정보 조회.
	 *	- 일반회원 회원가입.(firstname+lastname)					String				HttpServletRequest
	 *	- 일반회원 회원정보 수정.
	 *	- 일반회원 아이디 찾기(이름, 주민번호).
	 *	- 일반회원 비밀번호 찾기(이름, 주민번호, 아이디).
	 *	- 로그인.										
	 *	- 로그아웃(컨트롤단에서 처리)
	 *	- 일반회원 레스토랑 예약내역 조회.
	 *	- 일반회원 레스토랑 예약내역 수정.
	 *	- 일반회원 레스토랑 예약내역 취소.
	 *	- 일반회원 레스토랑 년별 지난예약 년별/월별/일별 조회
	 *	- 일반회원 와인상품 주문내역 조회.
	 *	- 일반회원 와인상품 주문내역 취소.
	 *	- 일반회원 와인상품 주문내역 수정.
	 *	- 일반회원 장바구니내 와인상품 조회.
	 *	- 일반회원 장바구니내 와인상품 주문신청.
	 *	- 일반회원 장바구니내 와인상품 삭제.
	 * */
	public String readCustomerAll(HttpServletRequest req);
	public String readCustomerAge(HttpServletRequest req);
	public String readCustomerJob(HttpServletRequest req);
	public String readCustomerGender(HttpServletRequest req);
	public String readCustomerName(HttpServletRequest req);
	public String createCustomer(HttpServletRequest req);
	public String updateCustomer(HttpServletRequest req);
	public String deleteCustomer(HttpServletRequest req);
	public String customerIdFind(HttpServletRequest req);
	public String customerPwdFind(HttpServletRequest req);
	public String customerResReserv(HttpServletRequest req);
	public String customerResReservUpdate(HttpServletRequest req);
	public String customerResReservDelete(HttpServletRequest req);
	public String customerLastResReserv(HttpServletRequest req);
	public String customerWineOrder(HttpServletRequest req);
	public String customerWineOrderDelete(HttpServletRequest req);
	public String customerWineOrderUpdate(HttpServletRequest req);
	public String customerWineWishList(HttpServletRequest req);
	public String customerWineWishListOrder(HttpServletRequest req);
	public String customerWineWishListDelete(HttpServletRequest req);
}
