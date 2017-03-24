package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.ResInfoDAO;
import dionysus.wine.query.ResInfoQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Res;
import dionysus.wine.vo.ResInfo;

public class ResInfoDaoImpl implements ResInfoDAO {
	
	public ResInfo makerResInfo(ResultSet rs)throws Exception{
		ResInfo resInfo = new ResInfo();
		resInfo.setResInfoId(rs.getInt("resInfoId"));
		resInfo.setResInfoName(rs.getString("resInfoName"));
		resInfo.setResInfoPicture1(rs.getString("resInfoPicture1"));
		resInfo.setResInfoPicture2(rs.getString("resInfoPicture2"));
		resInfo.setResInfoPicture3(rs.getString("resInfoPicture3"));
		resInfo.setResInfoAvailableSeat(rs.getInt("resInfoAvailableSeat"));
		resInfo.setResInfoOpeningHours(rs.getString("resInfoOpeningHours"));
		resInfo.setResInfoWebsite(rs.getString("resInfoWebsite"));
		resInfo.setResId(rs.getInt("resId"));
		return resInfo;
	}
	
   //레스토랑 정보 페이지별 리스트 조회	
	@Override
	public ArrayList<ResInfo> selectResInfoAllList(Connection conn,  int startRow, int  lastRow) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ResInfo>list = new ArrayList<>();
		ResInfo resInfo = new ResInfo();
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.selectResInfoAllList);	
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			while(rs.next()){
				resInfo.setResInfoId(rs.getInt("resInfoId"));
				resInfo.setResInfoName(rs.getString("resInfoName"));
				resInfo.setResInfoPicture1(rs.getString("resInfoPicture1"));
				resInfo.setResInfoPicture2(rs.getString("resInfoPicture2"));
				resInfo.setResInfoPicture3(rs.getString("resInfoPicture3"));
				resInfo.setResInfoAvailableSeat(rs.getInt("resInfoAvailableSeat"));
				resInfo.setResInfoOpeningHours(rs.getString("resInfoOpeningHours"));
				resInfo.setResInfoWebsite(rs.getString("resInfoWebsite"));
				resInfo.setResId(rs.getInt("resId"));
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
		return -1;
	}
	
	// 레스토랑 정보 업주별 조회	
	@Override
	public ResInfo selectByResOwnerResInfo(Connection conn, int resId) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.selectByResOwnerResInfo);	
			pstmt.setInt(1, resId);
			rs = pstmt.executeQuery();
			ArrayList<ResInfo> list =new ArrayList<>();
			if(rs.next())
			return makerResInfo(rs);	
		}catch (SQLException e) {
			throw e;
		}finally{
			JDBCUtil.close(pstmt,rs);
		}
		return null;
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
	public int deleteResInfo(Connection conn, int resId) throws Exception {
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(ResInfoQuery.delete);	
			pstmt.setInt(1, resId);
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

}