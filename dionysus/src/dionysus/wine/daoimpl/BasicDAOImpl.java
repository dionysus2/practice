package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dionysus.wine.dao.BasicInfoDAO;
import dionysus.wine.vo.BasicInfo;

public class BasicDAOImpl implements BasicInfoDAO {

	@Override
	public int basicInfoInsert(Connection conn, BasicInfo basicinfo) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
	}

	@Override
	public int basicInfoDelete(Connection conn, int basicinfoid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int basicInfoUpdate(Connection conn, BasicInfo basicinfo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Login(Connection conn, String basicInfoUserName, String basicInfoPwd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int basicInfoUserNameCheck(Connection conn, String basicInfoUserName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
