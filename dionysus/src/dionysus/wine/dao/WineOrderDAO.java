package dionysus.wine.dao;

public interface WineOrderDAO {
	/*
	 * 	- 와인상품 주문전체 리스트 조회								리턴					매개변수
	 * 		1. 와인상품 주문전체 리스트 페이지별 조회			ArrayList<WineOrder>		Connection, 게시글, 게시글
	 * 		2. 와인상품 주문전체 리스트 count조회					int						Connection
	 * 	- 월별/일별 주문 리스트 조회
	 * 		3. 주문일자별(월별)주문 리스트 조회					ArrayList<WineOrder>		Connection, 주문일자(월별)
	 * 		4. 주문일자별(일별)주문 리스트 조회					ArrayList<WineOrder>		Connection, 주문일자(일별)
	 * 	- 와인상품 레스토랑별 주문 리스트 조회
	 * 		5. 와인상품 레스토랑별 주문 리스트 조회		ArrayList<HashMap<String, Object>>	Connection, 레스토랑번호
	 * 	- 와인회사별 상품 주문건 판매량 조회
	 * 		6. 와인회사별 상품 주문건 전체 판매량 조회			ArrayList<WineOrder>		Connection
	 * 	- 월별/일별 상품 주문건 판매량 조회
	 * 		7. 와인회사별/월별 상품 주문건 판매량 조회	ArrayList<HashMap<String, Object>>	Connection, 주문일자(월별), 와인회사번호
	 * 		8. 와인회사별/일별 상품 주문건 판매량 조회	ArrayList<HashMap<String, Object>>	Connection, 주문일자(일별), 와인회사번호
	 * 	- 와인상품 주문회원 정보조회
	 * 		9. 와인상품 주문회원 정보조회						ArryList<Customer>			Connection, 와인회사번호, 고객번호
	 * 	- 주문건 등록.
	 * 		10. 주문건 등록											int						Connection, WineOrder
	 * 	- 주문건 삭제.
	 * 		11. 주문건 삭제											int						Connection, 주문번호
	 * 	- 주문건수정(주문상세에서 처리)
	 * */
}
