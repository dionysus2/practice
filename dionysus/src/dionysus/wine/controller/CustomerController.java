package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.CustomerServiceImpl;


public class CustomerController {
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@RequestMapping(value = "/customer/list", method = "GET")
	public static ModelAndView readCustomerAll(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		CustomerServiceImpl service = (CustomerServiceImpl) request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.readCustomerAll(request));
		logger.info("회원정보 전체리스트 출력");
		return mav;
	}
	
	@RequestMapping(value="/customer/agelist", method="GET")
	public static ModelAndView readCustomerAge (HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.readCustomerAge(request));
		return mav;
	}
	
	@RequestMapping(value="/customer/joblist", method="GET")
	public static ModelAndView readCustomerJob (HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.readCustomerJob(request));
		return mav;
	}
	
	@RequestMapping(value="/customer/genderlist", method="GET")
	public static ModelAndView readCustomerGender (HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.readCustomerGender(request));
		return mav;
	}
	
	@RequestMapping(value="/customer/namelist", method="GET")
	public static ModelAndView readCustomerName (HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.readCustomerName(request));
		return mav;
	}
	
	@RequestMapping(value="/customer/insert", method="POST")
	public static ModelAndView createCustomer(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		logger.info("서비스호출");
		if(service.createCustomer(request).equals("{\"result\":\"success\"}")){
			logger.info("회원정보 추가완료");
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			logger.info("추가안됨.");
			mav.setView("insert");
			mav.setRedirect();
			return mav;
		}
	}
	
	@RequestMapping(value="/customer/update", method="POST")
	public static ModelAndView updateCustomer(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.updateCustomer(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("update");
			mav.setRedirect();
			return mav;
		}
	}
	
	@RequestMapping(value="/customer/delete", method="GET")
	public static ModelAndView deleteCustomer(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.deleteCustomer(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
	}
	
	@RequestMapping(value="/customer/idfind", method="GET")
	public static ModelAndView CustomerIdFind(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		CustomerServiceImpl service = (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.customerIdFind(request));
		
		return mav;
	}
	
	@RequestMapping(value="/customer/pwdfind", method="GET")
	public static ModelAndView CustomerPwdFind(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		CustomerServiceImpl service = (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.customerPwdFind(request));
		
		return mav;
	}
	
	@RequestMapping(value = "/customer/resreservlist", method = "GET")
	public static ModelAndView CustomerResReserv(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		CustomerServiceImpl service = (CustomerServiceImpl) request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.customerResReserv(request));
		logger.info("회원 레스토랑 예약정보 전체리스트 출력");
		return mav;
	}
	
	@RequestMapping(value="/customer/resreservupdate", method="POST")
	public static ModelAndView customerResReservUpdate(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.customerResReservUpdate(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("update");
			mav.setRedirect();
			return mav;
		}
	}
	
	@RequestMapping(value="/customer/resreservdelete", method="GET")
	public static ModelAndView customerResReservDelete(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.customerResReservDelete(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
	}
	
	@RequestMapping(value = "/customer/lastreservlist", method = "GET")
	public static ModelAndView CustomerLastResReserv(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		CustomerServiceImpl service = (CustomerServiceImpl) request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.customerLastResReserv(request));
		logger.info("회원 레스토랑 지난 예약정보 전체리스트 출력");
		return mav;
	}
	
	@RequestMapping(value = "/customer/wineorderlist", method = "GET")
	public static ModelAndView CustomerWineOrder(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		CustomerServiceImpl service = (CustomerServiceImpl) request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.customerWineOrder(request));
		logger.info("회원 와인 주문 전체리스트 출력");
		return mav;
	}
	
	@RequestMapping(value="/customer/wineorderupdate", method="POST")
	public static ModelAndView customerWineOrderUpdate(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.customerWineOrderUpdate(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("update");
			mav.setRedirect();
			return mav;
		}
	}
	
	@RequestMapping(value="/customer/wineorderdelete", method="GET")
	public static ModelAndView customerWineOrderDelete(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.customerWineOrderDelete(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
	}
	
	@RequestMapping(value = "/customer/winecartlist", method = "GET")
	public static ModelAndView CustomerWineWishlist(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		CustomerServiceImpl service = (CustomerServiceImpl) request.getServletContext().getAttribute("customerservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.customerWineWishList(request));
		logger.info("회원 와인 장바구니 전체리스트 출력");
		return mav;
	}
	
	@RequestMapping(value = "/customer/winecartorder", method = "POST")
	public static ModelAndView CustomerWineWishlistOrder(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		CustomerServiceImpl service = (CustomerServiceImpl) request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.customerWineWishListOrder(request));
		return mav;
	}
	
	@RequestMapping(value="/customer/winecartdelete", method="GET")
	public static ModelAndView customerWineWishlistDelete(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		CustomerServiceImpl service= (CustomerServiceImpl)request.getServletContext().getAttribute("customerservice");
		mav.addObject("result", service.customerWineWishListDelete(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
	}
	
	
	
	
}
