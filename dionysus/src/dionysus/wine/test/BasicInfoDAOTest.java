package dionysus.wine.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.BasicInfo;

public class BasicInfoDAOTest {
	private BasicInfoDAOImpl dao= new BasicInfoDAOImpl();
	@Test
	public void insert(){
		Connection conn= JDBCUtil.getConnection();
		String basicInfoUsername= "asas";
		String basicInfoPwd= "1234";
		String basicInfoEmail= "asas";
		try {
			int result=dao.basicInfoInsert(conn, new BasicInfo(basicInfoUsername, basicInfoPwd, basicInfoEmail));
			//	int result= dao.Login(conn, "asas", "1234");
			assertThat(result, is(2));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
	}
	public void login(){
		
	}
}
