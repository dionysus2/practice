package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.WineInfoServiceImpl;

public class WineInfoController {
	private Logger logger= LoggerFactory.getLogger(WineInfoController.class);
	@RequestMapping(value="/wineinfo/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		return mav;
	}
	@RequestMapping(value="/wineinfo/insert", method="POST")
	public static ModelAndView inserEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.addObject("result", service.wineInfoCreateEnd(request));		
		//	result success일때, fail일때 다른view 이동 추가코딩 필요함
		mav.setView("list");				
		//	상품추가 후 이동페이지 설정 다시정할 필요있음.
		mav.setRedirect();
		return mav;
	}
}
