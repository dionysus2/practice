package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.BasicInfoServiceImpl;
import dionysus.wine.serviceimpl.WineSellerServiceImpl;

public class WineSellerController {
	//	와인업주 신청 폼뷰
	@RequestMapping(value="/manager/insert", method="GET")
	public static ModelAndView createWineSellerStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/sellers/join.html");
		return mav;
	}
	
	//	와인업주 신청완료
	@RequestMapping(value="/manager/insert", method="POST")
	public static ModelAndView createWineSellerEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineSellerServiceImpl service= (WineSellerServiceImpl)request.getServletContext().getAttribute("wineSellerService");
		HttpSession session= request.getSession();
		if(service.createWineSeller(request).equals("{\"result\":\"success\"}")){
			mav.setView("/dionysus/main/home");
			mav.setRedirect();
			//	성공시 고객정보 가입을 위해 필요했던 basicInfoId를 세션에서 지운다.
			session.removeAttribute("basicInfoId");
			return mav;
		}
		else{
			mav.setView("/dionysus/manager/insert");
			mav.setRedirect();
			return mav;
		}
	}
	
	//	로그인 접속폼 뷰
	@RequestMapping(value="/manager/login", method="GET")
	public static ModelAndView wineSellerLoginStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/admin/login.jsp");
		return mav;
	}
	
	//	로그인 접속시도 완료.
	@RequestMapping(value="/manager/login", method="POST")
	public static ModelAndView wineSellerLoginEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineSellerServiceImpl service= (WineSellerServiceImpl)request.getServletContext().getAttribute("wineSellerService");
		HttpSession session= request.getSession();
		if(service.login(request).equals("{\"result\":\"success\"}")){
			String go= (String)session.getAttribute("go");
			session.removeAttribute("go");
			if(go==null)
				go= "/dionysus/manager/login";
			mav.setView("/dionysus/manager/home");
			mav.setRedirect();
			session.setAttribute("basicInfoUsername", request.getParameter("basicInfoUsername"));
			return mav;
		}
		else{
			mav.setView("/dionysus/manager/login");
			return mav;
		}
	}
	
}
