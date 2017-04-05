package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.Date;
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
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.daoimpl.WineInfoDAOImpl;
import dionysus.wine.daoimpl.WineOrderDAOImpl;
import dionysus.wine.daoimpl.WineOrderInfoDAOImpl;
import dionysus.wine.service.WineOrderService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.WineInfo;
import dionysus.wine.vo.WineOrder;
import dionysus.wine.vo.WineOrderInfo;

public class WineOrderServiceImpl implements WineOrderService {

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
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-DD");
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
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-DD");
		java.util.Date date= null;
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		try {
			date= sdf.parse(request.getParameter("wineOrderDate"));
			int wineOrderInfoCount= Integer.parseInt(request.getParameter("wineOrderInfoCount"));
			int wineOrderAmount= ((int)session.getAttribute("wineInfoPrice"))*wineOrderInfoCount;
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int wineSellerId= (int)session.getAttribute("wineSellerId");
			Date getDate= new Date(date.getTime());
			int wineOrderResult= dao.wineOrderInsert(conn, new WineOrder(getDate, wineOrderAmount, customerId, wineSellerId));
			//	와인상세를 위한 추가
			int wineOrderId= dao.selectWinOrderIdMax(conn);
			int wineInfoId= (int)session.getAttribute("wineInfoId");
			int wineOrderInfoResult= new WineOrderInfoDAOImpl().wineOrderInfoInsert(conn, wineOrderInfoCount, wineOrderId, wineInfoId);
			System.out.println("개수"+wineOrderInfoCount);
			System.out.println("총가격"+wineOrderAmount);
			System.out.println("고객ID"+customerId);
			System.out.println("상품등록업주번호"+wineSellerId);
			System.out.println("요청일자"+getDate);
			System.out.println("오더아이디"+wineOrderId);
			System.out.println("와인정보아이디"+wineInfoId);
			JsonObject ob= new JsonObject();
			if(wineOrderResult==1 && wineOrderInfoResult==1){
				ob.addProperty("result", "success");
			}
			else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//	와인주문 취소
	@Override
	public String delete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= session.getAttribute("basicInfoUsername")+"";
		try {
			int customerId= new BasicInfoDAOImpl().selectByUsernameOfCustomerId(conn, basicInfoUsername);
			int wineOrderId= dao.selectByCustomerIdOfWineOrderId(conn, customerId);
			int result= dao.wineOrderDelete(conn, wineOrderId);
			JsonObject ob= new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
			}
			else{
				ob.addProperty("result", "fail");
			}
			return new Gson().toJson(ob);
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
	
	//	아이디별 주문정보 가져오기.
	public String readByBasicInfoUsernameWineOrder(HttpServletRequest request){
		Connection conn= JDBCUtil.getConnection();
		HttpSession session= request.getSession();
		String basicInfoUsername= (String)session.getAttribute("basicInfoUsername");
		try {
			HashMap<String, Object>map= new HashMap<String, Object>();
			ArrayList<WineOrder>orderList= dao.selectByWineOrderBasicInfoUsername(conn, basicInfoUsername);
			ArrayList<WineOrderInfo>orderInfoList= new WineOrderInfoDAOImpl().selectByBasicInfoUsernameWineInfoId(conn, basicInfoUsername);
			ArrayList<WineInfo> wineList= new ArrayList<WineInfo>();
			for(WineOrderInfo wine: orderInfoList){
				int result= wine.getWineInfoId();
				wineList.add(new WineInfoDAOImpl().selectByWineInfoId(conn, result));
			}
			logger.info("리스트 정보"+wineList);
			map.put("wineList", wineList);
			map.put("orderList", orderList);
			map.put("orderInfoList", orderInfoList);
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
}
