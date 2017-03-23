package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.print.attribute.PrintRequestAttribute;

import dionysus.wine.dao.CustomerDAO;
import dionysus.wine.query.CustomerQuery;
import dionysus.wine.query.WineInfoQuery;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Customer;
import dionysus.wine.vo.Res;
import dionysus.wine.vo.ResReserv;
import dionysus.wine.vo.WineInfo;
import dionysus.wine.vo.WineOrder;
import dionysus.wine.vo.WineWishlist;

public class CustomerDAOImpl implements CustomerDAO{
	@Override
	public int CustomerJoin(Connection conn, Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.insert);
			pstmt.setInt(1, customer.getCustomerId());
			//pstmt.setString(2, customer.getCustomerUsername());
			//pstmt.setString(3, customer.getCustomerPwd());
			pstmt.setString(4, customer.getCustomerRrn());
			pstmt.setString(5, customer.getCustomerAddress());
			pstmt.setString(6, customer.getCustomerName());
			pstmt.setString(7, customer.getCustomerTel());
			pstmt.setString(8, customer.getCustomerGender());
			pstmt.setString(9, customer.getCustomerAccountNo());
			pstmt.setString(10, customer.getCustomerJob());
			//pstmt.setString(11, customer.getCustomerEmail());
			pstmt.setString(12, customer.getCustomerActivated());
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}
	@Override
	public ArrayList<Customer> selectAllCustomer(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(CustomerQuery.customerList);
			rs= pstmt.executeQuery();
			ArrayList<Customer>list= new ArrayList<Customer>();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				//customer.setCustomerUsername(rs.getString("CUSTOMER_USERNAME"));
				//customer.setCustomerPwd(rs.getString("CUSTOMER_PWD"));
				customer.setCustomerRrn(rs.getString("CUSTOMER_RRN"));
				customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setCustomerTel(rs.getString("CUSTOMER_TEL"));
				customer.setCustomerGender(rs.getString("CUSTOMER_GENDER"));
				customer.setCustomerAccountNo(rs.getString("CUSTOMER_ACCOUNT_NO"));
				customer.setCustomerJob(rs.getString("CUSTOMER_JOB"));
				//customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
				customer.setCustomerActivated(rs.getString("CUSTOMER_ACTIVATED"));
				list.add(customer);
			}
			return list;
		} 
		catch (SQLException e) {			
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, rs);
		}
	}

	@Override
	public int CustomerCount(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = conn.prepareStatement(CustomerQuery.customerAllCount);
		rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
			}
		}
		catch (SQLException e) {
			throw e;
		}
		finally {
			JDBCUtil.close(pstmt,rs);
		}
		return 0;
	}

	@Override
	public ArrayList<Customer> selectByCustomerAge(Connection conn, int customerAge) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(CustomerQuery.customerAge);
			pstmt.setInt(1, customerAge);
			rs= pstmt.executeQuery();
			ArrayList<Customer>list= new ArrayList<Customer>();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
			    //customer.setCustomerUsername(rs.getString("CUSTOMER_USERNAME"));
			    //customer.setCustomerPwd(rs.getString("CUSTOMER_PWD"));
				customer.setCustomerRrn(rs.getString("CUSTOMER_RRN"));
				customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setCustomerTel(rs.getString("CUSTOMER_TEL"));
				customer.setCustomerGender(rs.getString("CUSTOMER_GENDER"));
				customer.setCustomerAccountNo(rs.getString("CUSTOMER_ACCOUNT_NO"));
				customer.setCustomerJob(rs.getString("CUSTOMER_JOB"));
				//customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
				customer.setCustomerActivated(rs.getString("CUSTOMER_ACTIVATED"));
				list.add(customer);
			}
			return list;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, rs);
		}
	}

	@Override
	public ArrayList<Customer> selectByCustomerJob(Connection conn, String customerJob) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.customerJob);
			pstmt.setString(1, customerJob);
			rs = pstmt.executeQuery();
			ArrayList<Customer> list = new ArrayList<>();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				//customer.setCustomerUsername(rs.getString("CUSTOMER_USERNAME"));
				//customer.setCustomerPwd(rs.getString("CUSTOMER_PWD"));
				customer.setCustomerRrn(rs.getString("CUSTOMER_PWD"));
				customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setCustomerTel(rs.getString("CUSTOMER_TEL"));
				customer.setCustomerGender(rs.getString("CUSTOMER_GENDER"));
				customer.setCustomerAccountNo(rs.getString("CUSTOMER_ACCOUNT_NO"));
				customer.setCustomerJob(rs.getString("CUSTOMER_JOB"));
				//customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
				customer.setCustomerActivated(rs.getString("CUSTOMER_ACTIVATED"));
				list.add(customer);
			}
			return list;
		}
		catch (SQLException e) { 
			throw e;
		} 
		finally {
			JDBCUtil.close(pstmt, rs);
		}
	}

	@Override
	public ArrayList<Customer> selectByCustomerGender(Connection conn, String customerGender) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.customerGender);
			pstmt.setString(1, customerGender);
			rs = pstmt.executeQuery();
			ArrayList<Customer> list = new ArrayList<>();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				//customer.setCustomerUsername(rs.getString("CUSTOMER_USERNAME"));
				//customer.setCustomerPwd(rs.getString("CUSTOMER_PWD"));
				customer.setCustomerRrn(rs.getString("CUSTOMER_PWD"));
				customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setCustomerTel(rs.getString("CUSTOMER_TEL"));
				customer.setCustomerGender(rs.getString("CUSTOMER_GENDER"));
				customer.setCustomerAccountNo(rs.getString("CUSTOMER_ACCOUNT_NO"));
				customer.setCustomerJob(rs.getString("CUSTOMER_JOB"));
				//customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
				customer.setCustomerActivated(rs.getString("CUSTOMER_ACTIVATED"));
				list.add(customer);
			}
			return list;
		}
		catch (SQLException e){
			throw e;
		}
		finally {
			JDBCUtil.close(pstmt,rs);
		}
	}

	@Override
	public ArrayList<Customer> selectByCustomerName(Connection conn, String customerName) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.customerName);
			pstmt.setString(1, customerName);
			rs = pstmt.executeQuery();
			ArrayList<Customer> list = new ArrayList<>();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				//customer.setCustomerUsername(rs.getString("CUSTOMER_USERNAME"));
				//customer.setCustomerPwd(rs.getString("CUSTOMER_PWD"));
				customer.setCustomerRrn(rs.getString("CUSTOMER_PWD"));
				customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setCustomerTel(rs.getString("CUSTOMER_TEL"));
				customer.setCustomerGender(rs.getString("CUSTOMER_GENDER"));
				customer.setCustomerAccountNo(rs.getString("CUSTOMER_ACCOUNT_NO"));
				customer.setCustomerJob(rs.getString("CUSTOMER_JOB"));
				//customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
				customer.setCustomerActivated(rs.getString("CUSTOMER_ACTIVATED"));
				list.add(customer);
			}
			return list;
		}
		catch (SQLException e){
			throw e;
		}
		finally {
			JDBCUtil.close(pstmt,rs);
		}
	}

	@Override
	public int CustomerInfoUpdate(Connection conn, Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.update);
			//pstmt.setString(1, customer.getCustomerUsername());
			//pstmt.setString(2, customer.getCustomerPwd());
			pstmt.setString(3, customer.getCustomerRrn());
			pstmt.setString(4, customer.getCustomerAddress());
			pstmt.setString(5, customer.getCustomerName());
			pstmt.setString(6, customer.getCustomerTel());
			pstmt.setString(7, customer.getCustomerGender());
			pstmt.setString(8, customer.getCustomerAccountNo());
			pstmt.setString(9, customer.getCustomerJob());
			//pstmt.setString(10, customer.getCustomerEmail());
			pstmt.setString(11, customer.getCustomerActivated());
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	@Override
	public int CustomerInfoDelete(Connection conn, int customerId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(CustomerQuery.delete);
			pstmt.setInt(1, customerId);
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, null);
		}
	}

	@Override
	public String CustomerIdFind(Connection conn, String customerName, String customerRrn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(CustomerQuery.selectUserName);
			pstmt.setString(1, customerName);
			pstmt.setString(2, customerRrn);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return null;//여기 수정해야함
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}
		return null;
	}

	@Override
	public String CustomerPwdFind(Connection conn, String customerName, String customerRrn, String customerUserName) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.selectPwd);
			pstmt.setString(1, customerName);
			pstmt.setString(2, customerRrn);
			pstmt.setString(3, customerUserName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}
		return null;
	}

	@Override
	public int CustomerLogin(Connection conn, String customerUserName, String customerPwd) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try { 
			pstmt = conn.prepareStatement(CustomerQuery.login);
			pstmt.setString(1, customerUserName);
			pstmt.setString(2, customerPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}
		return 0;
	}

	@Override
	public ArrayList<HashMap<String, Object>> CustomerResReserv(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(CustomerQuery.selectResReserv);
			rs= pstmt.executeQuery();
			ArrayList<HashMap<String, Object>> list= new ArrayList<HashMap<String, Object>>();
			while(rs.next()){
				ResReserv reserv = new ResReserv();
				HashMap<String, Object> map = new HashMap<String, Object>();
				reserv.setResId(rs.getInt("RES_RESERV_ID"));
				reserv.setResResrvDate(rs.getDate("RES_RESERV_DATE"));
				reserv.setResResrvFee(rs.getInt("RES_RESERV_FEE"));
				list.add(map);
			}
			return list;
		} 
		catch (SQLException e) {			
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, rs);
		}
	}

	@Override
	public int customerResReservUpdate(Connection conn, ResReserv ResReserv) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.updateResReserv);
			pstmt.setDate(1, ResReserv.getResResrvDate());
			pstmt.setInt(2, ResReserv.getResResrvFee());
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	@Override
	public int customerResReservDelete(Connection conn, int customerId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(CustomerQuery.deleteResReserv);
			pstmt.setInt(1, customerId); //회원번호로 지워? 아님 예약번호로지워?
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, null);
		}
	}

	@Override
	public ArrayList<HashMap<String, Object>> SelectLastResReserv(Connection conn, Date date) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(CustomerQuery.selectLastResReserv);
			rs= pstmt.executeQuery();
			ArrayList<HashMap<String, Object>> list= new ArrayList<HashMap<String, Object>>();
			while(rs.next()){
				ResReserv reserv = new ResReserv();
				HashMap<String, Object> map = new HashMap<String, Object>();
				reserv.setResId(rs.getInt("RES_RESERV_ID"));
				reserv.setResResrvDate(rs.getDate("RES_RESERV_DATE"));
				reserv.setResResrvFee(rs.getInt("RES_RESERV_FEE"));
				list.add(map);
			}
			return list;
		} 
		catch (SQLException e) {			
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, rs);
		}
	}

	@Override
	public ArrayList<HashMap<String, Object>> SelectCustomerWineOrder(Connection conn) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= conn.prepareStatement(CustomerQuery.selectWineOrder);
			rs= pstmt.executeQuery();
			ArrayList<HashMap<String, Object>> list= new ArrayList<HashMap<String, Object>>();
			while(rs.next()){
				WineOrder order = new WineOrder();
				HashMap<String, Object> map = new HashMap<String, Object>();
				order.setWineOrderId(rs.getInt("WINE_ORDER_ID"));
				order.setWineOrderDate(rs.getDate("WINE_ORDER_DATE"));
				order.setWineOrderAmount(rs.getInt("WINE_ORDER_AMOUNT"));
				list.add(map);
			}
			return list;
		} 
		catch (SQLException e) {			
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, rs);
		}
	}

	@Override
	public int CustomerWineOrderUpdate(Connection conn, WineOrder wineorder) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.updateWineOrder);
			pstmt.setInt(1, wineorder.getWineOrderId());
			pstmt.setDate(2, wineorder.getWineOrderDate());
			pstmt.setInt(3, wineorder.getWineOrderAmount());
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, null);
		}
		return 0;
	}

	@Override
	public int CustomerWineOrderDelete(Connection conn, int customerId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(CustomerQuery.deleteWineOrder);
			pstmt.setInt(1, customerId); 
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, null);
		}
	}

	@Override
	public ArrayList<WineInfo> CustomerWineCart(Connection conn, int customerId) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.selectWineWishList);
			pstmt.setInt(1, customerId);
			rs = pstmt.executeQuery();
			ArrayList<WineInfo> list = new ArrayList<>();
			while(rs.next()) {
				WineWishlist wishlist = new WineWishlist();
				WineInfo info = new WineInfo();
				info.setWineInfoId(rs.getInt("WINE_INFO_ID"));
				info.setWineInfoName(rs.getString("WINE_INFO_NAME"));
				info.setWineInfoProfilePicture(rs.getString("WINE_INFO_PROFILE_PICTURE"));
				info.setWineInfoPrice(rs.getInt("WINE_INFO_PRICE"));
				info.setWineInfoOrigin(rs.getString("WINE_INFO_ORIGIN"));
				info.setWineInfoPicture1(rs.getString("WINE_INFO_PICTURE1"));
				info.setWineInfoPicture2(rs.getString("WINE_INFO_PICTURE2"));
				info.setWineInfoPicture3(rs.getString("WINE_INFO_PICTURE3"));
				list.add(info);
			}
			return list;
		}
		catch (SQLException e){
			throw e;
		}
		finally {
			JDBCUtil.close(pstmt,rs);
		}
	}

	@Override
	public int CustomerWineCartOrder(Connection conn, int customerId, int wineOrderId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(CustomerQuery.OrderWineWishList);
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, wineOrderId);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}
		return 0;
	}

	@Override
	public int CustomerWineCartDelete(Connection conn, int customerId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(CustomerQuery.deleteWineWishList);
			pstmt.setInt(1, customerId); 
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			JDBCUtil.close(pstmt, null);
		}
	}
}
