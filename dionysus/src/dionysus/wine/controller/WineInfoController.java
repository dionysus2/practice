package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.WineInfoServiceImpl;

public class WineInfoController {
	// 상품 전체리스트 조회하기
	private static Logger logger= LoggerFactory.getLogger(WineInfoController.class);
	@RequestMapping(value="/wineinfo/list", method="GET")
	public static ModelAndView readAllWineInfo(HttpServletRequest request){
		logger.info("출력");
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("/search/wineInfo.jsp");
		mav.addObject("result", service.readAllWineInfo(request));
		logger.info("와인정보 전체리스트 출력");
		return mav;
	}

	//	상품 상세정보 보기 => 경로 추가 필요합니다.
	@RequestMapping(value="/wineinfo/view", method="GET")
	public static ModelAndView readByWineInfoIdStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("/search/detail.jsp");
		HttpSession session= request.getSession();
		session.setAttribute("wineInfoId", request.getParameter("wineInfoId"));
		mav.addObject("result", service.readByWineInfoId(request));
		return mav;
	}

	//	상품 전체리스트 원산지별 조회하기  => 경로 추가 필요합니다
	@RequestMapping(value="/wineinfo/originlist", method="GET")
	public static ModelAndView readByWineInfoOrigin(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readCountryWineInfo(request));
		return mav;
	}
	//	단가 높은순으로 상품 전체조회하기 => 경로 추가 필요합니다
	@RequestMapping(value="/wineinfo/listofpricemax", method="GET")
	public static ModelAndView readByWineInfoPriceMax(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readPriceMax(request));
		return mav;
	}
	//	단가 낮은순으로 상품 전체 조회하기  => 경로 추가 필요합니다
	@RequestMapping(value="/wineinfo/listofpricemin", method="GET")
	public static ModelAndView readByWineInfoPriceMin(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readPriceMin(request));
		return mav;
	}
	//	와인상품 생산국가별 조회  => 경로 추가 필요합니다
	@RequestMapping(value="/wineinfo/listofcountry", method="GET")
	public static ModelAndView readByCountry(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readCountryWineInfo(request));
		return mav;
	}
	//	와인상품 추가 폼 뷰	  => 경로 수정 필요합니다
	@RequestMapping(value="/wineinfo/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/jaehyuntest/insert.jsp");
		return mav;
	}
	//	와인상품 추가완료 => 경로 수정 필요합니다
	@RequestMapping(value="/wineinfo/insert", method="POST")
	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		logger.info("서비스호출");
		if(service.wineInfoCreateEnd(request).equals("{\"result\":\"success\"}")){
			logger.info("상품정보 추가완료");
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			logger.info("추가안됨.");
			mav.setView("insert");
			mav.setRedirect();
			return mav;
		}
	}
	//	회사리스트별 상품조회 => 경로 추가 필요합니다
	@RequestMapping(value="/wineinfo/listofwineseller", method="GET")
	public static ModelAndView readByWineSellerWineInfo(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readWineSellerWineInfo(request));
		return mav;
	}
	//	정보수정 폼 뷰 => 경로 추가 필요합니다
	@RequestMapping(value="/wineinfo/update", method="GET")
	public static ModelAndView updateStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.wineInfoUpdateStart(request));
		return mav;
	}
	//	정보수정 완료 => 경로 수정 필요합니다
	@RequestMapping(value="/wineinfo/update", method="POST")
	public static ModelAndView updateEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.addObject("result", service.wineInfoUpdateEnd(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("update");
			mav.setRedirect();
			return mav;
		}
	}
	//	와인정보 삭제 => 경로수정 및 로직검토 필요합니다.
	@RequestMapping(value="/wineinfo/delete", method="GET")
	public static ModelAndView delete(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.addObject("result", service.wineInfoDelete(request));
		if(mav.getObject("result").equals(true)){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
	}
}
