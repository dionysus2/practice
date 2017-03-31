 package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.vo.ResInfo;
import dionysus.wine.vo.ResReserv;

public interface ResInfoDAO {
	/* 
	 * 	- 레스토랑 정보 페이지별 리스트 조회				리턴						매개변수
	 * 		1. 레스토랑 정보 페이지별 리스트 조회		ArrayList<ResInfo>			Connection, 게시글, 게시글
	 * 		2. 레스토랑 정보 count조회						int						Connection		
	 * 	- 레스토랑 정보 업주별 조회
	 * 		3. 레스토랑 정보 업주별 조회					ArrayList<ResInfo>			Connection, 레스토랑 회원번호
	 *      4.  업주별 레스토랑 정보 count조회						int						Connection		
	 * 	- 레스토랑 정보 추가
	 * 		4. 레스토랑 정보 추가							int						Connection, ResInfo
	 * 	- 레스토랑 정보 삭제
	 * 		5. 레스토랑 정보 삭제							int						Connection, 레스토랑 회원번호
	 * 	- 레스토랑 정보 수정
	 * 		6. 레스토랑 정보 수정							int						Connection, ResInfo
	 *     7. 레스토랑정보업데이트 시작                   ResInfo 		       Connection, 레스토랑번호
	 *     8.아이디별 레스토랑업주 정보 가져오기.     int 					Connection, 상품번호
	 * */


public ArrayList<ResInfo>selectResInfoAllList(Connection conn, int startRow, int  lastRow)throws Exception;
public int selectByCount(Connection conn)throws Exception;
public ArrayList<ResInfo>selectByResOwnerResInfo(Connection conn, int resId, int startRow, int  lastRow)throws Exception;
public int ResOwnerResInfoCount(Connection conn)throws Exception;
public int insertResInfo(Connection conn, ResInfo resInfo) throws Exception;
public int deleteResInfo(Connection conn, int resInfo)throws Exception;
public int updateResInfo(Connection conn, ResInfo resInfo) throws Exception;
public ResInfo selectByResInfoId(Connection conn, int resInfoId)throws Exception;
public int selectByBasicId(Connection conn, String basicInfoUsername)throws SQLException;

}
