package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.ResAuthorizationDaoImpl;
import dionysus.wine.service.ResAuthorizationService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.ResAuthorization;


public class ResAuthorizationServiceImpl implements ResAuthorizationService {
	private ResAuthorizationDaoImpl dao;
	public ResAuthorizationServiceImpl(ResAuthorizationDaoImpl dao){
		this.dao= dao;
	}	
	
	@Override
	public String readResAuthorizationAllList(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		 try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.resauthorization(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<ResAuthorization>list= dao.selectResAuthorizitionAllList(conn, pagination.getStartRow(), pagination.getLastRow());
	         HashMap<String, Object> map= new HashMap<String, Object>();
	         map.put("pagination", pagination);
	         map.put("list", list);
	         return new Gson().toJson(map);
	      } 
	      catch (SQLException e) {
	         e.printStackTrace();
	      }
	      finally{
	         JDBCUtil.close(conn);
	      }
		return null;
	}
	@Override
	public String createResAuthorization(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int resId = Integer.parseInt(req.getParameter("resid"));
		Date resAuthorizationDate = req.getParameter("resAuthorizationDate");
		try{		
		int result = dao.insertResauthorization(conn, new ResAuthorization(resId,resAuthorizationDate));
		JsonObject ob = new JsonObject();
		if(result==1)ob.addProperty("result","success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
		}catch (SQLException e) {
	        e.printStackTrace();
	     }
	     finally{
	        JDBCUtil.close(conn);
	     }
		return null;			
		}
	@Override
	public String yesResAuthorization(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int resAuthorizationId = Integer.parseInt(req.getParameter("resAuthorizationId"));
		JsonObject ob = new JsonObject();
		try {
			int result = dao.yesResAuthorizated(conn, resAuthorizationId);
			if(result==1)ob.addProperty("result","success");
			else ob.addProperty("result", "fail");
			return new Gson().toJson(ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteResAuthorization(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int resAuthorizationId = Integer.parseInt(req.getParameter("resAuthorizationId"));
		JsonObject ob = new JsonObject();
		try {
			int result = dao.deleteResauthorization(conn, resAuthorizationId);
			if(result==1)ob.addProperty("result","success");
			else ob.addProperty("result", "fail");
			return new Gson().toJson(ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
