package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.NoticeServiceImpl;

public class NoticeController {
	private static Logger logger = LoggerFactory.getLogger(NoticeController.class);

	//	공지사항 전체조회
	@RequestMapping(value = "/notice/list", method = "GET")
	public static ModelAndView readNotice(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		NoticeServiceImpl service = (NoticeServiceImpl)request.getServletContext().getAttribute("noticeService");
		mav.setView("/board/list.jsp");
		mav.addObject("result", service.readNotice(request));
		return mav;
	}
	
	@RequestMapping(value="/notice/insert", method="POST")
	public static ModelAndView createNotice(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		NoticeServiceImpl service= (NoticeServiceImpl)request.getServletContext().getAttribute("noticeservice");
		logger.info("서비스호출");
		if(service.createNotice(request).equals("{\"result\":\"success\"}")){
			logger.info("공지사항 추가완료");
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
	
	@RequestMapping(value="/notice/update", method="POST")
	public static ModelAndView updateNotice(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		NoticeServiceImpl service= (NoticeServiceImpl)request.getServletContext().getAttribute("noticeservice");
		mav.addObject("result", service.updateNotice(request));
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
	
	@RequestMapping(value="/notice/delete", method="GET")
	public static ModelAndView deleteNotice(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		NoticeServiceImpl service= (NoticeServiceImpl)request.getServletContext().getAttribute("noticeservice");
		mav.addObject("result", service.deleteNotice(request));
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
	
	//	공지사항 번호별 상세 조회
	@RequestMapping(value = "/notice/view", method = "GET")
	public static ModelAndView viewNotice(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		NoticeServiceImpl service = (NoticeServiceImpl)request.getServletContext().getAttribute("noticeService");
		mav.setView("/board/noticedetail.jsp");
		mav.addObject("result", service.readByNoticeId(request));
		return mav;
	}
}
