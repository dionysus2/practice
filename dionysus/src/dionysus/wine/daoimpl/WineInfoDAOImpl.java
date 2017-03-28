package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.dao.WineInfoDAO;
import dionysus.wine.query.WineInfoQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineInfo;

public class WineInfoDAOImpl implements WineInfoDAO {
	private Logger logger= LoggerFactory.getLogger(WineInfoDAOImpl.class);
	
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
				wine.setWineInfoABV(rs.getString("WINE_INFO_ABV"));
				wine.setWineInfoAcidity(rs.getString("WINE_INFO_ACIDITY"));
				wine.setWineInfoBody(rs.getString("WINE_INFO_BODY"));
				wine.setWineInfoCapacity(rs.getString("WINE_INFO_CAPACITY"));
				wine.setWineInfoClassification(rs.getString("WINE_INFO_CLASSIFICATION"));
				wine.setWineInfoCountry(rs.getString("WINE_INFO_COUNTRY"));
				wine.setWineInfoFlavors(rs.getString("WINE_INFO_FLAVORS"));
				wine.setWineInfoGrapes(rs.getString("WINE_INFO_GRAPES"));
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoImporter(rs.getString("WINE_INFO_IMPORTER"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineInfoRegion(rs.getString("WINE_INFO_REGION"));
				wine.setWineInfoSweetness(rs.getString("WINE_INFO_SWEETNESS"));
				wine.setWineInfoType(rs.getString("WINE_INFO_TYPE"));
				wine.setWineInfoVintage(rs.getString("WINE_INFO_VINTAGE"));
				wine.setWineInfoWinery(rs.getString("WINE_INFO_WINERY"));
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
	public ArrayList<WineInfo> selectWinePriceMax(Connection conn, int startRow, int lastRow) throws SQLException {
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
				wine.setWineInfoABV(rs.getString("WINE_INFO_ABV"));
				wine.setWineInfoAcidity(rs.getString("WINE_INFO_ACIDITY"));
				wine.setWineInfoBody(rs.getString("WINE_INFO_BODY"));
				wine.setWineInfoCapacity(rs.getString("WINE_INFO_CAPACITY"));
				wine.setWineInfoClassification(rs.getString("WINE_INFO_CLASSIFICATION"));
				wine.setWineInfoCountry(rs.getString("WINE_INFO_COUNTRY"));
				wine.setWineInfoFlavors(rs.getString("WINE_INFO_FLAVORS"));
				wine.setWineInfoGrapes(rs.getString("WINE_INFO_GRAPES"));
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoImporter(rs.getString("WINE_INFO_IMPORTER"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineInfoRegion(rs.getString("WINE_INFO_REGION"));
				wine.setWineInfoSweetness(rs.getString("WINE_INFO_SWEETNESS"));
				wine.setWineInfoType(rs.getString("WINE_INFO_TYPE"));
				wine.setWineInfoVintage(rs.getString("WINE_INFO_VINTAGE"));
				wine.setWineInfoWinery(rs.getString("WINE_INFO_WINERY"));
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
	public ArrayList<WineInfo> selectWinePriceMin(Connection conn, int startRow, int lastRow)throws SQLException {
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
				wine.setWineInfoABV(rs.getString("WINE_INFO_ABV"));
				wine.setWineInfoAcidity(rs.getString("WINE_INFO_ACIDITY"));
				wine.setWineInfoBody(rs.getString("WINE_INFO_BODY"));
				wine.setWineInfoCapacity(rs.getString("WINE_INFO_CAPACITY"));
				wine.setWineInfoClassification(rs.getString("WINE_INFO_CLASSIFICATION"));
				wine.setWineInfoCountry(rs.getString("WINE_INFO_COUNTRY"));
				wine.setWineInfoFlavors(rs.getString("WINE_INFO_FLAVORS"));
				wine.setWineInfoGrapes(rs.getString("WINE_INFO_GRAPES"));
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoImporter(rs.getString("WINE_INFO_IMPORTER"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineInfoRegion(rs.getString("WINE_INFO_REGION"));
				wine.setWineInfoSweetness(rs.getString("WINE_INFO_SWEETNESS"));
				wine.setWineInfoType(rs.getString("WINE_INFO_TYPE"));
				wine.setWineInfoVintage(rs.getString("WINE_INFO_VINTAGE"));
				wine.setWineInfoWinery(rs.getString("WINE_INFO_WINERY"));
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
	public ArrayList<WineInfo> selectWineCountry(Connection conn, String wineInfoCountry, int startRow, int lastRow) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectByOrigin);
			pstm.setString(1, wineInfoCountry);
			pstm.setInt(2, startRow);
			pstm.setInt(3, lastRow);
			rs= pstm.executeQuery();
			ArrayList<WineInfo>list= new ArrayList<WineInfo>();
			while(rs.next()){
				WineInfo wine= new WineInfo();
				wine.setWineInfoABV(rs.getString("WINE_INFO_ABV"));
				wine.setWineInfoAcidity(rs.getString("WINE_INFO_ACIDITY"));
				wine.setWineInfoBody(rs.getString("WINE_INFO_BODY"));
				wine.setWineInfoCapacity(rs.getString("WINE_INFO_CAPACITY"));
				wine.setWineInfoClassification(rs.getString("WINE_INFO_CLASSIFICATION"));
				wine.setWineInfoFlavors(rs.getString("WINE_INFO_FLAVORS"));
				wine.setWineInfoGrapes(rs.getString("WINE_INFO_GRAPES"));
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoImporter(rs.getString("WINE_INFO_IMPORTER"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineInfoRegion(rs.getString("WINE_INFO_REGION"));
				wine.setWineInfoSweetness(rs.getString("WINE_INFO_SWEETNESS"));
				wine.setWineInfoType(rs.getString("WINE_INFO_TYPE"));
				wine.setWineInfoVintage(rs.getString("WINE_INFO_VINTAGE"));
				wine.setWineInfoWinery(rs.getString("WINE_INFO_WINERY"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
				list.add(wine);
			}
			return list;
		} 
		catch (SQLException e) {
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
			pstm.setInt(4, wine.getWineSellerId());
			pstm.setString(5, wine.getWineInfoCapacity());
			pstm.setString(6, wine.getWineInfoCountry());
			pstm.setString(7, wine.getWineInfoRegion());
			pstm.setString(8, wine.getWineInfoWinery());
			pstm.setString(9, wine.getWineInfoImporter());
			pstm.setString(10, wine.getWineInfoVintage());
			pstm.setString(11, wine.getWineInfoGrapes());
			pstm.setString(12, wine.getWineInfoABV());
			pstm.setString(13, wine.getWineInfoType());
			pstm.setString(14, wine.getWineInfoClassification());
			pstm.setString(15, wine.getWineInfoFlavors());
			pstm.setString(16, wine.getWineInfoSweetness());
			pstm.setString(17, wine.getWineInfoAcidity());
			pstm.setString(18, wine.getWineInfoBody());
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
			pstm.setString(3, wine.getWineInfoCapacity());
			pstm.setString(4, wine.getWineInfoCountry());
			pstm.setString(5, wine.getWineInfoRegion());
			pstm.setString(6, wine.getWineInfoWinery());
			pstm.setString(7, wine.getWineInfoImporter());
			pstm.setString(8, wine.getWineInfoVintage());
			pstm.setString(9, wine.getWineInfoGrapes());
			pstm.setString(10, wine.getWineInfoABV());
			pstm.setString(11, wine.getWineInfoType());
			pstm.setString(12, wine.getWineInfoClassification());
			pstm.setString(13, wine.getWineInfoFlavors());
			pstm.setString(14, wine.getWineInfoSweetness());
			pstm.setString(15, wine.getWineInfoAcidity());
			pstm.setString(16, wine.getWineInfoBody());
			pstm.setString(17, wine.getWineInfoName());
			pstm.setInt(18, wine.getWineSellerId());
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
	public ArrayList<WineInfo> selectByWineSellerWineInfo(Connection conn, int wineSellerId, int startRow,
			int lastRow) throws SQLException  {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectByWineSeller);
			pstm.setInt(1, wineSellerId);
			pstm.setInt(2, startRow);
			pstm.setInt(3, lastRow);
			rs= pstm.executeQuery();
			ArrayList<WineInfo>list= new ArrayList<WineInfo>();
			while(rs.next()){
				WineInfo wine= new WineInfo();
				wine.setWineInfoABV(rs.getString("WINE_INFO_ABV"));
				wine.setWineInfoAcidity(rs.getString("WINE_INFO_ACIDITY"));
				wine.setWineInfoBody(rs.getString("WINE_INFO_BODY"));
				wine.setWineInfoCapacity(rs.getString("WINE_INFO_CAPACITY"));
				wine.setWineInfoClassification(rs.getString("WINE_INFO_CLASSIFICATION"));
				wine.setWineInfoCountry(rs.getString("WINE_INFO_COUNTRY"));
				wine.setWineInfoFlavors(rs.getString("WINE_INFO_FLAVORS"));
				wine.setWineInfoGrapes(rs.getString("WINE_INFO_GRAPES"));
				wine.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				wine.setWineInfoImporter(rs.getString("WINE_INFO_IMPORTER"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineInfoRegion(rs.getString("WINE_INFO_REGION"));
				wine.setWineInfoSweetness(rs.getString("WINE_INFO_SWEETNESS"));
				wine.setWineInfoType(rs.getString("WINE_INFO_TYPE"));
				wine.setWineInfoVintage(rs.getString("WINE_INFO_VINTAGE"));
				wine.setWineInfoWinery(rs.getString("WINE_INFO_WINERY"));
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
	
	@Override
	public WineInfo selectByWineInfoId(Connection conn, int wineInfoId) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectByWineInfoId);
			pstm.setInt(1, wineInfoId);
			rs= pstm.executeQuery();
			if(rs.next()){
				WineInfo wine= new WineInfo();
				wine.setWineInfoABV(rs.getString("WINE_INFO_ABV"));
				wine.setWineInfoAcidity(rs.getString("WINE_INFO_ACIDITY"));
				wine.setWineInfoBody(rs.getString("WINE_INFO_BODY"));
				wine.setWineInfoCapacity(rs.getString("WINE_INFO_CAPACITY"));
				wine.setWineInfoClassification(rs.getString("WINE_INFO_CLASSIFICATION"));
				wine.setWineInfoCountry(rs.getString("WINE_INFO_COUNTRY"));
				wine.setWineInfoFlavors(rs.getString("WINE_INFO_FLAVORS"));
				wine.setWineInfoGrapes(rs.getString("WINE_INFO_GRAPES"));
				wine.setWineInfoImporter(rs.getString("WINE_INFO_IMPORTER"));
				wine.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				wine.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				wine.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				wine.setWineInfoRegion(rs.getString("WINE_INFO_REGION"));
				wine.setWineInfoSweetness(rs.getString("WINE_INFO_SWEETNESS"));
				wine.setWineInfoType(rs.getString("WINE_INFO_TYPE"));
				wine.setWineInfoVintage(rs.getString("WINE_INFO_VINTAGE"));
				wine.setWineInfoWinery(rs.getString("WINE_INFO_WINERY"));
				wine.setWineSellerId(rs.getInt("WINE_SELLER_ID"));
				logger.info("DAO와인정보 상세검색:"+wine);
				return wine;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return null;
	}
	
	@Override
	public int selectByBasicId(Connection conn, String basicInfoUsername){
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		ResultSet rs= null;
		try {
			pstm= conn.prepareStatement(WineInfoQuery.selectByWineSellerId);
			pstm.setString(1, basicInfoUsername);
			rs= pstm.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			JDBCUtil.close(pstm, rs);
		}
		return 0;
	}
}
