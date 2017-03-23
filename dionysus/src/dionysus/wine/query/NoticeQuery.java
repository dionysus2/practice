package dionysus.wine.query;

public interface NoticeQuery {
	public String selectNotice = "select * from Notice where activate=1";
	public String noticeAllCount="select count(NOTICE_ID) from notice";
	public String insertNotice = "insert into Notice (Notice_Id, Notice_Title, Notice_Content, Notice_Writer,Notice_Date) values(?,?,?,?,?)";
	public String updateNotice = "update Notice set Notice_Title=?, Notice_Content=? where Notice_Id=?";
	public String deleteNotice = "delete from Notice where Notice_Id=?";
	public String Noticeviews = "select notice_views+1 from notice where notice_id=?";
}
