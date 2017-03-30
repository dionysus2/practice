package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.ResReviewDaoImpl;
import dionysus.wine.service.ResReviewService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.ResInfo;
import dionysus.wine.vo.ResReview;

public class ResReviewServiceImpl implements ResReviewService {
	private ResReviewDaoImpl dao;
	public ResReviewServiceImpl(ResReviewDaoImpl dao){
		this.dao= dao;
	}
	 private Logger logger= LoggerFactory.getLogger(ResReviewServiceImpl.class); 
	@Override
	public String ResReviewCreateStart(HttpServletRequest request) throws Exception {
	return null;
	}

	@Override
	public String ResReviewCreateEnd(HttpServletRequest request) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		ResReview resReview = new ResReview();
		resReview.setResReviewContent(request.getParameter("resReviewContent"));
		resReview.setResReviewRatings(Integer.parseInt(request.getParameter("resReviewRatings")));
		resReview.setResInfoId(Integer.parseInt(request.getParameter("resInfoId")));
		resReview.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		try{
		logger.info("Connection연결성공");
		int result = dao.insertResReivew(conn, resReview);
		JsonObject ob = new JsonObject();
		if(result==1){
			ob.addProperty("result", "success");
			logger.info("Dao insert 성공");
		} 
		else{
			ob.addProperty("result", "fail");
		}
		return new Gson().toJson(ob);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
		JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String ResReviewUpdateStart(HttpServletRequest request) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		int customerId =  Integer.parseInt(request.getParameter("customerId"));
	    try{
		ResReview resReview = dao.selectByCustomerId(conn, customerId);
		return new Gson().toJson(resReview);
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String ResReviewUpdateEnd(HttpServletRequest request) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		ResReview resReview = new ResReview();
		resReview.setResReviewContent(request.getParameter("resReviewContent"));
		resReview.setResReviewRatings(Integer.parseInt(request.getParameter("resReviewRatings")));
		resReview.setResInfoId(Integer.parseInt(request.getParameter("resInfoId")));
		try{
			JsonObject ob = new JsonObject();
			int result = dao.updateResReivew(conn, resReview);
		    if(result==1){
				ob.addProperty("result", "success");
		    }
		    else{
				ob.addProperty("result", "fail");
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String ResReviewDelete(HttpServletRequest request) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		int customerId =  Integer.parseInt(request.getParameter("customerId"));
		try{
			int  result = dao.deleteResReivew(conn, customerId);
			JsonObject ob= new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
			}
			else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
		
	}
		
	

	@Override
	public String readAllResReview(HttpServletRequest request) throws Exception {
		return null;
	}

}
