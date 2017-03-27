package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface WineInfoService {
	/*											
	 *	와인상품 전체리스트 조회		
	 *	단가높은순 조회					
	 *	단가낮은순 조회					
	 *	와인상품 원산지별 조회			
	 *	와인상품 추가						
	 *	와인상품 정보수정					
	 *	와인상품 삭제							
	 *	회사리스트별 상품조회 	
	 *	와인상품 번호별 상세정보 조회
	 */
	public String readAllWineInfo(HttpServletRequest request);
	public String readPriceMax(HttpServletRequest request);
	public String readPriceMin(HttpServletRequest request);
	public String readCountryWineInfo(HttpServletRequest request);
	public String wineInfoCreateStart(HttpServletRequest request);
	public String wineInfoCreateEnd(HttpServletRequest request);
	public String wineInfoUpdateStart(HttpServletRequest request);
	public String wineInfoUpdateEnd(HttpServletRequest request);
	public String wineInfoDelete(HttpServletRequest request);
	public String readWineSellerWineInfo(HttpServletRequest request);
	public String readByWineInfoId(HttpServletRequest request);
}
