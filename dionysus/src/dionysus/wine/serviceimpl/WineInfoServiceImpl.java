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

import dionysus.wine.daoimpl.WineInfoDAOImpl;
import dionysus.wine.service.WineInfoService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.WineInfo;

public class WineInfoServiceImpl implements WineInfoService {
	private WineInfoDAOImpl dao;
	public WineInfoServiceImpl(WineInfoDAOImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao= dao;
	}
	private Logger logger= LoggerFactory.getLogger(WineInfoServiceImpl.class);
	@Override
	public String readAllWineInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		 Connection conn= JDBCUtil.getConnection();
	      try {
	         int pageNo= 1;
	         if(request.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(request.getParameter("pageNo"));
	            logger.info("사용자 페이지 요청");
	         }
	         int cntOfRow= dao.wineInfoCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineInfo> list= dao.selectAllWineInfo(conn, pagination.getStartRow(), pagination.getLastRow());
	         HashMap<String, Object> map= new HashMap<String, Object>();
	         map.put("pagination", pagination);
	         map.put("list", list);
	         logger.info("서비스단 페이징"+pagination);
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

	@Override
	public String readPriceMax(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(request.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(request.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			int cntOfRow= dao.wineInfoCount(conn);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<WineInfo>list= dao.selectWinePriceMax(conn, pagination.getStartRow(), pagination.getLastRow());
			HashMap<String, Object>map= new HashMap<String, Object>();
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

	@Override
	public String readPriceMin(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(request.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(request.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			int cntOfRow= dao.wineInfoCount(conn);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<WineInfo>list= dao.selectWinePriceMin(conn, pagination.getStartRow(), pagination.getLastRow());
			HashMap<String, Object>map= new HashMap<String, Object>();
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

	@Override
	public String readOriginWineInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(request.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(request.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			String wineInfoOrigin= request.getParameter("wineInfoOrigin");
			//	사용자에게 넘어오는 원산지명
			int cntOfRow= dao.wineOriginCount(conn);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<WineInfo>list= dao.selectWineOrigin(conn, wineInfoOrigin, pagination.getStartRow(), pagination.getLastRow());
			HashMap<String, Object>map= new HashMap<String, Object>();
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

	@Override
	public String wineInfoCreateStart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String wineInfoCreateEnd(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		String wineInfoName= request.getParameter("wineInfoName");
		String wineInfoProfilePicture= request.getParameter("wineInfoProfilePicture");
		int wineInfoPrice= Integer.parseInt(request.getParameter("wineInfoPrice"));
		String wineInfoOrigin= request.getParameter("wineInfoOrigin");
		String wineInfoPicture1= request.getParameter("wineInfoPicture1");
		String wineInfoPicture2= request.getParameter("wineInfoPicture2");
		String wineInfoPicture3= request.getParameter("wineInfoPicture3");
		int wineSellerId= Integer.parseInt("wineSellerId");
		try {
			logger.info("Connection연결성공");
			int result= dao.wineInfoInsert(conn, new WineInfo(wineInfoName, wineInfoProfilePicture, wineInfoPrice, wineInfoOrigin, wineInfoPicture1, wineInfoPicture2, wineInfoPicture3, wineSellerId));
			JsonObject ob= new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
				logger.info("DAO INSERT입력성공");
			}
			else{
				ob.addProperty("result", "fail");	
				logger.info("DAO INSERT입력실패");
			}
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
	
	@Override
	public String wineInfoUpdateStart(HttpServletRequest request){
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		int wineInfoId= Integer.parseInt(request.getParameter("wineInfoId"));
		try {
			WineInfo wineInfo= dao.selectByWineInfoId(conn, wineInfoId);
			return new Gson().toJson(wineInfo);
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
	@Override
	public String wineInfoUpdateEnd(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		String wineInfoOrigin= request.getParameter("wineInfoOrigin");
		String wineInfoPicture1= request.getParameter("wineInfoPicture1");
		String wineInfoPicture2= request.getParameter("wineInfoPicture2");
		String wineInfoPicture3= request.getParameter("wineInfoPicture3");
		String wineInfoProfilePicture= request.getParameter("wineInfoProfilePicture");
		int wineInfoPrice= Integer.parseInt(request.getParameter("wineInfoPrice"));
		int wineSellerId= Integer.parseInt(request.getParameter("wineSellerId"));
		String wineInfoName= request.getParameter("wineInfoName");
		try {
			JsonObject ob= new JsonObject();
			int result = dao.wineInfoUpdate(conn, new WineInfo(wineInfoOrigin, wineInfoPicture1, wineInfoPrice, wineInfoPicture2, wineInfoPicture3, wineInfoProfilePicture, wineInfoName, wineSellerId));
			if(result==1){
				ob.addProperty("result", "success");
			}
			else{
				ob.addProperty("result", "fail");
			}
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

	@Override
	public String wineInfoDelete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		String wineInfoName= request.getParameter("wineInfoName");
		try {
			int result= dao.wineInfoDelete(conn, wineInfoName);
			JsonObject ob= new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
			}
			else{
				ob.addProperty("result", "fail");
			}
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

	@Override
	public String readWineSellerWineInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(request.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(request.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			int cntOfRow= dao.wineSellerWineInfoCount(conn);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			String wineSellerUsername= request.getParameter("wineSellerUsername");
			ArrayList<HashMap<String, Object>>list= dao.selectByWineSellerWineInfo(conn, wineSellerUsername, pagination.getStartRow(), pagination.getLastRow());
			HashMap<String, Object>map= new HashMap<String, Object>();
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

}
