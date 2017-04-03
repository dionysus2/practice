package dionysus.wine.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Test;

import dionysus.wine.daoimpl.ResInfoDaoImpl;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.ResInfo;

public class ResInfoTest {
	@Test
	public void selectAllTest(){
		Connection conn= JDBCUtil.getConnection();
		int startRow = 1;
		int lastRow= 10;
		try {
			ArrayList<ResInfo> list= new ResInfoDaoImpl().selectResInfoAllList(conn, startRow, lastRow);
			assertThat(list.size(), is(0));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
	}
}
