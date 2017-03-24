package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dionysus.wine.dao.WineInfoDAO;
import dionysus.wine.query.WineInfoQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.BasicInfo;
import dionysus.wine.vo.WineInfo;

public class WineInfoDAOImpl implements WineInfoDAO {
	
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
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectByOriginCount);
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
	public int wineInfoInsert(Connection conn, WineInfo wine) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.insert);
			pstm.setString(1, wine.getWineInfoName());
			pstm.setString(2, wine.getWineInfoProfilePicture());
			pstm.setInt(3, wine.getWineInfoPrice());
			pstm.setString(4, wine.getWineInfoOrigin());
			pstm.setString(5, wine.getWineInfoPicture1());
			pstm.setString(6, wine.getWineInfoPicture2());
			pstm.setString(7, wine.getWineInfoPicture3());
			pstm.setInt(8, wine.getWineSellerId());
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
	public int wineInfoUpdate(Connection conn, WineInfo wine) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.update);
			pstm.setString(1, wine.getWineInfoProfilePicture());
			pstm.setInt(2, wine.getWineInfoPrice());
			pstm.setString(3, wine.getWineInfoOrigin());
			pstm.setString(4, wine.getWineInfoPicture1());
			pstm.setString(5, wine.getWineInfoPicture2());
			pstm.setString(6, wine.getWineInfoPicture3());
			pstm.setInt(7, wine.getWineSellerId());
			pstm.setString(8, wine.getWineInfoName());
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
	public int wineInfoDelete(Connection conn, String wineInfoName) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.delete);
			pstm.setString(1, wineInfoName);
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
	public ArrayList<HashMap<String, Object>> selectByWineSellerWineInfo(Connection conn, String wineSellelrUsername, int startRow,
			int lastRow) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectByWineSeller);
			pstm.setString(1, wineSellelrUsername);
			pstm.setInt(2, startRow);
			pstm.setInt(3, lastRow);
			rs= pstm.executeQuery();
			ArrayList<HashMap<String, Object>>list= new ArrayList<HashMap<String, Object>>();
			while(rs.next()){
				WineInfo wine= new WineInfo();
				BasicInfo basic= new BasicInfo();
				HashMap<String, Object> map= new HashMap<String, Object>();
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoOrigin(rs.getString("WINE_INFO_ORIGIN"));
				wine.setWineInfoPicture1(rs.getString("WINE_INFO_PICTURE1"));
				wine.setWineInfoPicture2(rs.getString("WINE_INFO_PICTURE2"));
				wine.setWineInfoPicture3(rs.getString("WINE_INFO_PICTURE3"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				basic.setBasicInfoUsername(rs.getString("BASIC_INFO_USERNAME"));
				map.put("wine", wine);
				map.put("basic", basic);
				list.add(map);
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
	public int wineSellerWineInfoCount(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectByWineSellerCount);
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
}
