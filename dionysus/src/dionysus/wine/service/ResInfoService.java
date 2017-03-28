package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface ResInfoService {
	
	/*
	 *  레스토랑 정보 폐이지별 리스트 조회
	 *  레스토랑 정보 업주별 조회
	 *  레스토랑 정보 추가
	 *  레스토랑 정보 삭제
	 *  레스토랑 정보 수정
	 */
	
	public String readAllResInfo(HttpServletRequest request) throws Exception;
	public String readResOwnerResInfo(HttpServletRequest request) throws Exception;
	public String ResInfoCreateStart(HttpServletRequest request) throws Exception;
	public String ResInfoCreateEnd(HttpServletRequest request) throws Exception;
	public String ResInfoUpdateStart(HttpServletRequest request) throws Exception;
	public String ResInfoUpdateEnd(HttpServletRequest request) throws Exception;
	public String ResInfoDelete(HttpServletRequest request) throws Exception;
	public String readByResInfoId(HttpServletRequest request)throws Exception;
}
