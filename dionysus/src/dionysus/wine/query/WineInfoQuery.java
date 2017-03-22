package dionysus.wine.query;

public interface WineInfoQuery {
	//	와인상품 전체리스트 조회
	public String selectAll="SELECT T2.* FROM(SELECT ROWNUM RNUM, T1.* FROM(SELECT WINE_INFO_ID, WINE_INFO_NAME, WINE_INFO_PROFILE_PICTURE, WINE_INFO_PRICE, WINE_INFO_ORIGIN, WINE_INFO_PICTURE1, WINE_INFO_PICTURE2, WINE_INFO_PICTURE3, WINE_SELLER_ID FROM WINE_INFO)T1)T2 WHERE RNUM BETWEEN ? AND ?";
	//	단가높은순 조회
	public String sellMax="SELECT T2.* FROM(SELECT ROWNUM RNUM, T1.* FROM(SELECT WINE_INFO_ID, WINE_INFO_NAME, WINE_INFO_PROFILE_PICTURE, WINE_INFO_PRICE, WINE_INFO_ORIGIN, WINE_INFO_PICTURE1, WINE_INFO_PICTURE2, WINE_INFO_PICTURE3, WINE_SELLER_ID FROM WINE_INFO ORDER BY WINE_INFO_PRICE ASC)T1)T2 WHERE RNUM BETWEEN ? AND ?";
	//	단가낮은순 조회
	public String sellMin="SELECT T2.* FROM(SELECT ROWNUM RNUM, T1.* FROM(SELECT WINE_INFO_ID, WINE_INFO_NAME, WINE_INFO_PROFILE_PICTURE, WINE_INFO_PRICE, WINE_INFO_ORIGIN, WINE_INFO_PICTURE1, WINE_INFO_PICTURE2, WINE_INFO_PICTURE3, WINE_SELLER_ID FROM WINE_INFO ORDER BY WINE_INFO_PRICE DESC)T1)T2 WHERE RNUM BETWEEN ? AND ?";
	//	와인상품 Count
	public String selectAllCount="SELECT COUNT(WINE_INFO_ID)FROM WINE_INFO";
	//	와인상품 원산지별 조회
	public String selectByOrigin="SELECT T2.* FROM(SELECT ROWNUM RNUM, T1.* FROM(SELECT WINE_INFO_ID, WINE_INFO_NAME, WINE_INFO_PROFILE_PICTURE, WINE_INFO_PRICE, WINE_INFO_ORIGIN, WINE_INFO_PICTURE1, WINE_INFO_PICTURE2, WINE_INFO_PICTURE3, WINE_SELLER_ID FROM WINE_INFO WHERE WINE_INFO_ORIGIN=?)T1)T2 WHERE RNUM BETWEEN ? AND ?";
	//	와인상품 원산지별 Count
	public String selectByOriginCount="SELECT COUNT(WINE_INFO_ID)FROM WINE_INFO WHERE WINE_INFO_ORIGIN=?";
	//	와인상품 추가
	public String insert="INSERT INTO WINE_INFO(WINE_INFO_ID, WINE_INFO_NAME, WINE_INFO_PROFILE_PICTURE, WINE_INFO_PRICE, WINE_INFO_ORIGIN, WINE_INFO_PICTURE1, WINE_INFO_PICTURE2, WINE_INFO_PICTURE3, WINE_SELLER_ID)VALUES(WINE_INFO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
	//	와인상품 정보삭제
	public String delete="DELETE FROM WINE_INFO WHERE WINE_INFO_NAME=?";
	//	와인상품 정보수정
	public String update="UPDATE WINE_INFO SET WINE_INFO_PROFILE_PICTURE=?, WINE_INFO_PRICE=?, WINE_INFO_ORIGIN=?, WINE_INFO_PICTURE1=?, WINE_INFO_PICTURE2=?, WINE_INFO_PICTURE3=?, WINE_SSELLER_ID=? WHERE WINE_INFO_NAME=?";
	//	회사리스트별 상품조회
	public String selectByWineSeller="SELECT T2.* FROM(SELECT ROWNUM RNUM, T1.* FROM(SELECT W.WINE_INFO_ID, W.WINE_INFO_NAME, W.WINE_INFO_PROFILE_PICTURE, W.WINE_INFO_PRICE, W.WINE_INFO_ORIGIN, W.WINE_INFO_PICTURE1, W.WINE_INFO_PICTURE2, W.WINE_INFO_PICTURE3, S.WINE_SELLER_USERNAME FROM WINE_INFO W, WINE_SELLER S WHERE W.WINE_SELLER_ID=S.WINE_SELLER_ID AND S.WINE_SELLER_USERNAME=?)T1)T2 WHERE RNUM BETWEEN ? AND ?";
	// 	회사별 COUNTS
	public String selectByWineSellerCount="SELECT COUNT(WINE_SELLER_ID)FROM WINE_INFO";
}
