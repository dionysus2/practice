package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.WineOrderServiceImpl;

public class WineOrderController {

	//	와인상품 주문전체 리스트 조회하기
	@RequestMapping(value="/manager/wineinfo/wineorder/list", method="GET")
	public static ModelAndView readAllWineOrder(HttpServletRequest	request){
		ModelAndView mav= new ModelAndView();
		WineOrderServiceImpl service= (WineOrderServiceImpl)request.getServletContext().getAttribute("wineOrderService");
		mav.addObject("result", service.readAllWineOrderList(request));
		mav.setView("#.jsp");
		return mav;
	}
	
	//	와인상품 주문일자별 주문리스트 조회폼 뷰 (년별/월별)
	@RequestMapping(value="/manager/wineinfo/wineorder/month", method="GET")
	public static ModelAndView readWineOrderByMonthStart(HttpServletRequest request){
		// REQUEST에는 wineOrderDate가 있어야 합니다.
		ModelAndView mav= new ModelAndView();
		mav.setView("#.jsp");
		return mav;
	}
	
	//	와인상품 주문일자별 주문리스트 조회완료 (년별/월별)
	@RequestMapping(value="/manager/wineinfo/wineorder/month", method="POST")
	public static ModelAndView readWineOrderByMonthEnd(HttpServletRequest request){
		// REQUEST에는 wineOrderDate가 있어야 합니다.
		ModelAndView mav= new ModelAndView();
		WineOrderServiceImpl service= (WineOrderServiceImpl)request.getServletContext().getAttribute("wineOrderService");
		if(service.readByWineOrderDateMonth(request)==null){
			//	입력한 주문일자에 포함된 주문리스트가 null값일 때 보여줘야 하는 view
			//	Redirect합니다.
			mav.setView("#.jsp");
			mav.setRedirect();
		}
		mav.addObject("result", service.readByWineOrderDateMonth(request));
		mav.setView("#.jsp");
		return mav;
	}
	//	와인상품 주문일자별 주문리스트 조회하기 (년별/월별/일별)
	@RequestMapping(value="/manager/wineinfo/wineorder/day", method="GET")
	public static ModelAndView readWineOrderByDayStart(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setView("#.jsp");
		return mav;
	}
	//	와인상품 주문일자별 주문리스트 조회하기 (년별/월별/일별)
	@RequestMapping(value="/manager/wineinfo/wineorder/day", method="POST")
	public static ModelAndView readWineOrderByDayEnd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		WineOrderServiceImpl service= (WineOrderServiceImpl)request.getServletContext().getAttribute("wineOrderService");
		if(service.readByWineOrderDateMonth(request)==null){
			//	입력한 주문일자에 포함된 주문리스트가 null값일 때 보여줘야 하는 view
			//	Redirect합니다.
			mav.setView("#.jsp");
			mav.setRedirect();
		}
		mav.addObject("result", service.readByWineOrderDateDay(request));
		mav.setView("#.jsp");
		return mav;
	}
	//	와인상품 와인업주별 주문 리스트 조회
	@RequestMapping(value="/manager/wineinfo/wineorder/seller", method="GET")
	public static ModelAndView readWineOrderlistByWineSeller(HttpServletRequest request){
		//	로그인 되어있는 basicInfoUsername의 session을 service로 보내줍니다.
		//	service에서는 basicInfoUsername의 sellerId를 검색하여 주문이 들어온 리스트를 뿌려줍니다.
		ModelAndView mav= new ModelAndView();
		WineOrderServiceImpl service= (WineOrderServiceImpl)request.getServletContext().getAttribute("wineOrderService");
		mav.addObject("result", service.readByWineSellerWineOrder(request));
		mav.setView("#.jsp");
		return mav;
	}
	//	와인회사별 상품 주문건 판매량 조회
	@RequestMapping(value="/manager/wineinfo/wineorder/sellerAmount", method="GET")
	public static ModelAndView readWineOrderByWineSellerAmount(HttpServletRequest request){
		//	로그인 되어있는 basicInfoUsername의 session을 service로 보내줍니다.
		//	service에서는 basicInfoUsername의 sellerId를 검색하여 Amount의 sum을 연산하여 보내줍니다.
		ModelAndView mav= new ModelAndView();
		WineOrderServiceImpl service= (WineOrderServiceImpl)request.getServletContext().getAttribute("wineOrderService");
		mav.addObject("result", service.readByWineSellerWineOrderAmountSum(request));
		mav.setView("#.jsp");
		return mav;
	}
	//	와인회사별 년별/월별 판매량 조회 폼 뷰
	@RequestMapping(value="/manager/wineinfo/wineorder/sellerMonthAmount", method="GET")
	public static ModelAndView readWineOrderByWineSellerMonthAmountStart(HttpServletRequest request){
		//	요청할수 있는 년/월 체크 폼 뷰
		ModelAndView mav= new ModelAndView();
		mav.setView("#.jsp");
		return mav;
	}
	//	와인회사별 년별/월별 판매량 조회완료
	@RequestMapping(value="/manager/wineinfo/wineorder/sellerMonthAmount", method="POST")
	public static ModelAndView readWineOrderByWineSellerMonthAmountEnd(HttpServletRequest request){
		//	로그인 되어있는 basicInfoUsername의 session을 service로 보내줍니다.
		//	service에서는 basicInfoUsername의 sellerId를 검색되어진 것과,
		//	request로 보내지는 요청 년/월이 함께 dao에 보내어 지어 결과가 출력됩니다.
		ModelAndView mav= new ModelAndView();
		WineOrderServiceImpl service= (WineOrderServiceImpl)request.getServletContext().getAttribute("wineOrderService");
		mav.addObject("result", service.readByWineSellerWineOrderMonth(request));
		mav.setView("#.jsp");
		return mav;
	}
	//	와인회사별/년별/월별/일별 판매량 조회 폼 뷰
	@RequestMapping(value="/manager/wineinfo/wineorder/sellerDayAmount", method="GET")
	public static ModelAndView readWineOrderByWineSellerDayAmountSumStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("#,jsp");
		return mav;
	}
	//	와인회사별/년별/월별/일별 판매량 조회완료
	@RequestMapping(value="/manager/wineinfo/wineorder/sellerDayAmount", method="POST")
	public static ModelAndView readWineOrderByWineSellerDayAmountSumEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineOrderServiceImpl service= (WineOrderServiceImpl)request.getServletContext().getAttribute("wineOrderService");
		mav.setView("#.jsp");
		mav.addObject("result", service.readByWineSellerWineOrderDay(request));
		return mav;
	}
	//	와인상품 주문회원 정보조회(DAO, SERVICE작업 아직 못하였습니다)
	
	//	주문건 등록 폼뷰(주문상세 폼뷰 => 주문상세 정보완료=> 주문건 등록 폼뷰=> 주문건 등록 완료)
	@RequestMapping(value="/wineinfo/wineorder/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("#.jsp");
		return mav;
	}
	//	주문건 등록완료.
	@RequestMapping(value="/wineinfo/wineorder/insert", method="POST")
	public static ModelAndView isnertEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineOrderServiceImpl service= (WineOrderServiceImpl)request.getServletContext().getAttribute("wineOrderService");
		if(service.createEnd(request).equals("{\"result\":\"success\"}")){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("/wineorder/insert");
			mav.setRedirect();
			return mav;
		}
	}
	//	주문건 삭제	(jQuery로 처리)	
}