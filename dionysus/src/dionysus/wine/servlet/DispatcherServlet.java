package dionysus.wine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dionysus.wine.di.AnnotationRunner;
import dionysus.wine.di.ModelAndView;

@WebServlet("/sellers/wineinfo/*")
public class DispatcherServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext context = getServletContext();
		//	context.setAttribute("service", service);
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
			System.out.println(model.get("result"));
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
		process(request, response);
	}
}
