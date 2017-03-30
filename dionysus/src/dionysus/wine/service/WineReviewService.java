package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface WineReviewService {
	/*
	 * 	- 상품별 리뷰정보 등록						리턴					매개변수
	 * 		1. 상품별 리뷰정보 등록					int						Connection, 상품번호, 고객번호, WineReview
	 * 	- 상품별 리뷰정보 수정				
	 * 		2. 상품별 리뷰정보 수정					int						Connection, 상품번호, 고객번호, WineReview
	 * 	- 상품별 리뷰정보 삭제
	 * 		3. 상품별 리뷰정보 삭제					int						Connection, 상품번호, 고객번호, 리뷰번호
	 * 	- 상품별 리뷰 전체리스트 조회
	 * 		4. 상품별 리뷰정보 전체리스트 조회		ArrayList<WineReview>	Connection, 상품번호
	 * */
	public String createWineReview(HttpServletRequest request);
	public String updateWineReview(HttpServletRequest request);
	public String deleteWineReview(HttpServletRequest request);
	public String readAllWineReview(HttpServletRequest request);
}
