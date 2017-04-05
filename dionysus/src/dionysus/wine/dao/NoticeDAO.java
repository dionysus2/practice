package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.vo.Notice;


public interface NoticeDAO {
	public ArrayList<Notice> selectAllNoticeList(Connection conn, int startRow, int lastRow) throws SQLException;
	public int NoticeCount(Connection conn) throws SQLException;
	public int insertNotice(Connection conn, Notice notice) throws SQLException;
	public int updateNotice(Connection conn, Notice notice) throws SQLException;
	public int deleteNotice(Connection conn, int noticeId) throws SQLException;
	public int viewsNotice(Connection conn, int noticeId) throws SQLException;
	public int updateNoticeViews(Connection conn, int noticeViews, int noticeId)throws SQLException;
	public Notice selectByNoticeId(Connection conn, int noticeId)throws SQLException;
	
	/*
	 * 	- 공지사항 게시판 페이지별 조회.				리턴					매개변수
	 * 		1. 공지사항 게시판 페이지별 조회.		ArrayList<Notice>		Connection, 게시글, 게시글
	 * 		2. 공지사항 게시글 count조회				int					Connection	
	 * 	- 공지사항 게시판 게시글 작성.
	 * 		3. 공지사항 게시글 작성						int					Connection, Notice
	 * 	- 공지사항 게시판 게시글 수정.
	 * 		4. 공지사항 게시글 수정.					int					Connection, Notice
	 * 	- 공지사항 게시판 게시글 삭제.
	 * 		5. 공지사항 게시글 삭제						int					Connection
	 * 	6. 공지사항 게시글 조회수 증가					int					Connection
	 * 	- 공지사항 NOTICE_ID별 상세조회
	 * 	- 공지사항 MAX+1조회 후 UPDATE문
	 * 
	 * */
}
