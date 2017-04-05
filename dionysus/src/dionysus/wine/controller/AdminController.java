package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;

public class AdminController {
	@RequestMapping(value="/manager/home", method="GET")
	public static ModelAndView mangerMainHome(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/sellers/manage.html");
		return mav;
	}
}
