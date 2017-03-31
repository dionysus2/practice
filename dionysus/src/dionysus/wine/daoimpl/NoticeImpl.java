package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.NoticeDAO;
import dionysus.wine.query.NoticeQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Notice;

public class NoticeImpl implements NoticeDAO{

	@Override
	public ArrayList<Notice> selectAllNoticeList(Connection conn) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(NoticeQuery.selectNotice);
			rs= pstmt.executeQuery();
			ArrayList<Notice>list= new ArrayList<Notice>();
			while(rs.next()){
				Notice notice = new Notice();
				notice.setNoticeId(rs.getInt("NOTICE_ID"));
				notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				notice.setNoticeWriter(rs.getString("NOTICE_WRITER"));
				notice.setNoticeWritedate(rs.getDate("NOTICE_WRITEDATE"));
				notice.setNoticeViews(rs.getString("NOTICE_VIEWS"));
				list.add(notice);
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
	public int NoticeCount(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = conn.prepareStatement(NoticeQuery.noticeAllCount);
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
	public int insertNotice(Connection conn, Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(NoticeQuery.insertNotice);
			pstmt.setInt(1, notice.getNoticeId());
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setString(3, notice.getNoticeContent());
			pstmt.setString(4, notice.getNoticeWriter());
			pstmt.setDate(5, notice.getNoticeWritedate());
			pstmt.setString(6, notice.getNoticeViews());
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	@Override
	public int updateNotice(Connection conn, Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(NoticeQuery.updateNotice);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	@Override
	public int deleteNotice(Connection conn, int noticeId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(NoticeQuery.deleteNotice);
			pstmt.setInt(1, noticeId);
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

	@Override
	public int viewsNotice(Connection conn, int noticeId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(NoticeQuery.Noticeviews);
			pstmt.setInt(1, noticeId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
				}
			}
		catch (SQLException e) {
			throw e;
		}
		finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}
}
