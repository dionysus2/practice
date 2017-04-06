package dionysus.wine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.di.ModelAndView;
import dionysus.wine.di.RequestMapping;
import dionysus.wine.serviceimpl.ResInfoServiceImpl;

public class ResInfoController {

	private static Logger logger = LoggerFactory.getLogger(ResInfoController.class);
	
	//	레스토랑 전체리스트 조회
	@RequestMapping(value = "/resinfo/list", method = "GET")
	public static ModelAndView readAllResInfo(HttpServletRequest request) throws Exception {
		//System.out.println("시작");s
		ModelAndView mav = new ModelAndView();
		ResInfoServiceImpl service = (ResInfoServiceImpl) request.getServletContext().getAttribute("resInfoservice");
		mav.setView("/kibacktest/list.jsp");
		mav.addObject("result", service.readAllResInfo(request));
		return mav;
	}

	@RequestMapping(value = "/resinfo/view", method = "GET")
	public static ModelAndView readByResInfoId(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		ResInfoServiceImpl service = (ResInfoServiceImpl) request.getServletContext().getAttribute("resinfoservice");
		mav.setView("#kibacktest/view.jsp");
		mav.addObject("result", service.readByResInfoId(request));
		return mav;
	}

	@RequestMapping(value = "/resinfo/ownerlist", method = "GET")
	public static ModelAndView readByResOwnerResInfo(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		ResInfoServiceImpl service = (ResInfoServiceImpl) request.getServletContext().getAttribute("resinfoservice");
		mav.setView("#kibacktest/ownerlist.jsp");
		mav.addObject("result", service.readResOwnerResInfo(request));
		return mav;
	}
	@RequestMapping(value = "/resinfo/insert", method = "GET")
	public static ModelAndView insertStar(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setView("/kibacktest/insert.jsp");
		return mav;
	}
	@RequestMapping(value = "/resinfo/insert", method = "POST")
	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		ResInfoServiceImpl service = (ResInfoServiceImpl)request.getServletContext().getAttribute("resinfoservice");
		if(service.ResInfoCreateEnd(request).equals("{\"result\":\"success\"}")){
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}
		else{
			mav.setView("insert");
			mav.setRedirect();
			return mav;
		}
	}
		@RequestMapping(value = "/resinfo/update", method = "GET")
		public static ModelAndView updateStar(HttpServletRequest request) {
			ModelAndView mav= new ModelAndView();
			ResInfoServiceImpl service = (ResInfoServiceImpl)request.getServletContext().getAttribute("resinfoservice");
			mav.setView("/kibacktest/update.jsp");
			mav.addObject("result", service.ResInfoUpdateStart(request));
			return mav;
	}
		@RequestMapping(value = "/resinfo/update", method = "POST")
		public static ModelAndView updateEnd(HttpServletRequest request) {
			ModelAndView mav= new ModelAndView();
			ResInfoServiceImpl service = (ResInfoServiceImpl)request.getServletContext().getAttribute("resinfoservice");
			mav.addObject("result", service.ResInfoUpdateEnd(request));
			if(mav.getObject("result").equals(true)){
				mav.setView("/kibacktest/update.jsp");
				mav.setRedirect();
				return mav;
			}
			else{
				mav.setView("update");
				mav.setRedirect();
				return mav;
			}
		}
			@RequestMapping(value = "/resinfo/delete", method = "GET")
			public static ModelAndView delete(HttpServletRequest request){
				ModelAndView mav= new ModelAndView();
				ResInfoServiceImpl service = (ResInfoServiceImpl)request.getServletContext().getAttribute("resinfoservice");
				mav.addObject("result", service.ResInfoDelete(request));
				if(mav.getObject("result").equals(true)){
					mav.setView("/kibacktest/delete.jsp");
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
