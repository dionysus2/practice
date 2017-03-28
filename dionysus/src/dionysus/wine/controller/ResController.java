package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.BasicInfoServiceImpl;
import dionysus.wine.serviceimpl.ResServiceImpl;

public class ResController {
	@RequestMapping(value="/res/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/sangtae/resjoin.jsp");
		return mav;
	}
	@RequestMapping(value="/basic/insert", method="POST")
	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		ResServiceImpl service= (ResServiceImpl)request.getServletContext().getAttribute("resservice");
		if(service.createRes(request).equals("{\"result\":\"success\"}")){
			System.out.println("성공!");
			mav.setView("login");
			mav.setRedirect();
			return mav;
		}
		else if(service.createRes(request).equals("{\"result\":\"fail\"}")){
			mav.setRedirect();
			mav.setView("insert");
			return mav;
		}
		mav.setView("insert");
		mav.setRedirect();
		return null;
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
		else if(service.login(request).equals("{\"result\":\"fail\"}")){
			logger.info("Conroller로그인 실패");
			mav.setView("login");
			mav.setRedirect();
			return mav;
		}
		mav.setView("login");
		mav.setRedirect();
		return mav;
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
