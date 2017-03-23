package dionysus.wine.query;

public interface NoticeCommentQuery {
	public String NoticeComment = "select * from Notice_Comment nc, Notice n where nc.Notice_Comment_Id=n.Notice_Id";
	public String noticeCommentAllCount="select count(NOTICE_ID) from noticeComment";
	public String insertNoticeComment = "insert into Notice_Comment (Customer_id, Notice_id, Notice_Comment_Content) values(?,?,?)";
	public String updateNoticeComment = "update Notice_Comment set Notice_Comment_Content=? where Customer_Id=?";
	public String deleteNoticeComment = "delete from Notice_Comment where Customer_Id=?";
}
