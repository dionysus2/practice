package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.WineDeliveryDaoImpl;
import dionysus.wine.service.WineDeliveryService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.ResAuthorization;
import dionysus.wine.vo.WineDelivery;

public class WineDeliveryServiceImpl implements WineDeliveryService {
	private WineDeliveryDaoImpl dao;
	public WineDeliveryServiceImpl(WineDeliveryDaoImpl dao){
		this.dao= dao;
	}	
	
	@Override
	public String createWineDelivery(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineDeliveryId = Integer.parseInt(req.getParameter("wineDeliveryId"));
		String wineDeliveryDate = req.getParameter("wineDeliveryDate");
		String wineDeliveryProgress	= req.getParameter("wineDeliveryProgress");
		int customerId = Integer.parseInt(req.getParameter("customerId"));
		int wineSellerId = Integer.parseInt(req.getParameter("wineSellerId"));
		int resId = Integer.parseInt(req.getParameter("resId"));
		
		try {
			int result=dao.insertWineDelivery(conn, new WineDelivery(wineDeliveryId,wineDeliveryDate,
					wineDeliveryProgress,customerId,wineSellerId,resId));
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
	public String readWineDeliveryAllList(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		 try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.WineDeliveryCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineDelivery>list= dao.selectWineDeliveryAllList(conn, pagination.getStartRow(), pagination.getLastRow());
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
	public String readWineDeliveryId(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineDeliveryId = Integer.parseInt(req.getParameter("wineDeliveryId"));		
		try {
			WineDelivery wineDelivery = dao.selectWineDeliveryId(conn, wineDeliveryId);
			return new Gson().toJson(wineDelivery);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String readWineDeliverCustomerId(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int customerId = Integer.parseInt(req.getParameter("customerId"));
		 try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.WineDeliveryCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineDelivery>list= dao.selectWineDeliveryCustomerId(conn, pagination.getStartRow(), pagination.getLastRow(), customerId);
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
	public String updateWineDelivery(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readWineDeliveryWineSellerId(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineSellerId = Integer.parseInt(req.getParameter("wineSellerId"));
		 try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.WineDeliveryCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineDelivery>list= dao.selectWineDeliveryWineSellerId(conn, pagination.getStartRow(), pagination.getLastRow(), wineSellerId);
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
	public String readWineDeliveryResId(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int resId = Integer.parseInt(req.getParameter("resId"));
		 try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.WineDeliveryCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineDelivery>list= dao.selectWineDeliveryResId(conn, pagination.getStartRow(), pagination.getLastRow(), resId);
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
}
