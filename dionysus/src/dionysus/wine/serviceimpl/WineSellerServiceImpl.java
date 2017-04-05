package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	//	와인업주 등록하기.
	@Override
	public String createWineSeller(HttpServletRequest req)  {

		Connection conn = JDBCUtil.getConnection();
		HttpSession session= req.getSession();
		String wineSellerBrn = req.getParameter("wineSellerBrn");
		String wineSellerLocation = req.getParameter("wineSellerLocation");
		String wineSellerTel = req.getParameter("wineSellerTel");
		String wineSellerAccountNo=req.getParameter("wineSellerAccpuntNO");
		String wineSellerProfilePicture = req.getParameter("wineSellerProfilePicture");
		String wineSellerName= req.getParameter("wineSellerName");
		//	세션으로 얻어온 basicInfoId
		int basicInfoId= (int)session.getAttribute("basicInfoId");
		JsonObject ob = new JsonObject();
		try{
			int result = dao.inserWineSeller(conn, new WineSeller
					(wineSellerBrn,wineSellerLocation,wineSellerTel,
							wineSellerAccountNo,wineSellerProfilePicture,
							wineSellerName,basicInfoId));
			if(result==1)
				ob.addProperty("result", "success");		
			else 
				ob.addProperty("result", "fail");		
			return new Gson().toJson(ob);
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
		String wineSellerLocation = req.getParameter("wineSellerLocation");
		String wineSellerTel = req.getParameter("wineSellerTel");
		String wineSellerAccountNo = req.getParameter("wineSellerAccountNo");
		String wineSellerProfilePicture = req.getParameter("wineSellerProfilePicture");
		String wineSellerName = req.getParameter("wineSellerName");
		int wineSellerId = Integer.parseInt(req.getParameter("wineSellerId"));	
		try{
			int result = dao.updateWineSeller(conn, new WineSeller(wineSellerId, wineSellerLocation, 
					wineSellerTel, wineSellerAccountNo, wineSellerProfilePicture,wineSellerName));
		JsonObject ob = new JsonObject();
		if(result==1)ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return null;
	}
	
	//	와인업주 로그인.
	@Override
	public String login(HttpServletRequest request){
		System.out.println("와인업주로긴");
		Connection conn= JDBCUtil.getConnection();
		String basicInfoUsername= request.getParameter("basicInfoUsername");
		String basicInfoPwd= request.getParameter("basicInfoPwd");
		int result= dao.WineSellerLogin(conn, basicInfoUsername, basicInfoPwd);
		JsonObject ob= new JsonObject();
		System.out.println("결과"+result);
		if(result==1)
			ob.addProperty("result", "success");
		else
			ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
	}

}
