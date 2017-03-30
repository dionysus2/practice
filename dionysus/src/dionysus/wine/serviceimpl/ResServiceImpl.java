package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.daoimpl.ResDaoImpl;
import dionysus.wine.service.ResService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.BasicInfo;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.Res;

public class ResServiceImpl implements ResService{
	private ResDaoImpl dao;
	public ResServiceImpl(ResDaoImpl dao){
		this.dao= dao;
	}	
	@Override
	public String updateResActivated(HttpServletRequest req) throws Exception {
		Connection conn=JDBCUtil.getConnection();
		int resId = Integer.parseInt(req.getParameter("res_id"));
		int result = dao.selectResOwnerActivated(conn, resId);
		JsonObject ob = new JsonObject();
		if(result==1)ob.addProperty("result", "success");
		else ob.addProperty("reult", "fail");
		return new Gson().toJson(ob);
		
	}

	@Override
	public String readAllRes(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
	      try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	         }
	         int cntOfRow= dao.resOwnerCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<Res>list= dao.selectResownerAllList(conn, pagination.getStartRow(), pagination.getLastRow());
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
	public String readAllResLocation(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();			
		   try {
		         int pageNo= 1;
		         if(req.getParameter("pageNo")!=null){
		            pageNo= Integer.parseInt(req.getParameter("pageNo"));
		         }
		         int cntOfRow= dao.resOwnerCount(conn);
		         String location = req.getParameter("resLocation");
		         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
		         ArrayList<Res>list= dao.selectResOwnerLocation(conn, location,pagination.getStartRow(), pagination.getLastRow());
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
	public String createRes(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getConnection();
		int resId = dao.resOwnerCount(conn);
		String resBrn = req.getParameter("resBrn");
		String resLocation = req.getParameter("resLocation");
		String resTel = req.getParameter("resTel");
		String resAccountNo=req.getParameter("resAccpuntNO");
		String resProfilePicture = req.getParameter("resProfilePicture");
		String resActivated = req.getParameter("resActivated");
		String resName= req.getParameter("resName");
		int basicInfoId=Integer.parseInt(req.getParameter("basicInfoId"));
		JsonObject ob = new JsonObject();
		try{
		int result = dao.insertResOwner(conn, new Res(resId,resBrn,resLocation,resTel,resAccountNo,resProfilePicture,resActivated,resName,basicInfoId));
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
	public String readResId(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String resOwnername = req.getParameter("resOwnername");
		String resBrn = req.getParameter("resBrn");
		JsonObject ob = new JsonObject();
		int result = dao.selectResOwnerId(conn, resOwnername, resBrn);
		if(result==1) ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
		
	}

	@Override
	public String readResPwd(HttpServletRequest req) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String basicInfoUserName = req.getParameter("basicInfoUsername");
		String resBrn = req.getParameter("resBrn");
		JsonObject ob = new JsonObject();
		int result = dao.selectResOwnerPwd(conn, basicInfoUserName, resBrn);
		if(result==1) ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		return new Gson().toJson(ob);
	}

	@Override
	public String updateRes(HttpServletRequest req) throws Exception {
		Connection conn= JDBCUtil.getConnection();
		String reslocation = req.getParameter("resLocation");
		String resTel = req.getParameter("resTel");
		String resAccountNo = req.getParameter("resAccountNo");
		String resProfilePictiure = req.getParameter("resProfilePicture");
		String resName = req.getParameter("res_name");
		int resId = Integer.parseInt(req.getParameter("resId"));
		JsonObject ob = new JsonObject();
		try {
			int result = dao.updateResOwner(conn, new Res(reslocation,resTel,resAccountNo,resProfilePictiure,resName,resId));
			if(result==1)ob.addProperty("result", "success");
			else ob.addProperty("result", "fail");
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

}
