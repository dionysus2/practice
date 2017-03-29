package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface ResReviewService {
	/*
	 * 1. 리뷰 등록											
	 * 2. 리뷰 수정												
	 * 3. 리뷰 삭제												
	 * 4. 레스토랑별 리뷰정보 전체리스트 조회		
	 */
	
	public String ResReviewCreateStart(HttpServletRequest request) throws Exception;
	public String ResReviewCreateEnd(HttpServletRequest request) throws Exception;
	public String  ResReviewUpdateStart(HttpServletRequest request) throws Exception;
	public String  ResReviewUpdateEnd(HttpServletRequest request) throws Exception;
	public String  ResReviewDelete(HttpServletRequest request) throws Exception;
	public String readAllResReview(HttpServletRequest request) throws Exception;
}
