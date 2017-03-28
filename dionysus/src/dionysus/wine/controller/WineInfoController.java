package dionysus.wine.controller;

import java.io.File;
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
import dionysus.wine.serviceimpl.WineInfoServiceImpl;
import dionysus.wine.vo.WineInfo;

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
		mav.addObject("result", service.readCountryWineInfo(request));
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
	@RequestMapping(value="/wineinfo/insert", method="GET")
	public static ModelAndView insertStart(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setView("/jaehyuntest/insert.jsp");
		return mav;
	}
	@RequestMapping(value="/wineinfo/insert", method="POST")
	public static ModelAndView insertEnd(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		WineInfoServiceImpl service= (WineInfoServiceImpl)request.getServletContext().getAttribute("wineinfoservice");
		HttpSession session= request.getSession();
		String path= request.getServletContext().getRealPath("img");
		DiskFileItemFactory df= new DiskFileItemFactory();
		ServletFileUpload uploader= new ServletFileUpload(df);
		uploader.setSizeMax(320*480*10);
		try {
			List<FileItem>list= uploader.parseRequest(request);
			for(FileItem item: list){
				if(item.isFormField()){
					if(item.getFieldName().equals("wineInfoName"))
						request.setAttribute("wineInfoName", item.getString("UTF-8"));
					else if(item.getFieldName().equals("wineInfoPrice"))
						request.setAttribute("wineInfoPrice", item.getString("UTF-8"));
					else if(item.getFieldName().equals("wineInfoCapacity"))
						request.setAttribute("wineInfoCapacity", item.getString());
					else if(item.getFieldName().equals("wineInfoCountry"))
						request.setAttribute("wineInfoCountry", item.getString("UTF-8"));
					else if(item.getFieldName().equals("wineInfoRegion"))
						request.setAttribute("wineInfoRegion", item.getString());
					else if(item.getFieldName().equals("wineInfoWinery"))
						request.setAttribute("wineInfoWinery", item.getString());
					else if(item.getFieldName().equals("wineInfoImporter"))
						request.setAttribute("wineInfoImporter", item.getString());
					else if(item.getFieldName().equals("wineInfoVintage"))
						request.setAttribute("wineInfoVintage", item.getString());
					else if(item.getFieldName().equals("wineInfoGrapes"))
						request.setAttribute("wineInfoGrapes", item.getString());
					else if(item.getFieldName().equals("wineInfoABV"))
						request.setAttribute("wineInfoABV", item.getString());
					else if(item.getFieldName().equals("wineInfoType"))
						request.setAttribute("wineInfoType", item.getString());
					else if(item.getFieldName().equals("wineInfoClassification"))
						request.setAttribute("wineInfoClassification", item.getString());
					else if(item.getFieldName().equals("wineInfoFlavors"))
						request.setAttribute("wineInfoFlavors", item.getString());
					else if(item.getFieldName().equals("wineInfoSweetness"))
						request.setAttribute("wineInfoSweetness", item.getString());
					else if(item.getFieldName().equals("wineInfoAcidity"))
						request.setAttribute("wineInfoAcidity", item.getString());
					else if(item.getFieldName().equals("wineInfoBody"))
						request.setAttribute("wineInfoBody", item.getString());
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
			}
			request.setAttribute("wineSellerId", session.getAttribute("basicInfoUsername"));
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
		catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
