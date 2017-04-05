package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.WineSellerAthorizationDaoImpl;
import dionysus.wine.service.WineSellerAuthorizationService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.WineSellerAuthorization;

public class WineSellerAuthorizationServiceImpl implements WineSellerAuthorizationService {

	private WineSellerAthorizationDaoImpl dao;
	public WineSellerAuthorizationServiceImpl(WineSellerAthorizationDaoImpl dao){
		this.dao= dao;
	}	
	
	@Override	
	public String readWineSellerAuthorizationAllList(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		 try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.wineSellerAuthorization(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineSellerAuthorization>list= dao.selectWineSellerAuthozationAllList(conn, pagination.getStartRow(), pagination.getLastRow());
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
	public String createWineSellerAuthorization(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineSellerId = Integer.parseInt(req.getParameter("wineSellerId"));
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-DD");
		java.util.Date date= null;
		
		try{
			date= sdf.parse(req.getParameter("wineSellerAuthorizationDate"));
			Date wineSellerAuthorizationDate = (Date) new java.util.Date(date.getTime());
		int result = dao.insertWineSellerAuthorization(conn, new WineSellerAuthorization(wineSellerId,wineSellerAuthorizationDate));
		JsonObject ob = new JsonObject();
		if(result==1)ob.addProperty("result","success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
		}catch (SQLException e) {
	        e.printStackTrace();
	     } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     finally{
	        JDBCUtil.close(conn);
	     }
		return null;			
		}

	@Override
	public String yesWineSellerAuthorization(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineSellerAuthorizationId = Integer.parseInt(req.getParameter("wineSellerAuthorizationId"));
		JsonObject ob = new JsonObject();
		try {
			int result = dao.yesWineSellerAuthorizated(conn, wineSellerAuthorizationId);			
			if(result==1)ob.addProperty("result","success");
			else ob.addProperty("result", "fail");
			return new Gson().toJson(ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteWineSellerAuthorization(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineSellerAuthorizationId = Integer.parseInt(req.getParameter("wineSellerAuthorizationId"));
		JsonObject ob = new JsonObject();
		try {
			int result = dao.deleteWineSellerAuthorization(conn, wineSellerAuthorizationId);			
			if(result==1)ob.addProperty("result","success");
			else ob.addProperty("result", "fail");
			return new Gson().toJson(ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

