package dionysus.wine.query;

public interface NoticeQuery {
	//	공지사항 전체게시글 조회(o)
	public String selectNotice = "SELECT T2.* FROM(SELECT ROWNUM RNUM, T1.* FROM(SELECT NOTICE_ID, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER, NOTICE_WRITEDATE, NOTICE_VIEWS FROM NOTICE)T1)T2 WHERE RNUM BETWEEN ? AND ?";
	//	공지사항 전체게시글 카운트(o)
	public String noticeAllCount="select count(NOTICE_ID) from notice";
	//	공지사항 게시글 추가하기(o)
	public String insertNotice = "insert into Notice (Notice_Id, Notice_Title, Notice_Content, Notice_Writer,Notice_writedate, notice_views) values(NOTICE_SEQ.NEXTVAL,?, ?, ?,sysdate, 0)";
	public String updateNotice = "update Notice set Notice_Title=?, Notice_Content=? where Notice_Id=?";
	public String deleteNotice = "delete from Notice where Notice_Id=?";
	public String Noticeviews = "select notice_views+1 from notice where notice_id=?";
}
