package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.BasicInfoServiceImpl;

public class BasicInfoController {
	@RequestMapping(value="/basicjoin/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("test2.jsp");
		return mav;
	}
	@RequestMapping(value="/basicjoin/insert", method="POST")
	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		BasicInfoServiceImpl service= (BasicInfoServiceImpl)request.getServletContext().getAttribute("service");
		if(service.createEnd(request).equals("success")){
			mav.setView("");
		}
	}
}
