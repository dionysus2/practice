package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.NoticeCommentDAO;
import dionysus.wine.query.NoticeCommentQuery;
import dionysus.wine.query.NoticeQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Customer;
import dionysus.wine.vo.Notice;
import dionysus.wine.vo.NoticeComment;

public class NoticeCommentImpl implements NoticeCommentDAO{

	@Override
	public ArrayList<NoticeComment> NoticeCommentAllList(Connection conn, int noticeId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(NoticeCommentQuery.NoticeComment);
			rs= pstmt.executeQuery();
			ArrayList<NoticeComment>list= new ArrayList<NoticeComment>();
			while(rs.next()){
				NoticeComment comment = new NoticeComment();
				comment.setCustomerId(rs.getInt("CUSTOMER_ID"));
				comment.setNoticeId(rs.getInt("NOTICE_ID"));
				comment.setNoticeCommentContent(rs.getString("NOTICE_COMMENT_CONTENT"));
				list.add(comment);
			}
			return list;
		} 
		catch (SQLException e) {			
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, rs);
		}
	}

	@Override
	public int NoticeCommentCount(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = conn.prepareStatement(NoticeCommentQuery.noticeCommentAllCount);
		rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
			}
		}
		catch (SQLException e) {
			throw e;
		}
		finally {
			JDBCUtil.close(pstmt,rs);
		}
		return 0;
	}

	@Override
	public int insertNoticeComment(Connection conn, NoticeComment comment) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(NoticeCommentQuery.insertNoticeComment);
			pstmt.setInt(1, comment.getCustomerId());
			pstmt.setInt(2, comment.getNoticeId());
			pstmt.setString(3, comment.getNoticeCommentContent());
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	@Override
	public int updateNoticeComment(Connection conn, NoticeComment comment) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(NoticeCommentQuery.updateNoticeComment);
			pstmt.setString(1, comment.getNoticeCommentContent());
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	@Override
	public int deleteNoiceComment(Connection conn, int customerId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(NoticeCommentQuery.deleteNoticeComment);
			pstmt.setInt(1, customerId);
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, null);
		}
	}

}
