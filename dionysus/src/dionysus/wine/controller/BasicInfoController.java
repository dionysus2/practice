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
	@RequestMapping(value="/basic/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("http://localhost:8087/dionysus/modals/forms/join.html");
		return mav;
	}
	@RequestMapping(value="/basic/insert", method="POST")
	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		BasicInfoServiceImpl service= (BasicInfoServiceImpl)request.getServletContext().getAttribute("basicinfoservice");
		if(service.createEnd(request).equals("{\"result\":\"success\"}")){
			logger.info("Controller회원가입 추가성공");
			mav.setView("login");
			mav.setRedirect();
			return mav;
		}
		else {
			mav.setRedirect();
			mav.setView("insert");
			return mav;
		}
	}
	@RequestMapping(value="/basic/login", method="GET")
	public static ModelAndView loginStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/jaehyuntest/basiclogin.jsp");
		return mav;
	}
	@RequestMapping(value="/basic/login", method="POST")
	public static ModelAndView loginEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		BasicInfoServiceImpl service= (BasicInfoServiceImpl)request.getServletContext().getAttribute("basicinfoservice");
		if(service.login(request).equals("{\"result\":\"success\"}")){
			logger.info("Controller로그인 성공");
			HttpSession session= request.getSession();
			session.setAttribute("basicInfoUsername", request.getParameter("basicInfoUsername"));
			mav.setView("/dionysus/jaehyuntest/main.jsp");
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
}
