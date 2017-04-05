package dionysus.wine.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.management.Query;

import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.Customer;
import dionysus.wine.vo.ResReserv;
import dionysus.wine.vo.WineInfo;
import dionysus.wine.vo.WineOrder;

public interface CustomerDAO {
	public int CustomerJoin(Connection conn, Customer customer) throws SQLException;
	public ArrayList<Customer> selectAllCustomer(Connection conn) throws SQLException;
	public int CustomerCount(Connection conn)throws SQLException ;
	public ArrayList<Customer> selectByCustomerAge(Connection conn, int customerAge) throws SQLException;
	public ArrayList<Customer> selectByCustomerJob(Connection conn, String customerJob) throws SQLException;
	public ArrayList<Customer> selectByCustomerGender(Connection conn, String customerGender) throws SQLException;
	public ArrayList<Customer> selectByCustomerName(Connection conn, String customerName) throws SQLException;
	public int CustomerInfoUpdate(Connection conn, Customer customer) throws SQLException;
	public int CustomerInfoDelete(Connection conn, int customerId) throws SQLException ;
	public String CustomerIdFind(Connection conn, String customerName, String customerRrn) throws SQLException;
	public String CustomerPwdFind(Connection conn, String customerName, String customerRrn, String customerUserName) throws SQLException;
	public int CustomerLogin(Connection conn, String customerUserName, String customerPwd) throws SQLException;
	public ArrayList<HashMap<String, Object>> CustomerResReserv(Connection conn) throws SQLException;
	public int CustomerResReservUpdate(Connection conn, ResReserv ResReserv) throws SQLException;
	public int CustomerResReservDelete(Connection conn, int customerId) throws SQLException;
	public ArrayList<HashMap<String, Object>> SelectLastResReserv(Connection conn, Date date) throws SQLException;
	public ArrayList<HashMap<String, Object>> SelectCustomerWineOrder(Connection conn) throws SQLException;
	public int CustomerWineOrderUpdate(Connection conn, WineOrder wineorder) throws SQLException;
	public int CustomerWineOrderDelete(Connection conn, int customerId) throws SQLException;
	public ArrayList<WineInfo> CustomerWineCart(Connection conn, int customerId) throws SQLException;
	public int CustomerWineCartOrder(Connection conn, int customerId, int wineOrderId) throws SQLException;
	public int CustomerWineCartDelete(Connection conn, int customerId) throws SQLException;
	
}
/*
 * 	- 일반회원 정보 페이지별 조회.							리턴					매개변수
 * 		1. 일반회원 정보 페이지별 조회				ArrayList<Customer>		Connection, 페이지, 페이지				
 * 		2. 일반회원 테이블 총 count조회						int				Connection								
 * 	- 연령대별 일반회원 정보 페이지별 조회.		
 * 		3. 일반회원 정보 연령대별/페이지별 조회.	ArrayList<Customer>		Connection, 연령대, 페이지, 페이지
 * 	- 직업별 일반회원 정보 페이지별 조회
 * 		4. 일반회원 정보 직업별/페이지별 조회.		ArrayList<Customer>		Connection, 직업, 페이지, 페이지
 * 	- 성별 일반회원 정보 페이지별 조회.
 * 		5. 일반회원 정보 성별/페이지별 조회.		ArrayList<Customer>		Connection, 성별, 페이지, 페이지
 * 	- 이름으로 회원정보 조회.
 * 		6. 일반회원 정보 이름으로 조회				ArrayList<Customer>				Connection, 이름
 *	- 일반회원 회원가입.
 *		7. 일반회원 정보 추가						int						Connection, Customer
 *	- 일반회원 회원정보 수정.
 *		8. 일반회원 정보 업데이트					int						Connection, Customer
 *	- 일반회원 아이디 찾기(이름, 주민번호).
 *		9. 일반회원 정보내 아이디 조회				String					Connection, 이름, 주민번호
 *	- 일반회원 비밀번호 찾기(이름, 주민번호, 아이디).
 *		10. 일반회원 정보내 비밀번호 조회			String					Connection, 이름, 주민번호, 아이디
 *	- 로그인.										
 *		11. 일반회원 로그인 처리					int						Connection, 아이디, 비밀번호
 *	- 로그아웃(컨트롤단에서 처리)
 *	11-1. 일반회원 회원탈퇴						int						Connection, 고객번호
 *	- 일반회원 레스토랑 예약내역 조회.
 *		12. 일반회원 예약내역 조회.		ArrayList<HashMap<String, Object>>	Connection
 *	- 일반회원 레스토랑 예약내역 수정.
 *		13. 일반회원 예약내역 수정.					int						Connection, ResReserv
 *	- 일반회원 레스토랑 예약내역 취소.
 *		14. 일반회원 예약내역 취소					int						Connection, 회원번호
 *	- 일반회원 레스토랑 년별 지난예약 년별/월별/일별 조회.
 *		15. 일반회원 레스토랑 예약신청 내역 년별/월별/일별 조회.	ArrayList<HashMap<String, Object>>	Connection, 년별/월별/일별
 *	- 일반회원 와인상품 주문내역 조회.
 *		16. 일반회원 와인상품 주문내역 조회		ArrayList<HashMap<String, Object>>	Connection
 *	- 일반회원 와인상품 주문내역 취소.
 *		17. 일반회원 와인상품 주문내역 취소			int						Connection, 회원번호
 *	- 일반회원 와인상품 주문내역 수정.
 *		18. 일반회원 와인상품 주문내역 수정.		int 					Connection, WineOrder
 *	- 일반회원 장바구니내 와인상품 조회.
 *		19. 일반회원 장바구니내 와인상품 조회	ArrayList<Wine>				Connection, 회원번호
 *	- 일반회원 장바구니내 와인상품 주문신청.
 *		20. 일반회원 장바구니내 와인상품 주문신청	int						Connection, 회원번호, 주문번호
 *	- 일반회원 장바구니내 와인상품 삭제.
 *		21. 일반회원 장바구니내 와인상품 주문내역 삭제.	int					Connection, 회원번호
 * */

