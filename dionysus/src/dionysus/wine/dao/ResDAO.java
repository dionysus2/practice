package dionysus.wine.dao;

import java.sql.Connection;
import java.util.ArrayList;

import dionysus.wine.vo.Res;

public interface ResDAO {
	/*			
	 * 	- 레스토랑 업주 회원 비활성화 설정.							리턴						매개변수
	 * 		1. 레스토랑 업주 회원 비활성화 설정						int							Connection
	 * 		(비활성화:0 활성화:1 업주회원은 회원가입 신청 시 비활성화 속성은 기본으로 0으로 강제지정)
	 * 	- 레스토랑 업주 회원 페이지별 리스트 조회.
	 * 		2. 레스토랑 업주 페이지별 리스트 조회					ArrayList<Res>				Connection
	 * 		3. 레스토랑 업주 회원 count								int							Connection
	 * 	- 레스토랑 업주 회원 지역별/페이지별 리스트 조회
	 * 		4. 레스토랑 업주 회원 지역별 조회						ArrayList<Res>				Connection, 지역
	 * 	- 레스토랑 업주 회원 추가
	 * 		6. 레스토랑 업주 회원추가								int		Connection, Res
	 * 		(회원추가 시 ResAuthorization테이블로 이동)
	 * 	- 로그인
	 * 		7. 레스토랑 업주 회원로그인								int		Connection, 아이디, 비밀번호
	 * 	- 로그아웃(컨트롤단에서 처리)
	 * 	- 레스토랑 업주 회원 아이디 찾기
	 * 		8. 레스토랑 업주 회원 아이디 찾기						String	Connection, 이름, 사업자번호			
	 * 	- 레스토랑 업주 회원 비밀번호 찾기
	 * 		9. 레스토랑 업주 회원 비밀번호 찾기						String	Connection, 아이디, 이름, 사업자번호
	 */
	
	
	//레스토랑 업주 회원 비활성화 설정	SelectResOwnerActivated
public int selectResOwnerActivated(Connection conn, int resId);
	//레스토랑 업주 페이지별 리스트 조회	SelectResOwnerAllList
public ArrayList<Res> selectResownerAllList(Connection conn, int startRow, int lastRow);
	//레스토랑 업주 회원 마지막 번호 찾기count	ResOwnerCount
public int resOwnerCount(Connection conn);
	//레스토랑 업주 회원 지역별 조회	SelectResOwnerLocation
public ArrayList<Res> selectResOwnerLocation(Connection conn, String reslocation, int startRow, int lastRow);
	//레스토랑 업주 회원추가	InserResOwner
public int insertResOwner(Connection conn, Res res);
	//레스토랑 업주 회원로그인 	ResOwnerLogin
//public int resOwnerLogin(Connection conn, int resid, String respwd);
	//레스토랑 업주 회원 아이디 찾기	SelectRe	sOwnerId
//public int selectResOwnerId(Connection conn, String resOwnerName, String resBrn);
	//레스토랑 업주 회원 비밀번호 찾기	SelectResOwnerPwd
public int selectResOwnerPwd(Connection conn, String basicInfoUserName, String resOwnerName, String resBrn);
	//레스토랑 업주 회원 정보수정	UpdateResOwner
public int updateResOwner(Connection conn, Res resid);
	//레스토랑 업주 회원 아이디 중복 확인
//public int resOwnerIdCheck(Connection conn, String username);

		
 
}
