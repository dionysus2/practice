package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.WineSellerDaoImpl;
import dionysus.wine.service.WineSellerService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.Res;
import dionysus.wine.vo.WineSeller;

public class WineSellerServiceImpl implements WineSellerService {
	private WineSellerDaoImpl dao;
	public WineSellerServiceImpl(WineSellerDaoImpl dao){
		this.dao= dao;
	}	
	@Override
	public String updateWineSellerActivated(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		int wineSellerId = Integer.parseInt(req.getParameter("wineSellerId"));
		int result = dao.selectWineSellerActivated(conn, wineSellerId);
		JsonObject ob = new JsonObject();
		if(result==1) ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
		
	}

	@Override
	public String readAllWineSeller(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.wineSellerCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineSeller>list= dao.selectWineSellerAllList(conn, pagination.getStartRow(), pagination.getLastRow());
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
	public String readAllWineSellerLocation(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         String wineSellerLocation = req.getParameter("wineSellerLocation");
	         int cntOfRow= dao.wineSellerCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineSeller>list= dao.selectWineSellerLocation(conn, wineSellerLocation);
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
	public String createWineSeller(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		int wineSellerId = dao.wineSellerCount(conn);
		String wineSellerBrn = req.getParameter("resBrn");
		String wineSellerLocation = req.getParameter("resLocation");
		String wineSellerTel = req.getParameter("resTel");
		String wineSellerAccountNo=req.getParameter("resAccpuntNO");
		String wineSellerProfilePicture = req.getParameter("resProfilePicture");
		String wineSellerName= req.getParameter("resName");
		int basicInfoId=Integer.parseInt(req.getParameter("basicInfoId"));	
		JsonObject ob = new JsonObject();
		try{
		int result = dao.inserWineSeller(conn, new WineSeller(wineSellerId,wineSellerBrn,wineSellerLocation,wineSellerTel,wineSellerAccountNo,wineSellerProfilePicture,wineSellerName,basicInfoId));
		if(result==1)ob.addProperty("result", "success");		
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
	public String readWineSellerId(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String wineSellerName = req.getParameter("wineSellerName");
		String wineSellerBrn = req.getParameter("wineSellerBrn");
		JsonObject ob = new JsonObject();		
		int result =  dao.SelectWineSellerrId(conn, wineSellerName, wineSellerBrn);
		if(result==1)ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
	}

	@Override
	public String readWineSellerPwd(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		int wineId = Integer.parseInt(req.getParameter("wineSellerId"));
		String wineSellerName = req.getParameter("wineSEllerName");
		String wineSellerBrn = req.getParameter("wineSellerBrn");
		int result = dao.SelectWineSellerPwd(conn, wineId, wineSellerName, wineSellerBrn);
		JsonObject ob = new JsonObject();
		if(result==1)ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);		
	}

	@Override
	public String updateWineSeller(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		int wineSellerId = Integer.parseInt(req.getParameter("wineSellerId"));		
		
		try{
			int result = dao.updateWineSeller(conn, new WineSeller);
		
		JsonObject ob = new JsonObject();
		if(result==1)ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil
		}
	}

}