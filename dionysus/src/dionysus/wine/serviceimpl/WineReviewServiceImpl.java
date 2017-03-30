package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.daoimpl.WineInfoReviewDAOImpl;
import dionysus.wine.service.WineReviewService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineReview;

public class WineReviewServiceImpl implements WineReviewService {

	//	상품별 리뷰정보 등록
	private WineInfoReviewDAOImpl dao;
	public WineReviewServiceImpl(WineInfoReviewDAOImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao= dao;
	}
	@Override
	public String createWineReview(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		try {
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int wineInfoId= (int)session.getAttribute("wineInfoId");
			String wineReviewContent= request.getParameter("wineReviewContent");
			int wineReviewRatings= Integer.parseInt(request.getParameter("wineReviewRatings"));
			int result= dao.wineReviewInsert(conn, wineInfoId, customerId, new WineReview(wineReviewContent, wineReviewRatings));
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
	
	//	상품별 리뷰정보 수정
	@Override
	public String updateWineReview(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//	Session에 넣어와야할 필드: basicInfoUsername(현재 접속된 아이디), wineReviewId(리뷰아이디)
		//	wineInfoId(와인정보 번호)
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		try {
			int wineInfoId= (int)session.getAttribute("wineInfoId");
			String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int wineReviewId= (int)session.getAttribute("wineReviewId");
			String wineReviewContent= request.getParameter("wineReviewContent");
			int wineReviewRatings= Integer.parseInt(request.getParameter("wineReviewRatings"));
			int result= dao.wineReviewUpdate(conn, wineReviewId, wineInfoId, customerId, new WineReview(wineReviewContent, wineReviewRatings));
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

	//	리뷰정보 삭제
	@Override
	public String deleteWineReview(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		try {
			int wineReviewId= (int)session.getAttribute("wineReviewId");
			String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int wineInfoId= (int)session.getAttribute("wineInfoId");
			int result= dao.wineReviewDelete(conn, wineReviewId, wineInfoId, customerId);
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
		return  null;
	}

	//	리뷰정보 전체리스트 가져오기
	@Override
	public String readAllWineReview(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		int wineInfoId= (int)session.getAttribute("wineInfoId");
		try {
			ArrayList<WineReview>list= dao.selectAllWineReview(conn, wineInfoId);
			return new Gson().toJson(list);
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
