package dionysus.wine.dao;

import java.sql.Connection;

import dionysus.wine.vo.WineReview;

public interface ResReviewDAO {
	/*
	 * 레스토랑 리뷰(리뷰번호,리뷰내용,만족도,레스토랑번호,회원번호)				리턴				매개변수
	 * 1. 리뷰 등록												int			Connection,WineReview,회원번호, 상품번호
	 * 2. 리뷰 수정												int			Connection,WineReview,회원번호, 상품번호
	 * 3. 리뷰 삭제												int			Connection,회원번호, 상품번호
	 */
	public int insertResReivew(Connection conn, WineReview wineReview)throws Exception;
	public int updateResReivew(Connection conn, WineReview wineReview)throws Exception;
    public int deleteResReivew(Connection conn, int customerId, int wineInfoId)throws Exception;



}
