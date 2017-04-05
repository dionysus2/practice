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
	//	공지사항 상세글 조회시 NOTICE_VIEWS 1씩 증감을 위한 쿼리(MAX값+1 조회하기)
	public String Noticeviews = "SELECT MAX(NOTICE_VIEWS+1)FROM NOTICE WHERE NOTICE_ID=?";
	//	공지사랑 NOTICE_VIEWS MAX+1값 조회후 UPDATE문
	public String updateNoticeViews="UPDATE NOTICE SET NOTICE_VIEWS=? WHERE NOTICE_ID=?";
	//	공지사항 번호별 조회하기
	public String selectByNoticeId="SELECT NOTICE_ID, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER, NOTICE_WRITEDATE, NOTICE_VIEWS FROM NOTICE WHERE NOTICE_ID=?";
}
