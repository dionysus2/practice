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
		wine.setWineSellerLocation(rs.getString("wineSellerLocation"));
		wine.setWineSellerProfilePicture(rs.getString("wineSellerOwnername"));	
		wine.setWineSellerTel(rs.getString("wineSellerTel"));
		return wine;		
	}
	
	
	//와인회사 업주 회원 비활성화 설정	SelectResOwnerActivated
	@Override
	public int selectWineSellerActivated(Connection conn, int wineSellerId)throws SQLException {
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
	public ArrayList<WineSeller> selectWineSellerAllList(Connection conn, int startRow, int lastRow)throws SQLException {
		String Sql = "select r2.*from(select rownum rnum, r1.* from"
					+ "(select wine_seller_id, wine_seller_brn,wine_seller_location,"
					+ "wine_seller_tel,wine_seller_account_no,wine_seller_profile_picture,"
					+ "wine_seller_activated,wine_seller_name from wine_seller w, "
					+ "basic_info b where w.basic_info_id = b.basic_info_id)r1)r2 "
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
				wine.setWineSellerId(rs.getShort("wine_seller_id"));
				wine.setWineSellerBrn(rs.getString("wine_seller_brn"));
				wine.setWineSellerLocation(rs.getString("wine_seller_location"));
				wine.setWineSellerTel(rs.getString("wine_seller_tel"));
				wine.setWineSellerAccountNo(rs.getString("wine_seller_account_no"));
				wine.setWineSellerProfilePicture(rs.getString("wine_seller_profile_picture"));
				wine.setWineSellerActivated(rs.getString("wine_seller_activatied"));
				wine.setWineSellerName(rs.getString("wine_seller_name"));				
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
	public int wineSellerCount(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql = "select max(wine_seller_id+1) from wine_seller";
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
	public ArrayList<WineSeller> selectWineSellerLocation(Connection conn, String wineSellerlocation)throws SQLException {
		String Sql = "select r2.*from(select rownum rnum, r1.* from"
				+ "(select wine_seller_id, wine_seller_brn,wine_seller_location,"
				+ "wine_seller_tel,wine_seller_account_no,wine_seller_profile_picture,"
				+ "wine_seller_activated,wine_seller_ownername from wine_seller w, "
				+ "basic_info b where w.basic_info_id = b.basic_info_id and wine_seller_location=?)r1)r2 "
				+ "where rnum between ? and ?";	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WineSeller> list = new ArrayList<>();
		WineSeller wine= new WineSeller();
		try {
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, wineSellerlocation);
			rs = pstmt.executeQuery();
			while(rs.next()){
				wine.setWineSellerId(rs.getInt("wine_seller_Id"));
				wine.setWineSellerBrn(rs.getString("wine_seller_Brn"));
				wine.setWineSellerLocation(rs.getString("wine_seller_Location"));
				wine.setWineSellerTel(rs.getString("wine_seller_Tel"));
				wine.setWineSellerAccountNo(rs.getString("wine_seller_AccountNO"));
				wine.setWineSellerProfilePicture(rs.getString("wine_seller_ProfilePicture"));
				wine.setWineSellerActivated(rs.getString("wine_seller_Activatied"));
				wine.setWineSellerName(rs.getString("wine_seller_Name"));				
				list.add(wine);
			}
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
	public int inserWineSeller(Connection conn, WineSeller wineSeller)throws SQLException {
		String Sql = "insert into wine_seller(wine_seller_id,wine_seller_brn,wine_seller_location,wine_seller_tel,"
				+ "wine_seller_account_no,wine_seller_profile_picture,wine_seller_activated,wine_seller_name,basic_info_id,"
				+ "values(wine_seller_seq.nextval,?,?,?,"
				+ "?,?,0,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql);
			//pstmt.setInt(1, wineSeller.getWineSellerId()); 시퀀스로 자동 증가
			pstmt.setString(1, wineSeller.getWineSellerBrn());
			pstmt.setString(2, wineSeller.getWineSellerLocation());
			pstmt.setString(3, wineSeller.getWineSellerTel());
			pstmt.setString(4, wineSeller.getWineSellerAccountNo());
			pstmt.setString(5, wineSeller.getWineSellerProfilePicture());
			pstmt.setString(6, wineSeller.getWineSellerName());
			pstmt.setInt(7, wineSeller.getBasicInfoId());
			return pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt,null);
		}	
		return -1;
	}

	//와인회사 업주 회원로그인 	ResOwnerLogin
	/*@Override
	public int resWineSellerLogin(Connection conn, int wineSellerid, String wineSellerPwd)throws SQLException {
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
	}*/
	//와인회사 업주 회원 아이디 찾기	SelectResOwnerId
	@Override
	public int SelectWineSellerrId(Connection conn, String wineSellerName, String wineSellerBrn)throws SQLException {
		String Sql ="select b.basic_info_username from wine_seller w, basic_info b where w.basic_info_id= b.basic_info_id and w.wine_seller_ownername='?' and w.wine_seller_brn ='?'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql);
			pstmt.setString(1, wineSellerName);
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
	public int SelectWineSellerPwd(Connection conn, int wineId, String wineSellerName, String wineSellerBrn)throws SQLException {
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
	public int updateWineSeller(Connection conn, WineSeller WineSellerId)throws SQLException {
		String Sql ="update wine_seller set wine_seller_location=?,"
				+ "wine_seller_tel=?,wine_seller_account_no=?,"
				+ "wine_seller_profile_picture=?,"
				+ "wine_seller_name=? where wine_seller_id=?";
		PreparedStatement pstmt=null;
		WineSeller wine = new WineSeller();
		try {
			pstmt = conn.prepareStatement(Sql);
			//비밀번호 변경
			//pstmt.setString(1, res.getResPwd());
			//위치변경
			pstmt.setString(1, wine.getWineSellerLocation());
			//연락처
			pstmt.setString(2, wine.getWineSellerTel());
			//이메일
			//pstmt.setString(4, res.getResEmail());
			//계좌번호
			pstmt.setString(3, wine.getWineSellerAccountNo());
			//프로필사진
			pstmt.setString(4, wine.getWineSellerProfilePicture());
			//이름
			pstmt.setString(5, wine.getWineSellerName());
			//번호
			pstmt.setInt(6, wine.getWineSellerId());
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
	/*@Override
	public int resOwnerIdCheck(Connection conn, String wineSellerUsername)throws SQLException {
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
		
	}*/
}
