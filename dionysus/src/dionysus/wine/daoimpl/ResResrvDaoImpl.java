package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.ResReservDAO;
import dionysus.wine.query.ResResrvQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Res;
import dionysus.wine.vo.ResInfo;
import dionysus.wine.vo.ResReserv;
import dionysus.wine.vo.WineOrder;

public  class ResResrvDaoImpl implements ResReservDAO {

//	예약접수 전체 리스트 출력	
	@Override
	public ArrayList<ResReserv>selectAllReserv(Connection conn, int startRow, int lastRow) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    ArrayList<ResReserv> list = new ArrayList<>();
	    ResReserv resReserv = new ResReserv();
		try{
		pstmt =conn.prepareStatement(ResResrvQuery.selectAllReserv);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, lastRow);
		while(rs.next()){
			resReserv.setResResrvId(rs.getInt("resResrvId"));
			resReserv.setResResrvDate(rs.getDate("resResrvDate"));
			resReserv.setResResrvFee(rs.getInt("resResrvFee"));
			resReserv.setCustomerId(rs.getInt("customerId"));
			resReserv.setResId(rs.getInt("resId"));
			list.add(resReserv);
		}
		return list;
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}
	
	}

//	레스토랑별 예약접수 리스트 출력
	@Override
	public ArrayList<ResReserv> selectByResReserv(Connection conn, int resInfoId) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ResReserv> list = new ArrayList<>();
		ResReserv resReserv = new ResReserv();
		try{
		pstmt =conn.prepareStatement(ResResrvQuery.selectByResReserv);
		pstmt.setInt(1, resInfoId);
		while(rs.next()){
			resReserv.setResResrvId(rs.getInt("resResrvId"));
			resReserv.setResResrvDate(rs.getDate("resResrvDate"));
			resReserv.setResResrvFee(rs.getInt("resResrvFee"));
			resReserv.setCustomerId(rs.getInt("customerId"));
			resReserv.setResId(rs.getInt("resId"));
			list.add(resReserv);
		}
		return list;
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}
	
	}
//	월별 예약접수 리스트 출력	
	@Override
	public ArrayList<ResReserv> selectByMonthReserv(Connection conn, Date resResrvDate) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ResReserv> list = new ArrayList<>();
		ResReserv resReserv = new ResReserv();
		try{
		pstmt =conn.prepareStatement(ResResrvQuery.selectByMonthReserv);	
		pstmt.setDate(1, resResrvDate);
		while(rs.next()){
			resReserv.setResResrvId(rs.getInt("resResrvId"));
			resReserv.setResResrvDate(rs.getDate("resResrvDate"));
			resReserv.setResResrvFee(rs.getInt("resResrvFee"));
			resReserv.setCustomerId(rs.getInt("customerId"));
			resReserv.setResId(rs.getInt("resId"));
			list.add(resReserv);
		}
		return list;
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}

	}
//	일별 예약접수 리스트 출력
	@Override
	public ArrayList<ResReserv> selectByDayReserv(Connection conn, Date resResrvDate) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ResReserv> list = new ArrayList<>();
		ResReserv resReserv = new ResReserv();
		try{
		pstmt =conn.prepareStatement(ResResrvQuery.selectByDayReserv);	
		pstmt.setDate(1, resResrvDate);
		while(rs.next()){
			resReserv.setResResrvId(rs.getInt("resResrvId"));
			resReserv.setResResrvDate(rs.getDate("resResrvDate"));
			resReserv.setResResrvFee(rs.getInt("resResrvFee"));
			resReserv.setCustomerId(rs.getInt("customerId"));
			resReserv.setResId(rs.getInt("resId"));
			list.add(resReserv);
		}
		return list;
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}

	}

//	일반회원별 지난예약리스트 조회
	@Override
	public ArrayList<ResReserv> selectByLastReserv(Connection conn, int customerId) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ResReserv> list = new ArrayList<>();
		ResReserv resReserv = new ResReserv();
		try{
		pstmt =conn.prepareStatement(ResResrvQuery.selectByLastReserv);	
		while(rs.next()){
			resReserv.setResResrvId(rs.getInt("resResrvId"));
			resReserv.setResResrvDate(rs.getDate("resResrvDate"));
			resReserv.setResResrvFee(rs.getInt("resResrvFee"));
			resReserv.setCustomerId(rs.getInt("customerId"));
			resReserv.setResId(rs.getInt("resId"));
			list.add(resReserv);
		}
		return list;
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}
	  
	}
//	레스토랑별 예약접수 판매량 조회	(보류)
	@Override
	public ArrayList<ResReserv> selectBySalesLate(Connection conn, int resInfoId) throws Exception {
		String sql = "";  //sql 문 보류
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ResReserv> list = new ArrayList<>();
		ResReserv resReserv = new ResReserv();
		try{
		pstmt =conn.prepareStatement(sql);	
		pstmt.setInt(1, resInfoId);
		while(rs.next()){
			resReserv.setResResrvId(rs.getInt("resResrvId"));
			resReserv.setResResrvDate(rs.getDate("resResrvDate"));
			resReserv.setResResrvFee(rs.getInt("resResrvFee"));
			resReserv.setCustomerId(rs.getInt("customerId"));
			resReserv.setResId(rs.getInt("resId"));
			list.add(resReserv);
		}
		return list;
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}
	 
	}
//	예약접수 추가		
	@Override
	public int insertReserv(Connection conn, int resId, int customerId, Date resResrvDate, int resResrvFee)
			throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt =conn.prepareStatement(ResResrvQuery.insert);	
		pstmt.setInt(1, resId);
		pstmt.setInt(2, customerId);
		pstmt.setDate(3, resResrvDate);
		pstmt.setInt(4, resResrvFee);
		return pstmt.executeUpdate();
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}
	}
	
//	예약접수 정보수정		
	@Override
	public int updateReserv(Connection conn, Date resResrvDate, int resResrvFee) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt =conn.prepareStatement(ResResrvQuery.update);	
		pstmt.setDate(1, resResrvDate);
		pstmt.setInt(2, resResrvFee);
		return pstmt.executeUpdate();
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}
	}
//	예약접수 정보삭제		
	@Override
	public int deleteReserv(Connection conn, int resResrvId) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt =conn.prepareStatement(ResResrvQuery.delete);	
		pstmt.setInt(1, resResrvId);
		return pstmt.executeUpdate();
		}catch (SQLException e) {
		throw e;
		}finally{
	    JDBCUtil.close(pstmt,rs);	
		}
	
	}



}
