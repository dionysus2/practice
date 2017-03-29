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

	@RequestMapping(value = "/resinfo/list", method = "GET")
	public static ModelAndView readAllResInfo(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		ResInfoServiceImpl service = (ResInfoServiceImpl) request.getServletContext().getAttribute("resinfoservice");
		mav.setView("/kibacktest/list.jsp");
		mav.addObject("result", service.readAllResInfo(request));
		logger.info("레스토랑정보 전체리스트 출력");
		return mav;
	}

	@RequestMapping(value = "/resinfo/view", method = "GET")
	public static ModelAndView readByResInfoId(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		ResInfoServiceImpl service = (ResInfoServiceImpl) request.getServletContext().getAttribute("resinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readByResInfoId(request));
		return mav;
	}

	@RequestMapping(value = "/resinfo/ownerlist", method = "GET")
	public static ModelAndView readByResOwnerResInfo(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		ResInfoServiceImpl service = (ResInfoServiceImpl) request.getServletContext().getAttribute("resinfoservice");
		mav.setView("#.jsp");
		mav.addObject("result", service.readResOwnerResInfo(request));
		return mav;
	}

	public static ModelAndView insertStar(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setView("/jaehyuntest/insert.jsp");
		return mav;
	}

	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		ResInfoServiceImpl service = (ResInfoServiceImpl)request.getServletContext().getAttribute("resinfoservice");
		HttpSession session = request.getSession();
		String path = request.getServletContext().getRealPath("img");
		DiskFileItemFactory df = new DiskFileItemFactory();
		ServletFileUpload uploader = new ServletFileUpload(df);
		uploader.setSizeMax(320*480*10);
		try {
			List<FileItem>list = uploader.parseRequest(request);
			for(FileItem item:list){
			if(item.isFormField()){
				if(item.getFieldName().equals("resInfoName"))
				request.setAttribute("wineInfoName", item.getString("UTF-8"));
			
				else if(item.getFieldName().equals("resInfoPicture1"))
				request.setAttribute("wineInfoName", item.getString("UTF-8"));
			}
		} 
			
		}
		catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
}
