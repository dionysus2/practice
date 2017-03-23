package dionysus.wine.dao;

import java.sql.*;
import java.util.ArrayList;

import dionysus.wine.vo.Res;
import dionysus.wine.vo.WineSeller;

public interface WineSellerDAO {
	/*
	 *  - 와인회사 업주 회원 비활성화 설정.							리턴						매개변수
	 * 		1. 와인회사 업주 회원 비활성화 설정						int							Connection
	 * 		(비활성화:0 활성화:1 업주회원은 회원가입 신청 시 비활성화 속성은 기본으로 0으로 강제지정)
	 * 	- 와인회사 업주 회원 페이지별 리스트 조회.
	 * 		2. 와인회사 업주 페이지별 리스트 조회					ArrayList<WineSeller>		Connection
	 * 		3. 와인회사 업주 회원 count								int							Connection
	 * 	- 와인회사 업주 회원 지역별/페이지별 리스트 조회
	 * 		4. 와인회사 업주 회원 지역별 조회						ArrayList<WineSeller>		Connection, 지역
	 * 	- 와인회사 업주 회원 추가
	 * 		6. 와인회사 업주 회원추가								int							Connection, WineSeller
	 * 		(회원추가 시 WineAuthorization테이블로 이동)
	 * 	- 로그인
	 * 		7. 와인회사 업주 회원로그인								int							Connection, 아이디, 비밀번호
	 * 	- 로그아웃(컨트롤단에서 처리)
	 * 	- 와인회사 업주 회원 아이디 찾기
	 * 		8. 와인회사 업주 회원 아이디 찾기						String						Connection, 이름, 사업자번호			
	 * 	- 와인회사 업주 회원 비밀번호 찾기
	 * 		9. 와인회사 업주 회원 비밀번호 찾기						String						Connection, 아이디, 이름, 사업자번호 
	 * */
	
	//와인회사업주 회원 비활성화 설정	SelectWineSellerActivated
	
	
	//와인회사업주 페이지별 리스트 조회	SelectWineSellerAllList
	//와인회사업주 회원 count	WineSellerCount
	//와인회사업주 회원 지역별 조회	SelectWineSellerLocation
	//와인회사업주 회원추가	InserWineSeller
	//와인회사업주 회원로그인 	ResWineSellerLogin
	//와인회사업주 회원 아이디 찾기	SelectWineSellerrId
	//와인회사업주 회원 비밀번호 찾기	SelectWineSellerPwd
	//와인회사업주 회원 정보수정	UpdateWineSeller

		//와인회사 업주 회원 비활성화 설정	SelectResOwnerActivated
	public int selectWineSellerActivated(Connection conn, int resId)throws SQLException;
		//와인회사 업주 페이지별 리스트 조회	SelectResOwnerAllList
	public ArrayList<WineSeller> selectWineSellerAllList(Connection conn, int startRow, int lastRow)throws SQLException;
		//와인회사 업주 회원 마지막 번호count	ResOwnerCount
	public int wineSellerCount(Connection conn)throws SQLException;
		//와인회사 업주 회원 지역별 조회	SelectResOwnerLocation
	public ArrayList<WineSeller> selectWineSellerLocation(Connection conn, String wineSellerlocation)throws SQLException;
		//와인회사 업주 회원추가	InserResOwner
	public int inserWineSeller(Connection conn, WineSeller WineSeller)throws SQLException;
		//와인회사 업주 회원로그인 	ResOwnerLogin
//public int resWineSellerLogin(Connection conn, int wineSellerid, String wineSellerPwd)throws SQLException;
		//와인회사 업주 회원 아이디 찾기	SelectResOwnerId
	public int SelectWineSellerrId(Connection conn, int wineId, String wineSellerBrn)throws SQLException;
		//와인회사 업주 회원 비밀번호 찾기	SelectResOwnerPwd
	public int SelectWineSellerPwd(Connection conn, int wineId, String wineSellerName, String wineSellerBrn)throws SQLException;
		//와인회사 업주 회원 정보수정	UpdateResOwner
	public int updateWineSeller(Connection conn, WineSeller WineSellerId)throws SQLException;
		//와인회사 업주 회원 아이디 중복 확인
//public int resOwnerIdCheck(Connection conn, String wineSellerUsername)throws SQLException;

			
		
		
	
}
