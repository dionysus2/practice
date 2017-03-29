package dionysus.wine.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
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
		mav.setView("#.jsp");
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
	@RequestMapping(value = "/resinfo/insert", method = "GET")
	public static ModelAndView insertStar(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setView("/jaehyuntest/insert.jsp");
		return mav;
	}
	@RequestMapping(value = "/resinfo/insert", method = "POST")
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
				request.setAttribute("resInfoName", item.getString("UTF-8"));
		        else if(item.getFieldName().equals("resInfoPicture1"))
				request.setAttribute("resInfoPicture1", item.getString("UTF-8"));
		        else if(item.getFieldName().equals("resInfoPicture2"))
				request.setAttribute("resInfoPicture2", item.getString("UTF-8"));
		        else if(item.getFieldName().equals("resInfoPicture3"))
				request.setAttribute("resInfoPicture3", item.getString("UTF-8"));
		        else if(item.getFieldName().equals("resInfoAvailableSeat"))
				request.setAttribute("resInfoAvailableSeat",item.getString("UTF-8"));
		        else if(item.getFieldName().equals("resInfoOpeningHours"))
				request.setAttribute("resInfoOpeningHours",item.getString("UTF-8"));
				else if(item.getFieldName().equals("resInfoWebsite"))
				request.setAttribute("resInfoWebsite",item.getString("UTF-8"));
				else if(item.getFieldName().equals("resId"))
		        request.setAttribute("resId",item.getString("UTF-8"));
				}
			    else{
			    	String fileName= item.getName();
					int postOfPoint= fileName.indexOf(".");
					String fName= fileName.substring(0, postOfPoint);
					String ext= fileName.substring(postOfPoint);
					fileName= fName+"-"+System.nanoTime()+"."+ext;
					item.write(new File(path+"/"+fileName));
					logger.info("전송되는wineInfoProfilePicture"+fileName);
			    }
				} 
		request.setAttribute("resInfoId", session.getAttribute("basicInfoUsername"));
		if(service.ResInfoCreateEnd(request).equals("{\"result\":\"success\"}")){
			logger.info("레스토랑정보 추가완료");
			mav.setView("list");
			mav.setRedirect();
			return mav;
		}else{
			logger.info("추가안됨.");
			mav.setView("insert");
			mav.setRedirect();
			return mav;
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
