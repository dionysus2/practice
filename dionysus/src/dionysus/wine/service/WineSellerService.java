package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface WineSellerService {

	//와인업주 회원 비활성화 설정	SelectResOwnerActivated
	//와인 업주 페이지별 리스트 조회	SelectResOwnerAllList
	//와인 업주 회원 마지막 번호 찾기count	ResOwnerCount
	//와인 업주 회원 지역별 조회	SelectResOwnerLocation
	//와인 업주 회원추가	InserResOwner
	//와인 업주 회원 아이디 찾기	SelectResOwnerId
	//와인 업주 회원 비밀번호 찾기	SelectResOwnerPwd
	//와인 업주 회원 정보수정	UpdateResOwner

	
	public String updateWineSellerActivated(HttpServletRequest req)throws Exception;
	public String readAllWineSeller(HttpServletRequest req)throws Exception;
	public String readAllWineSellerLocation(HttpServletRequest req)throws Exception;
	public String createWineSeller(HttpServletRequest req)throws Exception;
	public String readWineSellerId(HttpServletRequest req)throws Exception;
	public String readWineSellerPwd(HttpServletRequest req)throws Exception;
	public String updateWineSeller(HttpServletRequest req)throws Exception;
	public String login(HttpServletRequest request);
	
	


}


