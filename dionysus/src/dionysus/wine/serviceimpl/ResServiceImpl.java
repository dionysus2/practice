package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import dionysus.wine.daoimpl.ResDaoImpl;
import dionysus.wine.service.ResService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.Res;

public class ResServiceImpl implements ResService {
	private ResDaoImpl dao;
	public ResServiceImpl(ResDaoImpl dao) {
		this.dao= dao;
	}
	
	
	@Override
	public String updateResActivated(HttpServletRequest req) throws Exception {
		Connection conn=JDBCUtil.getConnection();
		
		return null;
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
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      finally{
	         JDBCUtil.close(conn);
	      }
		return null;
	}

	@Override
	public String readResCount(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readAllResLocation(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createRes(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readResId(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readResPwd(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRes(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
