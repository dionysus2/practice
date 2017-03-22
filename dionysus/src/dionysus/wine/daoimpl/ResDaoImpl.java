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
		res.setResEmail(rs.getString("resEmail"));
		res.setResLocation(rs.getString("resLocation"));
		res.setResOwnername(rs.getString("resOwnerName"));
		res.setResProfilePicture(rs.getString("resProfilePicture"));	
		res.setResTel(rs.getString("resTel"));
		res.setResUsername(rs.getString("resUserName"));
		return res;		
	}
	
	//레스토랑 업주 회원 비활성화 설정	SelectResOwnerActivated
	@Override
	public int selectResOwnerActivated(Connection conn, int resId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql="update res set res_activated=0 where res_id =?";
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
		String Sql = "select r2.*from(select rownum rnum, r1.* from(select res_id, res_brn,res_username,res_location,res_tel,"
				+ "res_email,res_account_no,res_profile_picture,res_activated,res_ownername from res)r1)r2"
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
				res.setResUsername(rs.getString("resUserName"));
				res.setResLocation(rs.getString("resLocation"));
				res.setResTel(rs.getString("resTel"));
				res.setResEmail(rs.getString("resEmail"));				
				res.setResAccountNo(rs.getString("resAccountNO"));
				res.setResProfilePicture(rs.getString("resPicture"));
				res.setResActivated(rs.getString("resActivated"));
				res.setResOwnername(rs.getString("resPwnerName"));				
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
	public ArrayList<Res> selectResOwnerLocation(Connection conn, String reslocation){
		String Sql = "select res_account_no,res_email,res_location,res_Ownername,res_profile_picture,res_tel,"
				+ "res_username from res where res_location=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Res> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, reslocation);
			rs = pstmt.executeQuery();
			while(rs.next())
			list.add(makeRes(rs));	
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt,rs);
		}	
		return null;
		
	}
	//레스토랑 업주 회원추가
	@Override
	public int insertResOwner(Connection conn, Res res) {
		String Sql = "insert into res(res_id, res_brn, res_username, "
				+ "res_pwd, res_location, res_tel, es_email, res_account_no,"
				+ "res_profile_picture, res_ownername,res_activated values(?,?,?,?,?,?,?,?,?,?,0)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, res.getResId());
			pstmt.setString(2, res.getResBrn());
			pstmt.setString(3, res.getResUsername());
			pstmt.setString(4, res.getResPwd());
			pstmt.setString(5, res.getResLocation());
			pstmt.setString(6, res.getResTel());
			pstmt.setString(7, res.getResEmail());
			pstmt.setString(8, res.getResAccountNo());
			pstmt.setString(9, res.getResProfilePicture());
			pstmt.setString(10, res.getResOwnername());
			return pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt,null);
		}	
		return -1;
	}
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
	//레스토랑 업주 회원 아이디 찾기
	@Override
	public int selectResOwnerId(Connection conn, int resId, String resBrn) {
		String Sql="select res_username from res where res_id=? and res_brn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setInt(1, resId);
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
	public int selectResOwnerPwd(Connection conn, int resid, String resname, String resBrn) {
		String Sql="select res_owner_pwd from res where res_id=? and res_username=? and res_brn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setInt(1, resid);
			pstmt.setString(2, resname);
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
		String Sql ="update res set res_pwd=?,res_location=?,"
				+ "res_tel=?,res_email=?,res_account_no=?,res_profile_picture=?,"
				+ "res_ownername=? where res_id=?";
		PreparedStatement pstmt=null;
		Res res = new Res();
		try {
			pstmt = conn.prepareStatement(Sql);
			//비밀번호 변경
			pstmt.setString(1, res.getResPwd());
			//위치변경
			pstmt.setString(2, res.getResLocation());
			//연락처
			pstmt.setString(3, res.getResTel());
			//이메일
			pstmt.setString(4, res.getResEmail());
			//계좌번호
			pstmt.setString(5, res.getResAccountNo());
			//프로필사진
			pstmt.setString(6, res.getResProfilePicture());
			//이름
			pstmt.setString(7, res.getResUsername());
			//번호
			pstmt.setInt(8, res.getResId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}		
		return 0;
	}
	//레스토랑 업주 회원 아이디 중복 확인
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
	}

}
