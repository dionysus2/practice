package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.vo.WineReview;

public interface WineReviewDAO {
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
	public int wineReviewInsert(Connection conn, int wineInfoId, int customerId, WineReview winereview)throws SQLException;
	public int wineReviewUpdate(Connection conn, int wineReviewId, int wineInfoId, int customerId, WineReview winereview)throws SQLException;
	public int wineReviewDelete(Connection conn, int wineReviewId ,int wineInfoId, int customerId)throws SQLException;
	public ArrayList<WineReview> selectAllWineReview(Connection conn, int wineInfoId)throws SQLException;
}
