package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.BasicInfoServiceImpl;

public class BasicInfoController {
	private static Logger logger= LoggerFactory.getLogger(BasicInfoController.class);
	/*
	Main index에 존재하기에 GET폼을 띄워주지 않고 POST방식으로만 URL을 검색하여 데이터를 빼옵니다.
	
	@RequestMapping(value="/basic/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/modals/forms/join.html");
		return mav;
	}
	
	*/
	@RequestMapping(value="/basic/insert", method="POST")
	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		BasicInfoServiceImpl service= (BasicInfoServiceImpl)request.getServletContext().getAttribute("basicinfoservice");
		if(service.createEnd(request).equals("{\"result\":\"success\"}")){
			logger.info("Controller회원가입 추가성공");
			mav.setView("/dionysus/main/home");
			//	추가정보 입력 폼으로 이동 => 고객, 와인업주, 레스토랑 업주 => insert후 login창 이동
			mav.setRedirect();
			return mav;
		}
		else {
			mav.setRedirect();
			mav.setView("insert");
			return mav;
		}
	}
	/*
	Main index에 존재하기에 GET폼을 띄워주지 않고 POST방식으로만 URL을 검색하여 데이터를 빼옵니다.
	 
	@RequestMapping(value="/customer/login", method="GET")
	public static ModelAndView loginStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/modals/forms/signin.html");
		return mav;
	}
	
	*/
	@RequestMapping(value="/customer/login", method="POST")
	public static ModelAndView loginEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		BasicInfoServiceImpl service= (BasicInfoServiceImpl)request.getServletContext().getAttribute("basicinfoservice");
		if(service.login(request).equals("{\"result\":\"success\"}")){
			logger.info("Controller로그인 성공");
			HttpSession session= request.getSession();
			session.setAttribute("basicInfoUsername", request.getParameter("basicInfoUsername"));
			mav.setView("/dionysus/main/home");
			mav.setRedirect();
			return mav;
		}
		else{
			logger.info("Conroller로그인 실패");
			mav.setView("login");
			mav.setRedirect();
			return mav;
		}
	}
	@RequestMapping(value="/basic/update", method="GET")
	public static ModelAndView updateStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		BasicInfoServiceImpl service= (BasicInfoServiceImpl)request.getServletContext().getAttribute("basicinfoservice");
		HttpSession session= request.getSession();
		if(session!=null){
			session.getAttribute("basicInfoUsername");
			mav.addObject("result", service.updateStart(request));
			mav.setView("/jaehyuntest/basicupdate.jsp");
			return mav;
		}
		mav.setView("/jaehyuntest/basiclogin.jsp");
		return mav;
	}
	
	public static ModelAndView updateEnd(HttpServletRequest request){
		return null;
		//	다음에
	}
	@RequestMapping(value="/main/home", method="GET")
	public static ModelAndView homeMain(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/index.html");
		return mav;
	}
}
