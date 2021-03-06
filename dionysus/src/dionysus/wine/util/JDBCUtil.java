package dionysus.wine.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCUtil {
	private static String url= "jdbc:oracle:thin:@192.168.0.180:1521:XE";
	private static String id= "DIONYSUS";
	private static String pw= "1234";
	private static Logger logger= LoggerFactory.getLogger(JDBCUtil.class);
	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, id, pw);
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info("JDBCUtil드라이버 연결 실패");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void close(PreparedStatement pstm, ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
		if(pstm!=null){
			try {
				pstm.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
	}
}
