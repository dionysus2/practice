package dionysus.wine.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.NoticeCommentServiceImpl;

public class NoticeCommentController {
	private static Logger logger = LoggerFactory.getLogger(NoticeCommentController.class);

	@RequestMapping(value = "/noticecomment/list", method = "GET")
	public static ModelAndView readNoticeComment(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		NoticeCommentServiceImpl service = (NoticeCommentServiceImpl) request.getServletContext().getAttribute("noticecommentservice");
		mav.setView("/sugatest/list.jsp");
		mav.addObject("result", service.readNoticeComment(request));
		logger.info("공지사항 댓글 전체리스트 출력");
		return mav;
	}
	
	@RequestMapping(value="/noticecomment/insert", method="POST")
	public static ModelAndView createNoticeComment(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		NoticeCommentServiceImpl service= (NoticeCommentServiceImpl)request.getServletContext().getAttribute("noticecommentservice");
		logger.info("서비스호출");
		if(service.createNoticeComment(request).equals("{\"result\":\"success\"}")){
			logger.info("공지사항 댓글 추가완료");
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
	
	@RequestMapping(value="/noticecomment/update", method="POST")
	public static ModelAndView updateNoticeComment(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		NoticeCommentServiceImpl service= (NoticeCommentServiceImpl)request.getServletContext().getAttribute("noticecommentservice");
		mav.addObject("result", service.updateNoticeComment(request));
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
	
	@RequestMapping(value="/noticecomment/delete", method="GET")
	public static ModelAndView deleteNoticeComment(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		NoticeCommentServiceImpl service= (NoticeCommentServiceImpl)request.getServletContext().getAttribute("noticecommentservice");
		mav.addObject("result", service.deleteNoticeComment(request));
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
