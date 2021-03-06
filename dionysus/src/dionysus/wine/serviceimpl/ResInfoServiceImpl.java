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

import dionysus.wine.daoimpl.ResInfoDaoImpl;
import dionysus.wine.service.ResInfoService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.ResInfo;

public class ResInfoServiceImpl implements ResInfoService {
	private ResInfoDaoImpl dao;
	public  ResInfoServiceImpl(ResInfoDaoImpl dao) {
		this.dao = dao;
	}
    private Logger logger= LoggerFactory.getLogger(ResInfoServiceImpl.class); 
	
    //	레스토랑 전체리스트 조회
    @Override
	public String readAllResInfo(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		try{
			int pageNo =1;
			if(request.getParameter("pageNo")!=null){
	        pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}
			int cntOfRow = dao.selectByCount(conn);
			Pagination pagination = PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<ResInfo>list = dao.selectResInfoAllList(conn, pagination.getStartRow(), pagination.getLastRow());
			HashMap<String, Object> map = new HashMap<String, Object>();
			 map.put("pagination", pagination);
	         map.put("list", list);
	         return new Gson().toJson(map);
		    } 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String readResOwnerResInfo(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		try{
			int pageNo =1;
			if(request.getParameter("pageNo")!=null){
			logger.info("사용자 폐이지 요청");
			}
			int resInfoId =  Integer.parseInt(request.getParameter("resInfoId"));
			int cntOfRow = dao.ResOwnerResInfoCount(conn);
			Pagination pagination = PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<ResInfo>list = dao.selectByResOwnerResInfo(conn, resInfoId, pagination.getStartRow(), pagination.getLastRow());
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
	public String ResInfoCreateStart(HttpServletRequest request){
		return null;
	}

	@Override
	public String ResInfoCreateEnd(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		ResInfo resInfo = new ResInfo();
		resInfo.setResInfoName( request.getParameter("resInfoName"));
		resInfo.setResInfoPicture1(request.getParameter("resInfoPicture1"));
		resInfo.setResInfoPicture2(request.getParameter("resInfoPicture2"));
	    resInfo.setResInfoPicture3(request.getParameter("resInfoPicture3"));
		resInfo.setResInfoAvailableSeat(Integer.parseInt(request.getParameter("resInfoAvailableSeat")));
		resInfo.setResInfoOpeningHours(request.getParameter("resInfoOpeningHours"));
		resInfo.setResInfoWebsite(request.getParameter("resInfoWebsite"));
	    resInfo.setResId(Integer.parseInt(request.getParameter("resId")));
	    try{
			int result = dao.insertResInfo(conn, resInfo);
			JsonObject ob = new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
			}else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		return null;
	}

	@Override
	public String ResInfoUpdateStart(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		int resInfoId = Integer.parseInt(request.getParameter("resInfoId"));
		try{
			ResInfo resInfo = dao.selectByResInfoId(conn, resInfoId);
			return new Gson().toJson(resInfo);
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return null;
	}
	
	@Override
	public String ResInfoUpdateEnd(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		ResInfo resInfo = new ResInfo();
		resInfo.setResInfoName( request.getParameter("resInfoName"));
		resInfo.setResInfoPicture1(request.getParameter("resInfoPicture1"));
		resInfo.setResInfoPicture2(request.getParameter("resInfoPicture2"));
	    resInfo.setResInfoPicture3(request.getParameter("resInfoPicture3"));
		resInfo.setResInfoAvailableSeat(Integer.parseInt(request.getParameter("resInfoAvailableSeat")));
		resInfo.setResInfoOpeningHours(request.getParameter("resInfoOpeningHours"));
		resInfo.setResInfoWebsite(request.getParameter("resInfoWebsite"));
	    resInfo.setResId(Integer.parseInt(request.getParameter("resId")));
		try{
			JsonObject ob = new JsonObject();
			int result = dao.updateResInfo(conn, resInfo);
		    if(result==1){
				ob.addProperty("result", "success");
			}
			else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		return null;
	}

	@Override
	public String ResInfoDelete(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		int resId = Integer.parseInt(request.getParameter("resId"));
		try{
			int  result = dao.deleteResInfo(conn, resId);
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

	@Override
	public String readByResInfoId(HttpServletRequest request){
		Connection conn = JDBCUtil.getConnection();
		int resInfoId = Integer.parseInt(request.getParameter("resInfoId"));
	    try{
	    	ResInfo resInfo = dao.selectByResInfoId(conn, resInfoId);
	        return new Gson().toJson(resInfo);
	     } catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
	return null;
	}
  


}
