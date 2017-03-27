package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.dao.NoticeDAO;
import dionysus.wine.daoimpl.NoticeImpl;
import dionysus.wine.service.NoticeService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.BasicInfo;
import dionysus.wine.vo.Notice;
import dionysus.wine.vo.WineInfo;

public class NoticeServiceImpl implements NoticeService{
	private NoticeImpl dao;
	public NoticeServiceImpl(NoticeImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	private Logger logger= LoggerFactory.getLogger(BasicInfoServiceImpl.class);

	@Override
	public String readNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			logger.info("Connection연결성공");
			int result= dao.insertNotice(conn, new Notice());
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
	public String updateNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			Notice notice= dao.updateNotice(conn, );
			return new Gson().toJson(notice);
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
	public String deleteNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String viewsNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
