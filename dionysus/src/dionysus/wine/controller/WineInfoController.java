package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.WineInfoServiceImpl;

public class WineInfoController {
	/*											
	 *	와인상품 전체리스트 조회		
	 *	단가높은순 조회					
	 *	단가낮은순 조회					
	 *	와인상품 원산지별 조회			
	 *	와인상품 추가						
	 *	와인상품 정보수정					
	 *	와인상품 삭제							
	 *	회사리스트별 상품조회 	
	 *	와인번호별 와인상품 상세정보 조회
	 */
	// 상품 전체리스트 조회하기
	private static Logger logger= LoggerFactory.getLogger(WineInfoController.class);
	@RequestMapping(value="/wineinfo/list", method="GET")
	public static ModelAndView readAllWineInfo(HttpServletRequest request){
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
		mav.setView("#.jsp");
		mav.addObject("result", service.readByWineInfoId(request));
		return mav;
	}

	//	상품 전체리스트 원산지별 조회하기 
	@RequestMapping(value="/wineinfo/originlist", method="GET")
	public static ModelAndView readByWineInfoOrigin(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readOriginWineInfo(request));
		return mav;
	}
	//	단가 높은순으로 상품 전체조회하기
	@RequestMapping(value="/wineinfo/listofpricemax", method="GET")
	public static ModelAndView readByWineInfoPriceMax(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readPriceMax(request));
		return mav;
	}
	//	단가 낮은순으로 상품 전체 조회하기
	@RequestMapping(value="/wineinfo/listofpricemin", method="GET")
	public static ModelAndView readByWineInfoPriceMin(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readPriceMin(request));
		return mav;
	}
}
