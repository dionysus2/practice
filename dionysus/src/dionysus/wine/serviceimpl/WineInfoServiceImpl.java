package dionysus.wine.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
	public String readCountryWineInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(request.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(request.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			String wineInfoCountry= request.getParameter("wineInfoCountry");
			//	사용자에게 넘어오는 원산지명
			int cntOfRow= dao.wineOriginCount(conn);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<WineInfo>list= dao.selectWineCountry(conn, wineInfoCountry, pagination.getStartRow(), pagination.getLastRow());
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
	public String wineInfoCreateEnd(HttpServletRequest request){
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		String path= request.getServletContext().getRealPath("img");
		DiskFileItemFactory df= new DiskFileItemFactory();
		ServletFileUpload uploader= new ServletFileUpload(df);
		uploader.setSizeMax(320*480*10);
		WineInfo wine= new WineInfo();
		HttpSession session= request.getSession();
		System.out.println("try접근전");
		try {
			System.out.println("try접근후");
			//	HttpSession session= request.getSession();
			JsonObject ob= new JsonObject();
			List<FileItem>list= uploader.parseRequest(request);
			for(FileItem item: list){
				if(!item.isFormField()){
					String fileName= item.getName();
					int positionOfPoint= fileName.indexOf(".");
					String fName= fileName.substring(0, positionOfPoint);
					String extension= fileName.substring(positionOfPoint+1);
					fileName= fName+"-"+System.nanoTime()+"."+extension;
					if(fileName!=null && !fileName.equals("")){
						logger.info(path+"/"+fileName);
						wine.setWineInfoProfilePicture(fileName);
					}
				}
			}
			String wineInfoName= request.getParameter("wineInfoName");
			int wineInfoPrice= Integer.parseInt(request.getParameter("wineInfoPrice"));
			String wineInfoCapacity= request.getParameter("wineInfoCapacity");
			String wineInfoCountry= request.getParameter("wineInfoCountry");
			String wineInfoRegion= request.getParameter("wineInfoRegion");
			String wineInfoWinery= request.getParameter("wineInfoWinery");
			String wineInfoImporter= request.getParameter("wineInfoImporter");
			String wineInfoVintage= request.getParameter("wineInfoVintage");
			String wineInfoGrapes= request.getParameter("wineInfoGrapes");
			String wineInfoABV= request.getParameter("wineInfoABV");
			String wineInfoType= request.getParameter("wineInfoType");
			String wineInfoClassification= request.getParameter("wineInfoClassification");
			String wineInfoFlavors= request.getParameter("wineInfoFlavors");
			String wineInfoSweetness= request.getParameter("wineInfoSweetness");
			String wineInfoAcidity= request.getParameter("wineInfoAcidity");
			String wineInfoBody= request.getParameter("wineInfoBody");
			String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
			int wineSellerId= dao.selectByBasicId(conn, basicInfoUsername);
			wine.setWineInfoABV(wineInfoABV);
			wine.setWineInfoAcidity(wineInfoAcidity);
			wine.setWineInfoBody(wineInfoBody);
			wine.setWineInfoCapacity(wineInfoCapacity);
			wine.setWineInfoClassification(wineInfoClassification);
			wine.setWineInfoCountry(wineInfoCountry);
			wine.setWineInfoFlavors(wineInfoFlavors);
			wine.setWineInfoGrapes(wineInfoGrapes);
			wine.setWineInfoImporter(wineInfoImporter);
			wine.setWineInfoName(wineInfoName);
			wine.setWineInfoPrice(wineInfoPrice);
			wine.setWineInfoRegion(wineInfoRegion);
			wine.setWineInfoSweetness(wineInfoSweetness);
			wine.setWineInfoType(wineInfoType);
			wine.setWineInfoVintage(wineInfoVintage);
			wine.setWineInfoWinery(wineInfoWinery);
			wine.setWineSellerId(wineSellerId);
			logger.info("서비스에서 전달 new Wine():"+" "+wine);
			int result= dao.wineInfoInsert(conn, wine);
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
		catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (Exception e) {
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
		String wineInfoName= request.getParameter("wineInfoName");
		String wineInfoProfilePicture= request.getParameter("wineInfoProfilePicture");
		int wineInfoPrice= Integer.parseInt(request.getParameter("wineInfoPrice"));
		String wineInfoCapacity= request.getParameter("wineInfoCapacity");
		String wineInfoCountry= request.getParameter("wineInfoCountry");
		String wineInfoRegion= request.getParameter("wineInfoRegion");
		String wineInfoWinery= request.getParameter("wineInfoWinery");
		String wineInfoImporter= request.getParameter("wineInfoImporter");
		String wineInfoVintage= request.getParameter("wineInfoVintage");
		String wineInfoGrapes= request.getParameter("wineInfoGrapes");
		String wineInfoABV= request.getParameter("wineInfoABV");
		String wineInfoType= request.getParameter("wineInfoType");
		String wineInfoClassification= request.getParameter("wineInfoClassification");
		String wineInfoFlavors= request.getParameter("wineInfoFlavors");
		String wineInfoSweetness= request.getParameter("wineInfoSweetness");
		String wineInfoAcidity= request.getParameter("wineInfoAcidity");
		String wineInfoBody= request.getParameter("wineInfoBody");
		int wineSellerId= Integer.parseInt(request.getParameter("wineSellerId"));
		try {
			JsonObject ob= new JsonObject();
			int result = dao.wineInfoUpdate(conn, new WineInfo(wineInfoName, wineInfoProfilePicture, wineInfoPrice, wineInfoCapacity, wineInfoCountry, wineInfoRegion, wineInfoWinery, wineInfoImporter, wineInfoVintage, wineInfoGrapes, wineInfoABV, wineInfoType, wineInfoClassification, wineInfoFlavors, wineInfoSweetness, wineInfoAcidity, wineInfoBody, wineSellerId));
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
			int wineSellerId= Integer.parseInt(request.getParameter("wineSellerId"));
			ArrayList<WineInfo>list= dao.selectByWineSellerWineInfo(conn, wineSellerId, pagination.getStartRow(), pagination.getLastRow());
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
	public String readByWineInfoId(HttpServletRequest request){
		Connection conn= JDBCUtil.getConnection();
		int wineInfoId= Integer.parseInt(request.getParameter("wineInfoId"));
		try {
			WineInfo wine= dao.selectByWineInfoId(conn, wineInfoId);
			logger.info("서비스단 와인정보 상세검색"+wineInfoId);
			return new Gson().toJson(wine);
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
