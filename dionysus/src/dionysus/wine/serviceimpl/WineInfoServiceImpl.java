package dionysus.wine.serviceimpl;

import java.io.File;
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
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= (String)session.getAttribute("basicInfoUsername");
		logger.info("업주아뒤:"+basicInfoUsername);
		String path= request.getServletContext().getRealPath("img");
		System.out.println("저장경로:"+path);
		DiskFileItemFactory df= new DiskFileItemFactory();
		ServletFileUpload uploader= new ServletFileUpload(df);
		uploader.setSizeMax(320*480*10);
		WineInfo wine= new WineInfo();
		try {
			System.out.println("테스트");
			JsonObject ob= new JsonObject();
			List<FileItem>list= uploader.parseRequest(request);
			int wineSellerId= dao.selectByBasicId(conn, basicInfoUsername);
			wine.setWineSellerId(wineSellerId);
			logger.info("와인업주번호:"+wineSellerId);
			for(FileItem item: list){
				if(item.isFormField()){
					if(item.getFieldName().equals("wineInfoName")){
						wine.setWineInfoName(item.getString("UTF-8"));
						logger.info("dao에 전달하기 위해 wine에 set한 값:"+" "+wine.getWineInfoName());
					}
					else if(item.getFieldName().equals("wineInfoPrice")){
						wine.setWineInfoPrice(Integer.parseInt(item.getString("UTF-8")));
						logger.info("dao에 전달하기 위해 wine에 set한 값:"+" "+wine.getWineInfoPrice());
					}
					else if(item.getFieldName().equals("wineInfoCapacity")){
						wine.setWineInfoCapacity(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoCountry")){
						wine.setWineInfoCountry(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoRegion")){
						wine.setWineInfoRegion(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoWinery")){
						wine.setWineInfoWinery(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoImporter")){
						wine.setWineInfoImporter(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoVintage")){
						wine.setWineInfoVintage(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoGrapes")){
						wine.setWineInfoGrapes(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoABV")){
						wine.setWineInfoABV(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoType")){
						wine.setWineInfoType(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoClassification")){
						wine.setWineInfoClassification(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoFlavors")){
						wine.setWineInfoFlavors(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoSweetness")){
						wine.setWineInfoSweetness(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoAcidity")){
						wine.setWineInfoAcidity(item.getString("UTF-8"));
					}
					else if(item.getFieldName().equals("wineInfoBody")){
						wine.setWineInfoBody(item.getString("UTF-8"));
					}
				}
				else{
					String fileName= item.getName();
					int positionOfPoint= fileName.indexOf(".");
					String fName= fileName.substring(0, positionOfPoint);
					String extension= fileName.substring(positionOfPoint+1);
					fileName= fName+"-"+System.nanoTime()+"."+extension;
					if(fileName!=null && !fileName.equals("")){
						logger.info(path+"/"+fileName);
						item.write(new File(path+"/"+fileName));
						wine.setWineInfoProfilePicture(fileName);
						logger.info(fileName);
						logger.info(wine.getWineInfoProfilePicture());
					}
				}
			}
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
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		//	현재 접속된 BasicInfoUsername의 아이디를 꺼내온다.
		//	View단에서 본인이 업로드한 상품정보가 아니면 수정하기를 불가할 수 있도록 완료해야 함.
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
		int wineSellerId= dao.selectByBasicId(conn, basicInfoUsername);
		//	dao단에서 검색하여 WineSellerId를 꺼내온다.
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
			HttpSession session= request.getSession();
			String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
			//	현재 접속된 WineSeller의 BasicInfoUsername 아이디를 추출한다.
			int wineSellerId= dao.selectByBasicId(conn, basicInfoUsername);
			//	dao에서 BasicInfoUsername을 통하여 WineSellerId값을 빼온다.
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
	
	//	와인정보 상세검색.
	@Override 
	public String readByWineInfoId(HttpServletRequest request){
		Connection conn= JDBCUtil.getConnection();
		int wineInfoId= Integer.parseInt(request.getParameter("wineInfoId"));
		HttpSession session= request.getSession();
		try {
			WineInfo wine= dao.selectByWineInfoId(conn, wineInfoId);
			session.setAttribute("wineInfoPrice", wine.getWineInfoPrice());
			session.setAttribute("wineSellerId", wine.getWineSellerId());
			session.setAttribute("wineInfoId", wine.getWineInfoId());
			//	와인정보 주문위해 가격저장했습니다.
			//	주문완료 시 와인주문가격 remove해야합니다!
			//	와인가격, 와인업주번호, 와인상품번호 session추가
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