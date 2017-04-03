package dionysus.wine.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dionysus.wine.daoimpl.*;
import dionysus.wine.di.*;
import dionysus.wine.serviceimpl.*;
import dionysus.wine.vo.*;

@WebServlet({"/main/*", "/basic/*", "/wineinfo/*", "/res/*", "/resinfo/*", "/customer/*", "/manager/*", "/notice/*", "/wineinfo/wineorder/*"})
public class DispatcherServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext context = getServletContext();
		//	1. 기본정보 DAO, SERVICE 객체화
		BasicInfoDAOImpl basicinfodao= new BasicInfoDAOImpl();
		BasicInfoServiceImpl basicinfoservice= new BasicInfoServiceImpl(basicinfodao);
		context.setAttribute("basicinfoservice", basicinfoservice);
		//	2. 와인정보 DAO, SERVICE 객체화
		WineInfoDAOImpl wineinfodao= new WineInfoDAOImpl();
		WineInfoServiceImpl wineinfoservice= new WineInfoServiceImpl(wineinfodao);
		context.setAttribute("wineinfoservice", wineinfoservice);
		//  3. 레스토랑 정보 DAO, SERVICE 객체화
		ResInfoDaoImpl resInfodao = new ResInfoDaoImpl();
		ResInfoServiceImpl resInfoservice = new ResInfoServiceImpl(resInfodao);
		context.setAttribute("resInfoservice", resInfoservice);
		//	4. 와인주문 DAO, SERVICE 객체화
		WineOrderDAOImpl wineOrderDao= new WineOrderDAOImpl();
		WineOrderServiceImpl wineOrderService= new WineOrderServiceImpl(wineOrderDao);
		context.setAttribute("wineOrderService", wineOrderService);
		// 5. 레스토랑 사업자 회원 DAO.SERVICE 객체화
		ResDaoImpl	resDao= new ResDaoImpl();
		ResServiceImpl resservice= new ResServiceImpl(resDao);
		context.setAttribute("resservice", resservice);
		//	6. 공지사항 DAO, SERVICE 객체화
		NoticeImpl noticeDAO= new NoticeImpl();
		NoticeServiceImpl noticeService= new NoticeServiceImpl(noticeDAO);
		context.setAttribute("noticeService", noticeService);
		//	7. 고객 DAO, SERVICE 객체화
		CustomerDAOImpl customerDAO= new CustomerDAOImpl();
		CustomerServiceImpl customerService= new CustomerServiceImpl(customerDAO);
		context.setAttribute("customerService", customerService);
		
		String path = getServletContext().getRealPath("/");
		String packageName = getServletContext().getInitParameter("packageName");
		AnnotationRunner.getRequestMapping(path, packageName);
		
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = AnnotationRunner.execute(request);
		if(mav.getView()==null) {
			HashMap<String,Object> model = mav.getModel();
			response.setContentType("application/x-json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(model.get("result"));
			out.flush();
		}
		else {
			if (mav.isRedirect() == false) {
				HashMap<String,Object> model = mav.getModel();
				Set<String> set = model.keySet();
				for(String name:set)
					request.setAttribute(name, model.get(name));
				RequestDispatcher rd = request.getRequestDispatcher(mav.getView());
				rd.forward(request, response);
			} else {
				String destination = mav.getView();
				if(mav.getView().equals("/")) 
					destination = "/" + request.getServletContext().getInitParameter("webappName");
				System.out.println(destination);
				response.sendRedirect(destination);
			}
		}	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
