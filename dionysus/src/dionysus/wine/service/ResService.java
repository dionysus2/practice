package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface ResService {
	//레스토랑 업주 회원 비활성화 설정	SelectResOwnerActivated
	//레스토랑 업주 페이지별 리스트 조회	SelectResOwnerAllList
	//레스토랑 업주 회원 마지막 번호 찾기count	ResOwnerCount
	//레스토랑 업주 회원 지역별 조회	SelectResOwnerLocation
	//레스토랑 업주 회원추가	InserResOwner
	//레스토랑 업주 회원 아이디 찾기	SelectResOwnerId
	//레스토랑 업주 회원 비밀번호 찾기	SelectResOwnerPwd
	//레스토랑 업주 회원 정보수정	UpdateResOwner

	
	public String updateResActivated(HttpServletRequest req)throws Exception;
	public String readAllRes(HttpServletRequest req)throws Exception;
	public String readAllResLocation(HttpServletRequest req)throws Exception;
	public String createRes(HttpServletRequest req)throws Exception;
	public String readResId(HttpServletRequest req)throws Exception;
	public String readResPwd(HttpServletRequest req)throws Exception;
	public String updateRes(HttpServletRequest req)throws Exception;
	
	

}
