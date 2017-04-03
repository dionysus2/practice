package dionysus.wine.controller;

import javax.servlet.http.*;

import dionysus.wine.di.*;
import dionysus.wine.serviceimpl.*;

public class ResController {
	@RequestMapping(value="/res/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/sangtae/resjoin.jsp");
		return mav;
	}
	@RequestMapping(value="/res/insert", method="POST")
	public static ModelAndView insertRes(HttpServletRequest request) throws Exception{
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
	@RequestMapping(value="/res/list", method="GET")
	public static ModelAndView list(HttpServletRequest request) throws Exception{
		ResServiceImpl service =(ResServiceImpl)request.getServletContext().getAttribute("resservice");
		ModelAndView mav= new ModelAndView();		
		mav.setView("/sangtae/list.jsp");
		mav.addObject("result", service.readAllRes(request));
		System.out.println("와인회원 정보 전체 출력");
		return mav;
	}
	@RequestMapping(value="/res/list", method="AJAX")
	public static ModelAndView listAjax(HttpServletRequest request) throws Exception{
		ResServiceImpl service =(ResServiceImpl)request.getServletContext().getAttribute("resservice");
		ModelAndView mav= new ModelAndView();
		mav.addObject("result", service.readAllRes(request));
		System.out.println("여기는 포스트");
		return mav;
	}
	@RequestMapping(value="/res/update", method="GET")
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
