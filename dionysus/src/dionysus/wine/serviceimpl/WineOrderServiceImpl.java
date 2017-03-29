package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.daoimpl.WineInfoDAOImpl;
import dionysus.wine.daoimpl.WineOrderDAOImpl;
import dionysus.wine.service.WineOrderService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.WineOrder;

public class WineOrderServiceImpl implements WineOrderService {
	/*
	 * 
	 * 	- 월별/일별 상품 주문건 판매량 조회
	 * 		7. 와인회사별/월별 상품 주문건 판매량 조회	ArrayList<Integer>	Connection, 주문일자(월별), 와인회사번호
	 * 		8. 와인회사별/일별 상품 주문건 판매량 조회	ArrayList<Integer>	Connection, 주문일자(일별), 와인회사번호
	 * 	- 와인상품 주문회원 정보조회
	 * 		9. 와인상품 주문회원 정보조회						ArryList<Customer>			Connection, 와인회사번호, 고객번호
	 * 	- 주문건 등록.
	 * 		10. 주문건 등록											int						Connection, WineOrder
	 * 	- 주문건 삭제.
	 * 		11. 주문건 삭제											int						Connection, 주문번호
	 * 	- 주문건수정(주문상세에서 처리)
	 * */
	private WineOrderDAOImpl dao;
	public WineOrderServiceImpl(WineOrderDAOImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao= dao;
	}
	private Logger logger= LoggerFactory.getLogger(WineOrderServiceImpl.class);
	
	//	와인상품 주문전체 리스트 조회
	@Override
	public String readAllWineOrderList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		int pageNo= 1;
		if(request.getParameter("pageNo")!=null)
			pageNo= Integer.parseInt(request.getParameter("pageNo"));
		try {
			int cntOfRow= dao.selectWineOrderCount(conn);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<WineOrder>list= dao.selectWineOrderList(conn, pagination.getStartRow(), pagination.getLastRow());
			HashMap<String, Object>map= new HashMap<String, Object>();
			map.put("pagination", pagination);
			map.put("list", list);
			return new Gson().toJson(map);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
		return null;
	}
	
	//	주문일자별(년별/월별)주문 리스트 조회
	@Override
	public String readByWineOrderDateMonth(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM");
	    java.util.Date date=null;
	    try {
			date= sdf.parse(request.getParameter("wineOrderDate"));
			ArrayList<WineOrder>list= dao.selectWineOrderByMonth(conn, new java.util.Date(date.getTime()));
			return new Gson().toJson(list);
		} 
	    catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally{
	    	JDBCUtil.close(conn);
	    }
	    return null;
	    

	}
	
	//	주문일자별(년별/월별/일별)주문 리스트 조회
	@Override
	public String readByWineOrderDateDay(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM/DD");
		java.util.Date date= null;
		try {
			date= sdf.parse(request.getParameter("wineOrderDate"));
			ArrayList<WineOrder>list= dao.selectWineOrderByDay(conn, new java.util.Date(date.getTime()));
			return new Gson().toJson(list);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
		return null;
	}

	//	와인상품 와인회사별 주문 리스트 조회
	@Override
	public String readByWineSellerWineOrder(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		int wineSellerId= new WineInfoDAOImpl().selectByBasicId(conn, basicInfoUsername);
		try {
			ArrayList<WineOrder>list= dao.selectByWineSellerWineOrder(conn, wineSellerId);
			return new Gson().toJson(list);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
		return null;
	}
	
	//	와인회사별 상품 주문건 판매량 조회
	@Override
	public String readByWineSellerWineOrderAmountSum(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		int wineSellerId= new WineInfoDAOImpl().selectByBasicId(conn, basicInfoUsername);
		try {
			int result= dao.selectByWineOrderAmountSum(conn, wineSellerId);
			return new Gson().toJson(result);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
		return null;
	}

	//	와인회사별/년별/월별 상품 주문건 판매량 조회
	@Override
	public String readByWineSellerWineOrderMonth(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM");
		java.util.Date date= null;
		try {
			date= sdf.parse(request.getParameter("wineOrderDate"));
			String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
			int wineSellerId= new WineInfoDAOImpl().selectByBasicId(conn, basicInfoUsername);
			int result= dao.wineSellerSellMonth(conn, new java.util.Date(date.getTime()), wineSellerId);
			return new Gson().toJson(result);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
		return null;
	}

	//	와인회사별/년별/월별/일별 상품 주문건 판매량 조회
	@Override
	public String readByWineSellerWineOrderDay(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM/DD");
		java.util.Date date= null;
		try {
			date= sdf.parse(request.getParameter("wineOrderDate"));
			String basicInfoUsername= session.getAttribute("basicUsername")+"";
			int wineSellerId= new WineInfoDAOImpl().selectByBasicId(conn, basicInfoUsername);
			int result= dao.wineSellerSellDay(conn, new java.util.Date(date.getTime()), wineSellerId);
			return new Gson().toJson(result);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(conn);
		}
		return null;
	}

	//	와인상품 주문회원 정보조회
	@Override
	public String readByCustomerWineOrder(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicUsername")+"";
		int wineSellerId= new WineInfoDAOImpl().selectByBasicId(conn, basicInfoUsername);
		return null;
		//	뷰에서 고객 이름? 고객 아이디 뷰되어 있는 것을 와인업주 회원이 클릭하여 
		//	상세정보를 보는 것인지? 회의후 결정하고 추후 작업완료 하겠습니다.
	}

	//	와인주문 추가.
	@Override
	public String createStart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
		//	폼에 뷰되어야 할 것이 없습니다.
	}

	//	와인주문 추가
	@Override
	public String createEnd(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM/DD");
		java.util.Date date= null;
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		try {
			date= sdf.parse(request.getParameter("wineOrderDate"));
			int wineOrderAmount= Integer.parseInt(request.getParameter("wineOrderAmount"));
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int wineSellerId= dao.selectWineOrderIdByWineSellerId(conn, wineOrderId)
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String delete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
