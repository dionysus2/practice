package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dionysus.wine.vo.WineInfo;

public interface WineInfoDAO {
	/*										리턴				매개변수	
	 *	와인상품 전체리스트 조회		ArrayList<wineInfo>			Connection
	 *	단가높은순 조회					ArrayList<wineInfo>			Connection, 
	 *	단가낮은순 조회					ArrayList<WineInfo>			Connection, 
	 *	와인상품 Count						int						Connection
	 *
	 *	와인상품 원산지별 조회			ArrauList<wineInfo>					Connection, 원산지
	 *	와인상품 원산지별 Count			int									Connection
	 *
	 *	와인상품 추가						int								Connection, WineInfo
	 *	와인상품 정보수정					wineInfo 						Connection,	WineInfo
	 *	와인상품 삭제						int								Connection, 와인이름
	 *	회사리스트별 상품조회 	ArrayList<wineInfo>							Connection, 회사번호
	 *	와인회사별 Count						int							Connection, 회사번호
	 *
	 *	와인번호(와인이름)별 와인상세정보 조회 WineInfo 		Connection, wineInfoId
	 */
	public ArrayList<WineInfo> selectAllWineInfo(Connection conn, int startRow, int lastRow)throws SQLException;
	public ArrayList<WineInfo> selectWinePriceMax(Connection conn, int startRow, int lastRow)throws SQLException;
	public ArrayList<WineInfo> selectWinePriceMin(Connection conn, int startRow, int lastRow)throws SQLException;
	public int wineInfoCount(Connection conn)throws SQLException;
	public ArrayList<WineInfo> selectWineCountry(Connection conn, String wineInfoCountry, int startRow, int lastRow)throws SQLException;
	public int wineOriginCount(Connection conn)throws SQLException;
	public int wineInfoInsert(Connection conn, WineInfo wine)throws SQLException;
	public int wineInfoUpdate(Connection conn, WineInfo wine)throws SQLException;
	public int wineInfoDelete(Connection conn, String wineInfoName)throws SQLException;
	public ArrayList<WineInfo> selectByWineSellerWineInfo(Connection conn, int wineSellerId, int startRow, int lastRow)throws SQLException;
	public int wineSellerWineInfoCount(Connection conn)throws SQLException;
	public WineInfo selectByWineInfoId(Connection conn, int wineInfoId)throws SQLException;
}
