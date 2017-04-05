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
		res.setResAccountNo(rs.getString("res_account_no"));
		res.setResLocation(rs.getString("res_location"));
		res.setResName(rs.getString("res_name"));
		res.setResProfilePicture(rs.getString("res_profile_picture"));	
		res.setResTel(rs.getString("res_tel"));
		return res;		
	}
	
	//레스토랑 업주 회원 비활성화 설정	SelectResOwnerActivated
	@Override
	public int selectResOwnerActivated(Connection conn, int resId)throws SQLException {
		PreparedStatement pstmt = null;
		String Sql="update res set res_activated=0 where res_id=?";
		try{
			pstmt = conn.prepareStatement(Sql);	
			pstmt.setInt(1, resId);			
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt,null);
		}		
		return -1;
	}
	//레스토랑 업주 페이지별 리스트 조회	SelectResOwnerAllList
	@Override
	public ArrayList<Res> selectResOwnerAllList(Connection conn, int startRow, int lastRow)throws SQLException {
		String Sql = "select r2.*from(select rownum rnum, r1.* from"
				+ "(select res_id, res_brn,res_location,"
				+ "res_tel,res_account_no,res_profile_picture,"
				+ "res_activated,res_name from res r, "
				+ "basic_info b where r.basic_info_id = b.basic_info_id)r1)r2 "
				+ "where rnum between ? and ?";		
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		ArrayList<Res> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			rs=pstmt.executeQuery();
			while(rs.next()){				
				Res res= new Res();
				res.setResId(rs.getShort("res_id"));
				res.setResBrn(rs.getString("res_brn"));
				res.setResLocation(rs.getString("res_location"));
				res.setResTel(rs.getString("res_tel"));
				res.setResAccountNo(rs.getString("res_account_no"));
				res.setResProfilePicture(rs.getString("res_profile_picture"));
				res.setResActivated(rs.getString("res_activated"));
				res.setResName(rs.getString("res_name"));				
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
	public int resOwnerCount(Connection conn)throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql = "select max(res_id) from res";
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
	public ArrayList<Res> selectResOwnerLocation(Connection conn, String reslocation, int startRow, int lastRow)throws SQLException{
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
				res.setResId(rs.getShort("res_id"));
				res.setResBrn(rs.getString("res_brn"));
				res.setResLocation(rs.getString("res_location"));
				res.setResTel(rs.getString("res_tel"));
				res.setResAccountNo(rs.getString("res_account_no"));
				res.setResProfilePicture(rs.getString("res_profile_picture"));
				res.setResActivated(rs.getString("res_activatied"));
				res.setResName(rs.getString("res_name"));			
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
	public int insertResOwner(Connection conn, Res res)throws SQLException {
		String Sql = "insert into res(res_id,res_brn,res_location,res_tel,"
				+ "res_account_no,res_profile_picture,res_activated,res_name,basic_info_id,"
				+ "values(res_seq.nextval,?,?,?,"
				+ "?,?,0,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			//pstmt.setInt(1, res.getResId()); 시퀀스로 변경
			pstmt.setString(1, res.getResBrn());
			pstmt.setString(2, res.getResLocation());
			pstmt.setString(3, res.getResTel());
			pstmt.setString(4, res.getResAccountNo());
			pstmt.setString(5, res.getResProfilePicture());
			pstmt.setString(6, res.getResName());
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
	public int selectResOwnerId(Connection conn, String resOwnername, String resBrn)throws SQLException {
		String Sql ="select b.basic_info_username from res r, basic_info b where r.basic_info_id= b.basic_info_id and r.res_ownername='?' and r.res_brn ='?'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setString(1, resOwnername);
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
	public int selectResOwnerPwd(Connection conn, String basicInfoUserName, String resBrn)throws SQLException {
		String Sql ="select b.basic_info_pwd from res r, basic_info b where r.basic_info_id= b.basic_info_id and b.basic_info_username='?' and r.res_brn ='?'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setString(1, basicInfoUserName);
			pstmt.setString(2, resBrn);
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
	public int updateResOwner(Connection conn, Res res)throws SQLException {
		String Sql ="update res set res_location=?,"
				+ "res_tel=?,res_account_no=?,res_profile_picture=?,"
				+ "res_ownername=? where res_id=?";
		PreparedStatement pstmt=null;
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
			pstmt.setString(5, res.getResName());
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
