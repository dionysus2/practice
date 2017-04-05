package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.WineWishListServiceImpl;

public class WineWishListController {
	@RequestMapping(value="/wineinfo/wishlist/insert", method="POST")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineWishListServiceImpl service= (WineWishListServiceImpl)request.getServletContext().getAttribute("wineWishListService");
		mav.addObject("result", service.createWishList(request));
		mav.setView("/dionysus/wineinfo/list");
		return mav;
	}
}
