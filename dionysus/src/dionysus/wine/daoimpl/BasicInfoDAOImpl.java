package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.dao.BasicInfoDAO;
import dionysus.wine.query.BasicInfoQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.BasicInfo;

public class BasicInfoDAOImpl implements BasicInfoDAO {
	private Logger logger= LoggerFactory.getLogger(BasicInfoDAOImpl.class);
	@Override
	public int basicInfoInsert(Connection conn, BasicInfo basicinfo) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(BasicInfoQuery.insert);
			pstm.setString(1, basicinfo.getBasicInfoUsername());
			pstm.setString(2, basicinfo.getBasicInfoPwd());
			pstm.setString(3, basicinfo.getBasicInfoEmail());
			return pstm.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, null);
		}
	}

	@Override
	public int basicInfoUpdate(Connection conn, BasicInfo basicinfo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Login(Connection conn, String basicInfoUserName, String basicInfoPwd) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(BasicInfoQuery.login);
			pstm.setString(1, basicInfoUserName);
			pstm.setString(2, basicInfoPwd);
			rs= pstm.executeQuery();
			if(rs.next()){
				logger.info("DAO로그인 성공");
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		logger.info("DAO로그인 실패");
		return 0;
	}

	@Override
	public int basicInfoUserNameCheck(Connection conn, String basicInfoUserName) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(BasicInfoQuery.basicInfoUsernameCheck);
			pstm.setString(1, basicInfoUserName);
			rs= pstm.executeQuery();
			if(rs.next()){
				logger.info("DAO아이디 중복확인 성공");
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		logger.info("DAO아이디 중복확인 실패");
		return 0;
	}

}
