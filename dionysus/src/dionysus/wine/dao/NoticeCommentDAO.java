package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.vo.NoticeComment;

public interface NoticeCommentDAO {
	public ArrayList<NoticeComment> NoticeAllList(Connection conn, int noticeId);
	public int insertNoticeComment(Connection conn, NoticeComment comment) throws SQLException;
	public int updateNoticeComment(Connection conn, int customerId) throws SQLException;
	public int deleteNoiceComment(Connection conn, int customerId) throws SQLException;
	
	/*
	 *	- 게시글별 댓글 리스트 조회				리턴						매개변수
	 *		1. 게시글별 댓글 리스트 조회	ArrayList<NoticeComment>	Connection, 게시글번호
	 *	- 게시글별 댓글 작성
	 *		2. 게시글별 댓글 작성				int						Connection, NoticeComment
	 *	- 게시글별 댓글 수정					
	 *		3. 게시글별 작성 댓글 수정			int						Connection, NoticeComment
	 *	- 게시글별 댓글 삭제
	 *		4. 게시글별 작성 댓글 삭제			int						Connection, 회원번호
	 * */
}
