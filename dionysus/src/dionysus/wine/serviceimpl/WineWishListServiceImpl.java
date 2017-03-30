package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.daoimpl.WineWishListDAOImpl;
import dionysus.wine.service.WineWishListService;
import dionysus.wine.util.JDBCUtil;

public class WineWishListServiceImpl implements WineWishListService {
	private WineWishListDAOImpl dao;
	public WineWishListServiceImpl(WineWishListDAOImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao= dao;
	}
	
	//	장바구니 담기(int customerId, int wineInfoId)
	@Override
	public String createWishList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		try {
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int wineInfoId= (int)session.getAttribute("wineInfoId");
			int result= dao.wineWishListInsert(conn, customerId, wineInfoId);
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

	//	장바구니 삭제(int customerId, int wineInfoId)
	@Override
	public String deleteWishList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		try {
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int wineInfoId= (int)session.getAttribute("wineInfoId");
			int result= dao.wineWishListDelete(conn, customerId, wineInfoId);
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

}
