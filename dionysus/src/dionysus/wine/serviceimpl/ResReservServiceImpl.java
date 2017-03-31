package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.daoimpl.ResInfoDaoImpl;
import dionysus.wine.daoimpl.ResResrvDaoImpl;
import dionysus.wine.service.ResReservService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.ResReserv;
import dionysus.wine.vo.WineOrder;

public class ResReservServiceImpl implements ResReservService {
	
	private ResResrvDaoImpl dao;
	public ResReservServiceImpl(ResResrvDaoImpl dao){
		this.dao=dao;
	}

	@Override
	public String readAllReserv(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		try{
	    int pageNo=1;
	    if(request.getParameter("pageNo")!=null){
	        pageNo = Integer.parseInt(request.getParameter("pageNo"));
	    }
		int cntOfRow = dao.selectByReservCount(conn);
		Pagination pagination = PagingUtil.getPagination(pageNo, cntOfRow);
		ArrayList<ResReserv>list = dao.selectAllReserv(conn, pagination.getStartRow(), pagination.getLastRow());
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

	@Override
	public String readByResReserv(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		int resInfoId =  Integer.parseInt(request.getParameter("resInfoId"));
		ResReserv resReserv = new ResReserv();
		try{
		    ArrayList<ResReserv>list = dao.selectByResReserv(conn, resInfoId);
			return new Gson().toJson(list);
	      } catch (Exception e) {
		  e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}
	

	@Override
	public String readByMonthReserv(HttpServletRequest request){
	Connection conn = JDBCUtil.getConnection();
	SimpleDateFormat sdf = new  SimpleDateFormat("YYYY/MM");
	java.util.Date date = null;
	try{
	date= sdf.parse(request.getParameter("resResrvDate"));	
	Date newdate=new Date(date.getTime());
	ArrayList<ResReserv>list = dao.selectByMonthReserv(conn, newdate);
	return new Gson().toJson(list);
	}catch (ParseException e) {
	e.printStackTrace();
	} catch (Exception e) {
     e.printStackTrace();
	}finally {
	JDBCUtil.close(conn);
	}
	return null;
	}

	@Override
	public String readByDayReserv(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		SimpleDateFormat sdf = new  SimpleDateFormat("YYYY/MM/DD");
		java.util.Date date = null;
		try{
		date= sdf.parse(request.getParameter("resResrvDate"));	
		Date newdate=new Date(date.getTime());
		ArrayList<ResReserv>list = dao.selectByDayReserv(conn, newdate);
		return new Gson().toJson(list);
		}catch (ParseException e) {
		e.printStackTrace();
		} catch (Exception e) {
	     e.printStackTrace();
		}finally {
		JDBCUtil.close(conn);
		}
		return null;
		}
	@Override
	public String readByLastReserv(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		ResReserv resReserv = new ResReserv();
		try {
			ArrayList<ResReserv>list = dao.selectByLastReserv(conn, customerId);
			return new Gson().toJson(list);
		} catch (Exception e) {
		  e.printStackTrace();
		}finally {
		JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String readBySalesLate(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		HttpSession session = request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		int resId;
		try {
			resId = new ResInfoDaoImpl().selectByBasicId(conn, basicInfoUsername);
			int result = dao.selectBySalesLate(conn, resId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String ResReservCreateStart(HttpServletRequest request){
		return null;
	}

	@Override
	public String ResReservCreateEnd(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM/DD");
		java.util.Date date=new java.util.Date() ;
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		try {
			date = sdf.parse(request.getParameter("resResrvDate"));
			Date newdate=new Date(date.getTime());
			int resResrvFee = Integer.parseInt(request.getParameter("resResrvFee"));
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int resId = (int)session.getAttribute("resId");
			int result = dao.insertReserv(conn,newdate, resResrvFee, resId, customerId);
			JsonObject ob = new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
			}else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
		} catch (ParseException e) {
		  e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
		 e.printStackTrace();
		}
		return null;
	}

	@Override
	public String ResReservUpdateStart(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		int resResrvId = Integer.parseInt(request.getParameter("resResrvId"));
		try {
			ResReserv resReserv = dao.selectResReserv(conn, resResrvId);
			return new Gson().toJson(resReserv);
		} catch (Exception e) {
		  e.printStackTrace();
		}finally {
		JDBCUtil.close(conn);	
		}
			return null;
	}

	@Override
	public String ResReservUpdateEnd(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM/DD");
		java.util.Date date=new java.util.Date() ;
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		try {
			date = sdf.parse(request.getParameter("resResrvDate"));
			Date newdate=new Date(date.getTime());
			int resResrvFee = Integer.parseInt(request.getParameter("resResrvFee"));
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int resId = (int)session.getAttribute("resId");
			JsonObject ob = new JsonObject();
			int result = dao.updateReserv(conn, newdate, resResrvFee);
		    if(result==1){
				ob.addProperty("result", "success");
			}
			else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		JDBCUtil.close(conn);
		}
		
		return null;
	}

	@Override
	public String ResReservDelete(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		int resResrvId = Integer.parseInt(request.getParameter("resResrvId"));
		try {
			int result = dao.deleteReserv(conn, resResrvId);
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

}
