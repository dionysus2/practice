package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface ResInfoService {
	
	/*
	 *  레스토랑 정보 폐이지별 리스트 조회
	 *  레스토랑 정보 업주별 조회
	 *  레스토랑 정보 추가
	 *  레스토랑 정보 삭제
	 *  레스토랑 정보 수정
	 *  아이디별 레스토랑업주 정보 가져오기.
	 */
	
	public String readAllResInfo(HttpServletRequest request);
	public String readResOwnerResInfo(HttpServletRequest request);
	public String ResInfoCreateStart(HttpServletRequest request);
	public String ResInfoCreateEnd(HttpServletRequest request);
	public String ResInfoUpdateStart(HttpServletRequest request);
	public String ResInfoUpdateEnd(HttpServletRequest request);
	public String ResInfoDelete(HttpServletRequest request);
	public String readByResInfoId(HttpServletRequest request);
	
	
}
