package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.ResInfoDAO;
import dionysus.wine.query.ResInfoQuery;
import dionysus.wine.query.WineInfoQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.ResInfo;

public class ResInfoDaoImpl implements ResInfoDAO {
	
	public ResInfo makerResInfo(ResultSet rs)throws Exception{
		ResInfo resInfo = new ResInfo();
		resInfo.setResInfoId(rs.getInt("res_Info_Id"));
		resInfo.setResInfoName(rs.getString("res_Info_Name"));
		resInfo.setResInfoPicture1(rs.getString("res_Info_Picture1"));
		resInfo.setResInfoPicture2(rs.getString("res_Info_Picture2"));
		resInfo.setResInfoPicture3(rs.getString("res_Info_Picture3"));
		resInfo.setResInfoAvailableSeat(rs.getInt("res_Info_Available_Seat"));
		resInfo.setResInfoOpeningHours(rs.getString("res_Info_Opening_Hours"));
		resInfo.setResInfoWebsite(rs.getString("res_Info_Website"));
		resInfo.setResId(rs.getInt("res_Id"));
		return resInfo;
	}
	
   //레스토랑 정보 페이지별 리스트 조회	    
	@Override
	public ArrayList<ResInfo>selectResInfoAllList(Connection conn,  int startRow, int  lastRow) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.selectResInfoAllList);	
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			ArrayList<ResInfo>list = new ArrayList<>();
			ResInfo resInfo = new ResInfo();
			rs= pstmt.executeQuery();
			while(rs.next()){
				resInfo.setResInfoId(rs.getInt("RES_INFO_ID"));
				resInfo.setResInfoName(rs.getString("RES_INFO_NAME"));
				resInfo.setResInfoPicture1(rs.getString("RES_INFO_PICTURE1"));
				resInfo.setResInfoPicture2(rs.getString("RES_INFO_PICTURE2"));
				resInfo.setResInfoPicture3(rs.getString("RES_INFO_PICTURE3"));
				resInfo.setResInfoAvailableSeat(rs.getInt("RES_INFO_AVAILABLE_SEAT"));
				resInfo.setResInfoOpeningHours(rs.getString("RES_INFO_OPENING_HOURS"));
				resInfo.setResInfoWebsite(rs.getString("RES_INFO_WEBSITE"));
				resInfo.setResId(rs.getInt("RES_ID"));
				list.add(resInfo);
				}
			 return list;
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,rs);
		}
	}
	//레스토랑 정보 count조회
	@Override
	public int selectByCount(Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.selectCount);	
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,rs);
		}
		return 0;
	}
	
	// 레스토랑 정보 업주별 조회	
	@Override
	public  ArrayList<ResInfo>selectByResOwnerResInfo(Connection conn, int resId, int startRow, int  lastRow) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ResInfo>list = new ArrayList<>();
		ResInfo resInfo = new ResInfo();
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.selectByResOwnerResInfo);	
			pstmt.setInt(1, resId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, lastRow);
			rs = pstmt.executeQuery();
		    while(rs.next()){
		    	resInfo.setResInfoId(rs.getInt("res_Info_Id"));
				resInfo.setResInfoName(rs.getString("res_Info_Name"));
				resInfo.setResInfoPicture1(rs.getString("res_Info_Picture1"));
				resInfo.setResInfoPicture2(rs.getString("res_Info_Picture2"));
				resInfo.setResInfoPicture3(rs.getString("res_Info_Picture3"));
				resInfo.setResInfoAvailableSeat(rs.getInt("res_Info_Available_Seat"));
				resInfo.setResInfoOpeningHours(rs.getString("res_Info_Opening_Hours"));
				resInfo.setResInfoWebsite(rs.getString("res_Info_Website"));
				resInfo.setResId(rs.getInt("res_Id"));
				list.add(resInfo);
				}
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,rs);
		}
		return null;
	}
	// 레스토랑 정보 업주별 count조회	
	@Override
	public int ResOwnerResInfoCount(Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.ResOwnerResInfoCount);	
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,rs);
		}
		return 0;
	}

	// 레스토랑 정보 추가			
	@Override
	public int insertResInfo(Connection conn, ResInfo resInfo) throws Exception {
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.insert);	
			pstmt.setInt(1, resInfo.getResInfoId());
			pstmt.setString(2, resInfo.getResInfoName());
			pstmt.setString(3, resInfo.getResInfoPicture1());
			pstmt.setString(4, resInfo.getResInfoPicture2());
			pstmt.setString(5, resInfo.getResInfoPicture3());
			pstmt.setInt(6, resInfo.getResInfoAvailableSeat());
			pstmt.setString(7, resInfo.getResInfoOpeningHours());
			pstmt.setString(8, resInfo.getResInfoWebsite());
			pstmt.setInt(9, resInfo.getResId());
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,null);
		}
	
	}
	// 레스토랑 정보 삭제	
	@Override
	public int deleteResInfo(Connection conn, int resInfoId) throws Exception {
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.delete);	
			pstmt.setInt(1,  resInfoId);
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,null);
		}
	
	}
	// 레스토랑 정보 갱신
	@Override
	public int updateResInfo(Connection conn, ResInfo resInfo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.update);	
			pstmt.setString(1, resInfo.getResInfoName());
			pstmt.setString(2, resInfo.getResInfoPicture1());
			pstmt.setString(3, resInfo.getResInfoPicture2());
			pstmt.setString(4, resInfo.getResInfoPicture3());
			pstmt.setInt(5, resInfo.getResInfoAvailableSeat());
			pstmt.setString(6, resInfo.getResInfoOpeningHours());
			pstmt.setString(7, resInfo.getResInfoWebsite());
			pstmt.setInt(8, resInfo.getResId());
			pstmt.setInt(9, resInfo.getResInfoId());
			return pstmt.executeUpdate();
			
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,rs);
		}
		
	}
	//레스토랑정보 업데이트 시작
	@Override
	public ResInfo selectByResInfoId(Connection conn, int resInfoId) throws Exception {
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try{
		pstmt = conn.prepareStatement(ResInfoQuery.selectByResInfoId);
		pstmt.setInt(1, resInfoId);
		rs=pstmt.executeQuery();
		if(rs.next()){
			ResInfo resInfo = new ResInfo();
			resInfo.setResInfoName(rs.getString("res_Info_Name"));
			resInfo.setResInfoPicture1(rs.getString("res_Info_Picture1"));
			resInfo.setResInfoPicture2(rs.getString("res_Info_Picture2"));
			resInfo.setResInfoPicture3(rs.getString("res_Info_Picture3"));
			resInfo.setResInfoAvailableSeat(rs.getInt("res_Info_Available_Seat"));
			resInfo.setResInfoOpeningHours(rs.getString("res_Info_Opening_Hours"));
			resInfo.setResInfoWebsite(rs.getString("res_Info_Website"));
			resInfo.setResId(rs.getInt("res_Id"));
			return resInfo;
		}
		}catch (SQLException e) {
           throw e;
		}finally{
			JDBCUtil.close(pstmt, rs);
		}
	  return null;
	}
//아이디별 레스토랑업주 정보 가져오기.
	@Override
	public int selectByBasicId(Connection conn, String basicInfoUsername) throws SQLException {
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(ResInfoQuery.selectByResId);
			pstmt.setString(1, basicInfoUsername);
			rs= pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		finally{
			JDBCUtil.close(pstmt, rs);
		}
		return 0;
	}
		
	


}
