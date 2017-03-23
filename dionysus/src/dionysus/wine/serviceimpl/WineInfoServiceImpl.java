package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.WineInfoDAOImpl;
import dionysus.wine.service.WineInfoService;
import dionysus.wine.util.JDBCUtil;
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
		return null;
	}

	@Override
	public String readPriceMax(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readPriceMin(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readOriginWineInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
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
	//	int wineSellerId= Integer.parseInt("wineSellerId");
		try {
			logger.info("Connection연결성공");
			int result= dao.wineInfoInsert(conn, new WineInfo(wineInfoName, wineInfoProfilePicture, wineInfoPrice, wineInfoOrigin, wineInfoPicture1, wineInfoPicture2, wineInfoPicture3));
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
	public String wineInfoUpdate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String wineInfoDelete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readWineSellerWineInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
