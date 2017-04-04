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

	//	공지사항 게시글 전체보기
	@Override
	public ArrayList<Notice> selectAllNoticeList(Connection conn, int startRow, int lastRow) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(NoticeQuery.selectNotice);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			rs= pstmt.executeQuery();
			ArrayList<Notice>list= new ArrayList<Notice>();
			while(rs.next()){
				Notice notice = new Notice();
				notice.setNoticeId(rs.getInt("NOTICE_ID"));
				notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				notice.setNoticeWriter(rs.getString("NOTICE_WRITER"));
				notice.setNoticeWritedate(rs.getDate("NOTICE_WRITEDATE"));
				notice.setNoticeViews(rs.getInt("NOTICE_VIEWS"));
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

	//	공지사항 게시글 카운트
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

	//	공지사항 게시글 추가하기.
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
			pstmt.setInt(6, notice.getNoticeViews());
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	//	공지사항 게시글 수정하기.
	@Override
	public int updateNotice(Connection conn, Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(NoticeQuery.updateNotice);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	//	공지사항 게시글 삭제하기.
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
	
	//	공지사항 NOTICE_VIEWS MAX+1값 조회
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

	//	공지사랑 NOTICE_VIEWS MAX+1값 조회후 UPDATE문
	@Override
	public int updateNoticeViews(Connection conn, int noticeViews, int noticeId) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(NoticeQuery.updateNoticeViews);
			pstm.setInt(1, noticeViews);
			pstm.setInt(2, noticeId);
			return pstm.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, null);
		}
	}

	//	공지사항 게시글 번호별 조회하기
	@Override
	public Notice selectByNoticeId(Connection conn, int noticeId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(NoticeQuery.selectByNoticeId);
			pstm.setInt(1, noticeId);
			rs= pstm.executeQuery();
			if(rs.next()){
				Notice notice= new Notice();
				notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				notice.setNoticeId(rs.getInt("NOTICE_ID"));
				notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				notice.setNoticeViews(rs.getInt("NOTICE_VIEWS"));
				notice.setNoticeWritedate(rs.getDate("NOTICE_WRITEDATE"));
				notice.setNoticeWriter(rs.getString("NOTICE_WRITER"));
				return notice;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return null;
	}
}
