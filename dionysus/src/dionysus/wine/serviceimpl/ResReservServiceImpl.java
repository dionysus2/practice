package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dionysus.wine.daoimpl.ResResrvDaoImpl;
import dionysus.wine.daoimpl.WineInfoDAOImpl;
import dionysus.wine.service.ResReservService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.ResReserv;

public class ResReservServiceImpl implements ResReservService {
	
	private ResResrvDaoImpl dao;
	public ResReservServiceImpl(ResResrvDaoImpl dao){
		this.dao=dao;
	}

	@Override
	public String readAllReserv(HttpServletRequest request) throws Exception {
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
		}catch (SQLException e) {
		e.printStackTrace();
		}finally {
		JDBCUtil.close(conn);	
		}
	return null;
	}

	@Override
	public String readByResReserv(HttpServletRequest request) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		int resInfoId =  Integer.parseInt(request.getParameter("resInfoId"));
		ResReserv resReserv = new ResReserv();
		try{
		    ArrayList<ResReserv>list = dao.selectByResReserv(conn, resInfoId);
			return new Gson().toJson(list);
		}catch (SQLException e) {
		e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String readByMonthReserv(HttpServletRequest request) throws Exception {
		
		return null;
	}

	@Override
	public String readByDayReserv(HttpServletRequest request) throws Exception {
		return null;
	}

	@Override
	public String readByLastReserv(HttpServletRequest request) throws Exception {
		return null;
	}

	@Override
	public String readBySalesLate(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ResReservCreateStart(HttpServletRequest request) throws Exception {
		return null;
	}

	@Override
	public String ResReservCreateEnd(HttpServletRequest request) throws Exception {
		return null;
	}

	@Override
	public String ResReservUpdateStart(HttpServletRequest request) throws Exception {
		return null;
	}

	@Override
	public String ResReservUpdateEnd(HttpServletRequest request) throws Exception {
		return null;
	}

	@Override
	public String ResReservDelete(HttpServletRequest request) throws Exception {
		return null;
	}

}
