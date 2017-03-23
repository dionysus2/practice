package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.service.BasicInfoService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.BasicInfo;

public class BasicInfoServiceImpl implements BasicInfoService {
	private BasicInfoDAOImpl dao;
	public BasicInfoServiceImpl(BasicInfoDAOImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao= dao;
	}
	private Logger logger= LoggerFactory.getLogger(BasicInfoServiceImpl.class);
	
	@Override
	public String createStart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createEnd(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		String basicInfoUsername= request.getParameter("basicInfoUsername");
		String basicInfoPwd= request.getParameter("basicInfoPwd");
		String basicInfoEmail= request.getParameter("basicInfoEmail");
		try {
			int result= dao.basicInfoInsert(conn, new BasicInfo(basicInfoUsername, basicInfoPwd, basicInfoEmail));
			JsonObject ob= new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
				logger.info("Service아이디생성 성공");
			}
			else{
				ob.addProperty("result", "fail");
				logger.info("Serivce아이디생성 실패");
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
		logger.info("Service커넥션 연결실패");
		return null;
	}

	@Override
	public String deleteStart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEnd(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEnd(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readUsernameCheck(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
