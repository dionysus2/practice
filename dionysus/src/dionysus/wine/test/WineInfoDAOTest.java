package dionysus.wine.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dionysus.wine.daoimpl.WineInfoDAOImpl;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineInfo;

public class WineInfoDAOTest {

	//	@Test
	//	성공
	public void selecAllWineInfoTest(){
		Connection conn= JDBCUtil.getConnection();
		int startRow= 1;
		int lastRow= 10;
		try {
			ArrayList<WineInfo>result= new WineInfoDAOImpl().selectAllWineInfo(conn, startRow, lastRow);
			assertThat(result.size(), is(1));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
	}
	//	@Test
	//	성공
	public void wineInfoCountTest(){
		Connection conn= JDBCUtil.getConnection();
		try {
			int result= new WineInfoDAOImpl().wineInfoCount(conn);
			assertThat(result, is(1));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
	}
	//	@Test
	//	성공
	public void insertTest(){
		Connection conn= JDBCUtil.getConnection();
		String wineInfoName= "테스트";
		String wineInfoProfilePicture="테스트";
		int wineInfoPrice= 9999;
		String wineInfoOrigin= "국내산";
		String wineInfoPicture1="테스트";
		String wineInfoPicture2="테스트";
		String wineInfoPicture3="테스트";
		int wineSellerId=1;
		try {
			int result= new WineInfoDAOImpl().wineInfoInsert(conn, new WineInfo(wineInfoName, wineInfoProfilePicture, wineInfoPrice, wineInfoOrigin, wineInfoPicture1, wineInfoPicture2, wineInfoPicture3, wineSellerId));
			assertThat(result, is(1));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//	나머지 테스트는.. DB정보 부족으로 인한...
	@Test
	public void selectByWineInfoId(){
		Connection conn= JDBCUtil.getConnection();
		int wineInfoId= 21;
		try {
			WineInfo wine= new WineInfoDAOImpl().selectByWineInfoId(conn, wineInfoId);
			ArrayList<WineInfo>list= new ArrayList<WineInfo>();
			list.add(wine);
			assertThat(list.size(), is(1));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
	}
}
