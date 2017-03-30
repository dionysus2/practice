package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dionysus.wine.daoimpl.CustomerDAOImpl;
import dionysus.wine.service.CustomerService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.util.PagingUtil;
import dionysus.wine.vo.Customer;
import dionysus.wine.vo.NoticeComment;
import dionysus.wine.vo.Pagination;
import dionysus.wine.vo.ResReserv;
import dionysus.wine.vo.WineInfo;
import dionysus.wine.vo.WineOrder;
import dionysus.wine.vo.WineWishlist;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDAOImpl dao;
	public CustomerServiceImpl (CustomerDAOImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	private Logger logger= LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public String readCustomerAll(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
	      try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	            logger.info("사용자 페이지 요청");
	         }
	         int cntOfRow= dao.CustomerCount(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<Customer>list= dao.selectAllCustomer(conn);
	         HashMap<String, Object> map= new HashMap<String, Object>();
	         map.put("pagination", pagination);
	         map.put("list", list);
	         logger.info("서비스단 페이징"+pagination);
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

	@Override
	public String readCustomerAge(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(req.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(req.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			String customerAge = req.getParameter("customerAge");
			int cntOfRow= dao.selectByCustomerAge(conn, customerAge);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<Customer>list= dao.selectByCustomerAge(conn, customerAge, pagination.getStartRow(), pagination.getLastRow());
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

	@Override
	public String readCustomerJob(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(req.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(req.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			String customerJob = req.getParameter("customerJob");
			int cntOfRow = dao.selectByCustomerJob(conn, customerJob);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<Customer>list= dao.selectByCustomerJob(conn, customerJob, pagination.getStartRow(), pagination.getLastRow());
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

	@Override
	public String readCustomerGender(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(req.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(req.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			String customerGender = req.getParameter("customerGender");
			int cntOfRow= dao.selectByCustomerGender(conn, customerGender);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<Customer>list= dao.selectByCustomerGender(conn, customerGender, pagination.getStartRow(), pagination.getLastRow());
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

	@Override
	public String readCustomerName(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			int pageNo= 1;
			if(req.getParameter("pageNo")!=null){
				pageNo= Integer.parseInt(req.getParameter("pageNo"));
				logger.info("사용자 페이징 요청");
			}
			String customerName = req.getParameter("customerName");
			int cntOfRow= dao.selectByCustomerName(conn, customerName);
			Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
			ArrayList<Customer>list= dao.selectByCustomerName(conn, customerName, pagination.getStartRow(), pagination.getLastRow());
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

	@Override
	public String createCustomer(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			logger.info("Connection연결성공");
			int result= dao.CustomerJoin(conn, customer);
			JsonObject ob= new JsonObject();
			if(result==1){
				ob.addProperty("result", "success");
				logger.info("DAO INSERT입력성공");
			}
			else{
				ob.addProperty("result", "fail");	
				logger.info("DAO INSERT입력실패");
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
	

	@Override
	public String updateCustomer(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			Customer customer = dao.CustomerInfoUpdate(conn, customer);
			return new Gson().toJson(customer);
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

	@Override
	public String customerIdFind(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerPwdFind(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerResReserv(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
	      try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	            logger.info("사용자 페이지 요청");
	         }
	         int cntOfRow= dao.CustomerResReserv(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<ResReserv>list= dao.CustomerResReserv(conn);
	         HashMap<String, Object> map= new HashMap<String, Object>();
	         map.put("pagination", pagination);
	         map.put("list", list);
	         logger.info("서비스단 페이징"+pagination);
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

	@Override
	public String customerResReservUpdate(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			ResReserv reserv = dao.CustomerResReserv(conn);
			return new Gson().toJson(reserv);
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

	@Override
	public String customerResReservDelete(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		int customerId = req.getParameter("customerId");
		try {
			int result= dao.customerResReservDelete(conn, customerId);
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

	@Override
	public String customerLastResReserv(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
	      try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	            logger.info("사용자 페이지 요청");
	         }
	         int cntOfRow= dao.SelectLastResReserv(conn, date);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<ResReserv>list= dao.SelectLastResReserv(conn, date);
	         HashMap<String, Object> map= new HashMap<String, Object>();
	         map.put("pagination", pagination);
	         map.put("list", list);
	         logger.info("서비스단 페이징"+pagination);
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

	@Override
	public String customerWineOrder(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
	      try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	            logger.info("사용자 페이지 요청");
	         }
	         int cntOfRow= dao.SelectCustomerWineOrder(conn);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineOrder>list= dao.SelectCustomerWineOrder(conn);
	         HashMap<String, Object> map= new HashMap<String, Object>();
	         map.put("pagination", pagination);
	         map.put("list", list);
	         logger.info("서비스단 페이징"+pagination);
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

	@Override
	public String customerWineOrderDelete(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		int customerId = req.getParameter("customerId");
		try {
			int result= dao.CustomerWineOrderDelete(conn, customerId);
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

	@Override
	public String customerWineOrderUpdate(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		try {
			WineOrder order = dao.CustomerWineOrderUpdate(conn, wineorder);
			return new Gson().toJson(order);
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

	@Override
	public String customerWineWishList(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
	      try {
	         int pageNo= 1;
	         if(req.getParameter("pageNo")!=null){
	            pageNo= Integer.parseInt(req.getParameter("pageNo"));
	            logger.info("사용자 페이지 요청");
	         }
	         int cntOfRow= dao.CustomerWineCart(conn, customerId);
	         Pagination pagination= PagingUtil.getPagination(pageNo, cntOfRow);
	         ArrayList<WineWishlist>list= dao.CustomerWineCart(conn, customerId);
	         HashMap<String, Object> map= new HashMap<String, Object>();
	         map.put("pagination", pagination);
	         map.put("list", list);
	         logger.info("서비스단 페이징"+pagination);
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

	@Override
	public String customerWineWishListOrder(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerWineWishListDelete(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Connection conn= JDBCUtil.getConnection();
		int customerId = req.getParameter("customerId");
		try {
			int result= dao.CustomerWineCartDelete(conn, customerId);
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

}
