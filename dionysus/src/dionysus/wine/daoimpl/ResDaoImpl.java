package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.dao.ResDAO;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Res;

public class ResDaoImpl implements ResDAO {


	public Res makeRes(ResultSet rs)throws SQLException{
		Res res = new Res();
		res.setResAccountNo(rs.getString("resAccountNo"));
		res.setResLocation(rs.getString("resLocation"));
		res.setResOwnername(rs.getString("resOwnerName"));
		res.setResProfilePicture(rs.getString("resProfilePicture"));	
		res.setResTel(rs.getString("resTel"));
		return res;		
	}
	
	//레스토랑 업주 회원 비활성화 설정	SelectResOwnerActivated
	@Override
	public int selectResOwnerActivated(Connection conn, int resId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql="update res set res_activated=0 where res_id=?";
		try{
			pstmt = conn.prepareStatement(Sql);	
			pstmt.setInt(1, resId);			
			rs =pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt,rs);
		}		
		return -1;
	}
	//레스토랑 업주 페이지별 리스트 조회	SelectResOwnerAllList
	@Override
	public ArrayList<Res> selectResownerAllList(Connection conn, int startRow, int lastRow) {
		String Sql = "select r2.*from(select rownum rnum, r1.* from"
				+ "(select res_id, res_brn,res_location,"
				+ "res_tel,res_account_no,res_profile_picture,"
				+ "res_activated,res_ownername from res r, "
				+ "basic_info b where r.basic_info_id = b.basic_info_id)r1)r2 "
				+ "where rnum between ? and ?";		
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		ArrayList<Res> list = new ArrayList<>();
		Res res= new Res();
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			rs=pstmt.executeQuery();
			while(rs.next()){				
				res.setResId(rs.getShort("resId"));
				res.setResBrn(rs.getString("resBrn"));
				res.setResLocation(rs.getString("resLocation"));
				res.setResTel(rs.getString("resTel"));
				res.setResAccountNo(rs.getString("resAccountNO"));
				res.setResProfilePicture(rs.getString("resProfilePicture"));
				res.setResActivated(rs.getString("resActivatied"));
				res.setResOwnername(rs.getString("resOwnerName"));				
			
				list.add(res);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt,rs);
		}
		return null;
	}
	
	//레스토랑 업주 회원 count	
	@Override
	public int resOwnerCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql = "select max(res_id)+1 from res";
				try {
					pstmt = conn.prepareStatement(Sql);
					rs = pstmt.executeQuery();
					if(rs.next())
						return rs.getInt(1);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(pstmt, rs);
				}	
				return -1;
			}

	//레스토랑 업주 회원 지역별 조회
	@Override
	public ArrayList<Res> selectResOwnerLocation(Connection conn, String reslocation, int startRow, int lastRow){
		String Sql = "select r2.*from(select rownum rnum, r1.* from"
				+ "(select res_id, res_brn,res_location,"
				+ "res_tel,res_account_no,res_profile_picture,"
				+ "res_activated,res_ownername from res r, "
				+ "basic_info b where r.basic_info_id = b.basic_info_id and res_location=?)r1)r2 "
				+ "where rnum between ? and ?";		
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		ArrayList<Res> list = new ArrayList<>();
		Res res= new Res();
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, reslocation);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, lastRow);
			rs=pstmt.executeQuery();
			while(rs.next()){				
				res.setResId(rs.getShort("resId"));
				res.setResBrn(rs.getString("resBrn"));
				res.setResLocation(rs.getString("resLocation"));
				res.setResTel(rs.getString("resTel"));
				res.setResAccountNo(rs.getString("resAccountNO"));
				res.setResProfilePicture(rs.getString("resProfilePicture"));
				res.setResActivated(rs.getString("resActivatied"));
				res.setResOwnername(rs.getString("resOwnerName"));				
			
				list.add(res);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt,rs);
		}
		return null;
	}
	
	//레스토랑 업주 회원추가
	@Override
	public int insertResOwner(Connection conn, Res res) {
		String Sql = "insert into res(res_id,res_brn,res_location,res_tel,"
				+ "res_account_no,res_profile_picture,res_activated,res_ownername,basic_info_id,"
				+ "values(?,?,?,?,"
				+ "?,?,0,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, res.getResId());
			pstmt.setString(2, res.getResBrn());
			pstmt.setString(3, res.getResLocation());
			pstmt.setString(4, res.getResTel());
			pstmt.setString(5, res.getResAccountNo());
			pstmt.setString(6, res.getResProfilePicture());
			pstmt.setString(7, res.getResOwnername());
			pstmt.setInt(7, res.getBasicInfoId());
			return pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt,null);
		}	
		return -1;
	}
	/*
	//레스토랑 업주 회원로그인
	@Override
	public int resOwnerLogin(Connection conn, int resid, String respwd) {
		String Sql= "select count(*) from res where res_user_name=? and res_pwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, resid);
			pstmt.setString(2, respwd);
			rs =pstmt.executeQuery();
			if(rs.next()){				
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return -1;
	}
	*/
	//레스토랑 업주 회원 아이디 찾기
	@Override
	public int selectResOwnerId(Connection conn, String resOwnerName, String resBrn) {
		String Sql="select res_username from res where res_id=? and res_brn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setString(1, resOwnerName);
			pstmt.setString(2, resBrn);
			rs =pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}	
		return -1;
	}

	//비밀번호 찾기
	@Override
	public int selectResOwnerPwd(Connection conn, String basicInfoUserName, String resOwnerName, String resBrn) {
		String Sql="select res_owner_pwd from res where res_id=? and res_username=? and res_brn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setString(1, basicInfoUserName);
			pstmt.setString(2, resOwnerName);
			pstmt.setString(3, resBrn);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt,rs);
		}	
		
		return -1;
	}

	//레스토랑 업주 회원 정보수정
	@Override
	public int updateResOwner(Connection conn, Res resid) {
		String Sql ="update res set res_location=?,"
				+ "res_tel=?,res_account_no=?,res_profile_picture=?,"
				+ "res_ownername=? where res_id=?";
		PreparedStatement pstmt=null;
		Res res = new Res();
		try {
			pstmt = conn.prepareStatement(Sql);
			//비밀번호 변경
			//pstmt.setString(1, res.getResPwd());
			//위치변경
			pstmt.setString(1, res.getResLocation());
			//연락처
			pstmt.setString(2, res.getResTel());
			//이메일
			//pstmt.setString(4, res.getResEmail());
			//계좌번호
			pstmt.setString(3, res.getResAccountNo());
			//프로필사진
			pstmt.setString(4, res.getResProfilePicture());
			//오너이름
			pstmt.setString(5, res.getResOwnername());
			//번호
			pstmt.setInt(6, res.getResId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}		
		return 0;
	}
	/*//레스토랑 업주 회원 아이디 중복 확인
	@Override
	public int resOwnerIdCheck(Connection conn, String username) {
		String Sql = "select count(*) from res where res_username=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return 0;
	}*/

}
