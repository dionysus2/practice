package dionysus.wine.serviceimpl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.daoimpl.CustomerDAOImpl;
import dionysus.wine.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDAOImpl dao;
	public CustomerServiceImpl (CustomerDAOImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	private Logger logger= LoggerFactory.getLogger(BasicInfoServiceImpl.class);
	
	@Override
	public String readCustomerAll(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readCustomerAge(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readCustomerJob(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readCustomerGender(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readCustomerName(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createCustomer(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCustomer(HttpServletRequest req) {
		// TODO Auto-generated method stub
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
	public String customerLogin(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerLogout(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerResReserv(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerResReservUpdate(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerResReservDelete(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerLastResReserv(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerWineOrder(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerWineOrderDelete(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerWineOrderUpdate(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerWineWishList(HttpServletRequest req) {
		// TODO Auto-generated method stub
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
		return null;
	}

}
