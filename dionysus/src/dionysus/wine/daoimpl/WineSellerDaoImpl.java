package dionysus.wine.daoimpl;

import java.sql.*;
import java.util.*;

import dionysus.wine.dao.*;
import dionysus.wine.util.*;
import dionysus.wine.vo.*;

public class WineSellerDaoImpl implements WineSellerDAO {

	
	public WineSeller makeWineSeller(ResultSet rs)throws SQLException{
		WineSeller wine = new WineSeller();
		wine.setWineSellerAccountNo(rs.getString("wineSellerAccountNo"));
		wine.setWineSellerEmail(rs.getString("wineSellerEmail"));
		wine.setWineSellerLocation(rs.getString("wineSellerLocation"));
		wine.setWineSellerOwnername(rs.getString("wineSellerOwnername"));
		wine.setWineSellerProfilePicture(rs.getString("wineSellerOwnername"));	
		wine.setWineSellerTel(rs.getString("wineSellerTel"));
		wine.setWineSellerUsername(rs.getString("wineSellerUsername"));
		return wine;		
	}
	
	
	//와인회사 업주 회원 비활성화 설정	SelectResOwnerActivated
	@Override
	public int selectWineSellerActivated(Connection conn, int wineSellerId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql="update wine_seller_id set ine_seller_activated=0 where ine_seller_id =?";
		try{
			pstmt = conn.prepareStatement(Sql);	
			pstmt.setInt(1, wineSellerId);			
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
	//와인회사 업주 페이지별 리스트 조회	SelectResOwnerAllList
	@Override
	public ArrayList<WineSeller> selectWineSellerAllList(Connection conn, int startRow, int lastRow) {
		String Sql = "select r2.*from(select rownum rnum, r1.* from(select res_id, res_brn,res_username,res_location,res_tel,"
				+ "res_email,res_account_no,res_profile_picture,res_activated,res_ownername from res)r1)r2"
				+ "where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		ArrayList<WineSeller> list = new ArrayList<>();
		WineSeller wine=new WineSeller();
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, lastRow);
			rs=pstmt.executeQuery();
			while(rs.next()){				
				wine.setWineSellerId(rs.getShort("wineSellerId"));
				wine.setWineSellerBrn(rs.getString("wineSellerBrn"));
				wine.setWineSellerUsername(rs.getString("wineSellerUsername"));
				wine.setWineSellerLocation(rs.getString("wineSellerLocation"));
				wine.setWineSellerTel(rs.getString("wineSellerTel"));
				wine.setWineSellerEmail(rs.getString("wineSellerEmail"));				
				wine.setWineSellerAccountNo(rs.getString("wineSellerAccountNo"));
				wine.setWineSellerProfilePicture(rs.getString("wineSellerProfilePicture"));
				wine.setWineSellerActivatied(rs.getString("wineSellerActivatied"));
				wine.setWineSellerOwnername(rs.getString("wineSellerOwnername"));				
				list.add(wine);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt,rs);
		}
		return null;
	}
	//와인회사 업주 회원 마지막 번호count	ResOwnerCount
	@Override
	public int wineSellerCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql = "select max(wine_seller_id)+1 from res";
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

	//와인회사 업주 회원 지역별 조회	SelectResOwnerLocation
	@Override
	public ArrayList<WineSeller> selectWineSellerLocation(Connection conn, String wineSellerlocation) {
		String Sql = "select res_account_no,res_email,res_location,res_Ownername,res_profile_picture,res_tel,"
				+ "res_username from res where res_location=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WineSeller> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, wineSellerlocation);
			rs = pstmt.executeQuery();
			while(rs.next())
			list.add(makeWineSeller(rs));	
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt,rs);
		}	
		return null;
		
	}
	//와인회사 업주 회원추가	InserResOwner
	@Override
	public int inserWineSeller(Connection conn, WineSeller wineSeller) {
		String Sql = "insert into res(res_id, res_brn, res_username, "
				+ "res_pwd, res_location, res_tel, es_email, res_account_no,"
				+ "res_profile_picture, res_ownername,res_activated values(?,?,?,?,?,?,?,?,?,?,0)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, wineSeller.getWineSellerId());
			pstmt.setString(2, wineSeller.getWineSellerBrn());
			pstmt.setString(3, wineSeller.getWineSellerUsername());
			pstmt.setString(4, wineSeller.getWineSellerPwd());
			pstmt.setString(5, wineSeller.getWineSellerLocation());
			pstmt.setString(6, wineSeller.getWineSellerTel());
			pstmt.setString(7, wineSeller.getWineSellerEmail());
			pstmt.setString(8, wineSeller.getWineSellerAccountNo());
			pstmt.setString(9, wineSeller.getWineSellerProfilePicture());
			pstmt.setString(10, wineSeller.getWineSellerOwnername());
			return pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt,null);
		}	
		return -1;
	}

	//와인회사 업주 회원로그인 	ResOwnerLogin
	@Override
	public int resWineSellerLogin(Connection conn, int wineSellerid, String wineSellerPwd) {
		String Sql= "select count(*) from res where res_user_name=? and res_pwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, wineSellerid);
			pstmt.setString(2, wineSellerPwd);
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
	//와인회사 업주 회원 아이디 찾기	SelectResOwnerId
	@Override
	public int SelectWineSellerrId(Connection conn, int wineId, String wineSellerBrn) {
		String Sql="select res_username from res where res_id=? and res_brn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setInt(1, wineId);
			pstmt.setString(2, wineSellerBrn);
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
	//와인회사 업주 회원 비밀번호 찾기	SelectResOwnerPwd
	@Override
	public int SelectWineSellerPwd(Connection conn, int wineId, String wineSellerName, String wineSellerBrn) {
		String Sql="select res_owner_pwd from res where res_id=? and res_username=? and res_brn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setInt(1, wineId);
			pstmt.setString(2, wineSellerName);
			pstmt.setString(3, wineSellerBrn);
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
	//와인회사 업주 회원 정보수정	UpdateResOwner
	@Override
	public int updateWineSeller(Connection conn, int WineSellerId) {
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
	//와인회사 업주 회원 아이디 중복 확인
	@Override
	public int resOwnerIdCheck(Connection conn, String wineSellerUsername) {
		String Sql = "select count(*) from res where res_username=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, wineSellerUsername);
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
