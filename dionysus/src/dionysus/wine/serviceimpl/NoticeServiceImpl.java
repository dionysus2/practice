package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.dao.NoticeDAO;
import dionysus.wine.daoimpl.NoticeImpl;
import dionysus.wine.service.NoticeService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.BasicInfo;
import dionysus.wine.vo.Notice;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.WineInfo;

public class NoticeServiceImpl implements NoticeService{
	private NoticeImpl dao;
	public NoticeServiceImpl(NoticeImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	private Logger logger= LoggerFactory.getLogger(NoticeServiceImpl.class);

	//	공지사항 게시글 전체조회(페이징 처리)
	@Override
	public String readNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
	      try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.NoticeCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<Notice> list= dao.selectAllNoticeList(conn, pagination.getStartRow(), pagination.getLastRow());
	         HashMap<String, Object> map= new HashMap<String, Object>();
	         map.put("pagination", pagination);
	         map.put("list", list);
	         return new Gson().toJson(map);
	      } 
	      catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      finally{
	         JDBCUtil.close(conn);
	      }
		return null;
	}
	
	//	공지사항 게시글 추가하기.
	@Override
	public String createNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int result= dao.insertNotice(conn, new Notice());
			JsonObject ob= new JsonObject();
			if(result==1)
				ob.addProperty("result", "success");
			else
				ob.addProperty("result", "fail");	
			return new Gson().toJson(ob);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
		return null;
	}
	
	//	공지사항 게시글 수정하기 전 폼뷰
	@Override
	public String updateNoticeStart(HttpServletRequest reuqest) {
		// TODO Auto-generated method stub
		return null;
	}


	//	공지사항 게시글 수정하기.
	@Override
	public String updateNoticeEnd(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//	공지사항 게시글 삭제하기
	@Override
	public String deleteNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	//	공지사항 게시글 번호별 조회하기.
	//	공지사항 조회수 증감
	@Override
	public String readByNoticeId(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		int noticeId= Integer.parseInt(request.getParameter("noticeId"));
		try {
			Notice result= dao.selectByNoticeId(conn, noticeId);
			int noticeViews= dao.viewsNotice(conn, noticeId);
			logger.info("넘어온 NOTICE_ID값:"+noticeId);
			logger.info("선택된 NOTICE의 VIEWS MAX+1값:"+noticeViews);
			int updateViews= dao.updateNoticeViews(conn, noticeViews, noticeId);
			logger.info("업뎃됨:"+updateViews);
			return new Gson().toJson(result);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
		return null;
	}
}
