package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.vo.WineDelivery;

public interface WineDeliveryDAO {
	/*
	 *					 				리턴			 		매개변수
	 *배송 추가							int						Connection, WineDelivery
	 *배송 리스트 조회					ArrayList<WineDelivery>	Connection
	 *Count
	 *배송번호로 조회					WineDelivery			Connection, 배송번호
	 *회원이름으로 배송리스트 조회		ArrayList<WineDelivery>	Connection, 회원이름
	 *배송진행 사항 수정				String					Connection, 배송진행사항
	 *와인회사명으로 배송리스트 조회	ArrayList<WineDelivery>	Connection, 와인회사번호
	 *레스토랑명으로 배송리스트 조회	ArrayList<WineDelivery>	Connection, 레스토랑명
	 *
	 */
	
	//배송추가
	public int insertWineDelivery(Connection conn, WineDelivery wine)throws SQLException;
	
	//페이지별 배송리스트 조회 
	public ArrayList<WineDelivery> selectWineDeliveryAllList(Connection conn, int startRow, int lastRow, int wineDeliveryId)throws SQLException;
	
	//배송번호로 조회
	public WineDelivery selectWineDeliveryCustomerId(Connection conn, int wineDeliveryId)throws SQLException;
	
	//회원이름으로 배송리스트 조회
	public ArrayList<WineDelivery> selectWineDeliveryCustomerId(Connection conn, int startRow, int lastRow, int customerId)throws SQLException;
	
	//배송진행사항 수정
	public int updateWineDelivery(Connection conn, WineDelivery WineDelivery)throws SQLException;
	
	//와인회사명으로 배송리스트 조회
	public ArrayList<WineDelivery> selectWineDeliveryWineSellerId(Connection conn, int startRow, int lastRow, int wineSellerId)throws SQLException;
	
	//레스토랑며으로 배송리스트 조회
	public ArrayList<WineDelivery> selectWineDeliveryResId(Connection conn, int startRow, int lastRow, int resId)throws SQLException;
}
