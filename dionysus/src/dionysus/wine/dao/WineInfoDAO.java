package dionysus.wine.dao;

public interface WineInfoDAO {

	/*
	 * 												리턴				매개변수	
	 *와인상품 전체리스트 조회			ArrayList<wineInfo>				Connection, wineinfo
	 *	 *단가높은순 조회					ArrayList<wineInfo>			Connection, 와인가격
	 *단가낮은순 조회					ArrayList<WineInfo>				Connection, 와인가격
	 *	와인상품 Count						int							Connection
	 *
	 *와인상품 원산지별 조회			ArrauList<wineInfo>				Connection, 원산지
	 *와인상품 원산지별 Count			int							Connection
	 *
	 *와인상품 추가						int								Connection, 와인이름
	 *와인상품 정보수정					wineInfo 						Connection, 와인이름
	 *와인상품 삭제						int								Connection, 와인이름
	 *상품별 상품등록 회사리스트조회 	ArrayList<wineInfo>				Connection, 등록회사,와인번호
	 *와인회사별 Count						int							Connection
	 *
	 *회사별 상품조회					ArrayList<wineInfo>				Connection, 회사이름
	 * 
	 */

}
