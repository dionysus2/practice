package dionysus.wine.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter({"/basic/*", "/customer/*", "/res/*", "/notice/*", "/resinfo/*", "/wineinfo/*", "/manager/*", "/notice/*"})
public class LoginFilter implements Filter {
	private Logger logger= LoggerFactory.getLogger(LoginFilter.class);
	private ArrayList<String> whiteList= new ArrayList<String>();
	//	로그인 없이 접근할 수 있는 경로를 지정
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    	whiteList.add("/dionysus/basic/main");
    	whiteList.add("/dionysus/index.html");
    	whiteList.add("/dionysus/basic/insert");
    	whiteList.add("/dionysus/customer/login");
    	whiteList.add("/dionysus/manager/login");
    	whiteList.add("/dionysus/res/list");
    	whiteList.add("/dionysus/notice/list");
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req= (HttpServletRequest)request;
		HttpServletResponse res= (HttpServletResponse)response;
		HttpSession session= req.getSession();
		//	/dionysus/list?pageNo=1일 경우 /dionysus/list를 짤라낸다.
		String uri= req.getRequestURI();
		String go= uri;
		String basicInfoUsername= (String)session.getAttribute("basicInfoUsername");
		logger.info("현재 접속된 세션아이디"+""+basicInfoUsername);
		if(!whiteList.contains(uri)&&  basicInfoUsername==null){
			go= "/dionysus/main/home";
			session.setAttribute("go", uri);
			if(req.getParameter("basicInfoId")!=null)
				session.setAttribute("basicInfoId", req.getParameter("basicInfoId"));
				//	basicInfoUsername이 null이 아니었을시 basicInfoId값도 session에 저장한다
				//	로그아웃시에는 모든것을 remove하여야 한다.
			res.sendRedirect(go);
		}
		else{
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}

