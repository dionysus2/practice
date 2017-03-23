package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.BasicInfoServiceImpl;

public class BasicInfoController {
	private static Logger logger= LoggerFactory.getLogger(BasicInfoController.class);
	@RequestMapping(value="/basicjoin/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/test2.jsp");
		return mav;
	}
	@RequestMapping(value="/basicjoin/insert", method="POST")
	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		BasicInfoServiceImpl service= (BasicInfoServiceImpl)request.getServletContext().getAttribute("service");
		mav.addObject("result", service.createEnd(request));
		if(service.createEnd(request).equals("success")){
			logger.info("Controller회원가입 추가성공");
			mav.setView("/index.html");
			mav.setRedirect();
			return mav;
		}
		else if(service.createEnd(request).equals("fail")){
			mav.setView("insert");
			mav.setRedirect();
			return mav;
		}
		logger.info("Controller회원가입 추가실패");
		mav.setView("/index.html");
		mav.setRedirect();
		return null;
	}
}
