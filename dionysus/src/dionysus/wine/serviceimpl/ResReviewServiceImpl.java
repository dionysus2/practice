package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.ResReviewDaoImpl;
import dionysus.wine.service.ResReviewService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.ResInfo;
import dionysus.wine.vo.ResReview;

public class ResReviewServiceImpl implements ResReviewService {
	private ResReviewDaoImpl dao;
	public ResReviewServiceImpl(ResReviewDaoImpl dao){
		this.dao= dao;
	}
	 private Logger logger= LoggerFactory.getLogger(ResReviewServiceImpl.class); 
	@Override
	public String ResReviewCreateStart(HttpServletRequest request){
	return null;
	}

	@Override
	public String ResReviewCreateEnd(HttpServletRequest request){
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
	   } catch (Exception e) {
		e.printStackTrace();
		}finally {
		JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String ResReviewUpdateStart(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		int customerId =  Integer.parseInt(request.getParameter("customerId"));
	    try{
		ResReview resReview = dao.selectByCustomerId(conn, customerId);
		return new Gson().toJson(resReview);
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String ResReviewUpdateEnd(HttpServletRequest request){
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
		} catch (Exception e) {
		  e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String ResReviewDelete(HttpServletRequest request){
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
		   } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
		
	}
		
	@Override
	public String readAllResReview(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		try{
		int pageNo = 1;
		int resInfoId =  Integer.parseInt(request.getParameter("resInfoId"));
		if(request.getParameter("pageNo")!=null){
		pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		int cntOfRow = dao.selectByReviewCount(conn);
		Pagination pagination = PagingUtil.getPagination(pageNo, cntOfRow);
		ArrayList<ResReview>list = dao.selectAllResReview(conn, resInfoId, pagination.getStartRow(),pagination.getLastRow());
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("pagination", pagination);
         map.put("list", list);
        return new Gson().toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		JDBCUtil.close(conn);
		}
		return null;
	}

}
