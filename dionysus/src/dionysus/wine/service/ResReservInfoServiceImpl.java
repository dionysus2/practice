package dionysus.wine.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.dao.ResReservInfoDAO;
import dionysus.wine.daoimpl.ResResrvInfoDaoImpl;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.ResResevInfo;
import dionysus.wine.vo.ResReview;

public class ResReservInfoServiceImpl implements ResReservInfoService {
	private ResResrvInfoDaoImpl dao;
	public ResReservInfoServiceImpl(ResResrvInfoDaoImpl dao) {
		this.dao =dao;
	}

	@Override
	public String CreateResReservInfo(HttpServletRequest request) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		ResResevInfo resResevInfo = new ResResevInfo();
		int resInfoId=Integer.parseInt(request.getParameter("resInfoId"));
	    int resReservId=Integer.parseInt(request.getParameter("resReservId"));
		int resResrvInfoBookingSeats=Integer.parseInt(request.getParameter("resResrvInfoBookingSeats"));
		try{
			int result = dao.insertResReservInfo(conn, resInfoId, resReservId, resResrvInfoBookingSeats);
			JsonObject ob = new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
			} 
			else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
			JDBCUtil.close(conn);
			}
			return null;
		}

	


	@Override
	public String UpdateResReservInfo(HttpServletRequest request) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		ResResevInfo resResevInfo = new ResResevInfo();
		int resInfoId=Integer.parseInt(request.getParameter("resInfoId"));
	    int resReservId=Integer.parseInt(request.getParameter("resReservId"));
		int resResrvInfoBookingSeats=Integer.parseInt(request.getParameter("resResrvInfoBookingSeats"));
		try{
			int result = dao.updateResReservInfo(conn, resInfoId, resReservId, resResrvInfoBookingSeats);
			JsonObject ob = new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
			} 
			else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
			JDBCUtil.close(conn);
			}
			return null;
		}

	@Override
	public String deleteResReservInfo(HttpServletRequest request) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		ResResevInfo resResevInfo = new ResResevInfo();
		int resInfoId=Integer.parseInt(request.getParameter("resInfoId"));
	    int resReservId=Integer.parseInt(request.getParameter("resReservId"));
	    try{
			int result = dao.deleteResReservInfo(conn, resReservId, resInfoId);
			JsonObject ob = new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
			} 
			else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
			JDBCUtil.close(conn);
			}
			return null;
		}

}
