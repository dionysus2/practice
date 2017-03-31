package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface ResReviewService {
	/*
	 * 1. 리뷰 등록											
	 * 2. 리뷰 수정												
	 * 3. 리뷰 삭제												
	 * 4. 레스토랑별 리뷰정보 전체리스트 조회		
	 */
	
	public String ResReviewCreateStart(HttpServletRequest request);
	public String ResReviewCreateEnd(HttpServletRequest request);
	public String  ResReviewUpdateStart(HttpServletRequest request);
	public String  ResReviewUpdateEnd(HttpServletRequest request);
	public String  ResReviewDelete(HttpServletRequest request);
	public String readAllResReview(HttpServletRequest request);
}
