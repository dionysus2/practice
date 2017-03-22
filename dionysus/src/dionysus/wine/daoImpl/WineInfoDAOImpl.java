package dionysus.wine.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.WineInfoDAO;
import dionysus.wine.query.WineInfoQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineInfo;

public class WineInfoDAOImpl implements WineInfoDAO {
	/*										리턴				매개변수	
	 *	와인상품 전체리스트 조회		ArrayList<wineInfo>			Connection
	 *	단가높은순 조회					ArrayList<wineInfo>			Connection, 와인가격
	 *	단가낮은순 조회					ArrayList<WineInfo>			Connection, 와인가격
	 *	와인상품 Count						int						Connection
	 *
	 *	와인상품 원산지별 조회			ArrauList<wineInfo>					Connection, 원산지
	 *	와인상품 원산지별 Count			int									Connection
	 *
	 *	와인상품 추가						int								Connection, WineInfo
	 *	와인상품 정보수정					wineInfo 						Connection,	WineInfo
	 *	와인상품 삭제						int								Connection, 와인이름
	 *	회사리스트별 상품조회 	ArrayList<wineInfo>							Connection, 회사이름
	 *	와인회사별 Count						int							Connection, 회사번호
	 */
	@Override
	public ArrayList<WineInfo> selectAllWineInfo(Connection conn, int startRow, int lastRow) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectAll);
			pstm.setInt(1, startRow);
			pstm.setInt(2, lastRow);
			rs= pstm.executeQuery();
			ArrayList<WineInfo>list= new ArrayList<WineInfo>();
			while(rs.next()){
				WineInfo wine= new WineInfo();
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoOrigin(rs.getString("WINE_INFO_ORIGIN"));
				wine.setWineInfoPicture1(rs.getString("WINE_INFO_PICTURE1"));
				wine.setWineInfoPicture2(rs.getString("WINE_INFO_PICTURE2"));
				wine.setWineInfoPicture3(rs.getString("WINE_INFO_PICTURE3"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
				list.add(wine);
			}
			return list;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
	}

	@Override
	public ArrayList<WineInfo> selectWinePriceMax(Connection conn, int wineInfoPrice, int startRow, int lastRow) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.sellMax);
			pstm.setInt(1, startRow);
			pstm.setInt(2, lastRow);
			rs= pstm.executeQuery();
			ArrayList<WineInfo>list= new ArrayList<WineInfo>();
			while(rs.next()){
				WineInfo wine= new WineInfo();
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoOrigin(rs.getString("WINE_INFO_ORIGIN"));
				wine.setWineInfoPicture1(rs.getString("WINE_INFO_PICTURE1"));
				wine.setWineInfoPicture2(rs.getString("WINE_INFO_PICTURE2"));
				wine.setWineInfoPicture3(rs.getString("WINE_INFO_PICTURE3"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
				list.add(wine);
			}
			return list;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
	}

	@Override
	public ArrayList<WineInfo> selectWinePriceMin(Connection conn, int wineInfoPrice, int startRow, int lastRow)throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.sellMin);
			pstm.setInt(1, startRow);
			pstm.setInt(2, lastRow);
			rs= pstm.executeQuery();
			ArrayList<WineInfo>list= new ArrayList<WineInfo>();
			while(rs.next()){
				WineInfo wine= new WineInfo();
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoOrigin(rs.getString("WINE_INFO_ORIGIN"));
				wine.setWineInfoPicture1(rs.getString("WINE_INFO_PICTURE1"));
				wine.setWineInfoPicture2(rs.getString("WINE_INFO_PICTURE2"));
				wine.setWineInfoPicture3(rs.getString("WINE_INFO_PICTURE3"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
				list.add(wine);
			}
			return list;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
	}

	@Override
	public int wineInfoCount(Connection conn) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectAllCount);
			rs= pstm.executeQuery();
			if(rs.next()){
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
		return 0;
	}

	@Override
	public ArrayList<WineInfo> selectWineOrigin(Connection conn, String wineInfoOrigin, int startRow, int lastRow) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectByOrigin);
			pstm.setString(1, wineInfoOrigin);
			pstm.setInt(2, startRow);
			pstm.setInt(3, lastRow);
			rs= pstm.executeQuery();
			ArrayList<WineInfo>list= new ArrayList<WineInfo>();
			while(rs.next()){
				WineInfo wine= new WineInfo();
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoOrigin(rs.getString("WINE_INFO_ORIGIN"));
				wine.setWineInfoPicture1(rs.getString("WINE_INFO_PICTURE1"));
				wine.setWineInfoPicture2(rs.getString("WINE_INFO_PICTURE2"));
				wine.setWineInfoPicture3(rs.getString("WINE_INFO_PICTURE3"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
				list.add(wine);
			}
			return list;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
	}

	@Override
	public int wineOriginCount(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int wineInfoInsert(Connection conn, WineInfo wine) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int wineInfoUpdate(Connection conn, WineInfo wine) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int wineInfoDelete(Connection conn, String wineInfoName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<WineInfo> selectByWineSellerWineInfo(Connection conn, String wineInfoName, int startRow,
			int lastRow) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int wineSellerWineInfoCount(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
